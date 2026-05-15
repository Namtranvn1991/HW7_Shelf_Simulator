import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

class SimulatorTest {
    private Simulator simulator;
    private Storage storage;


    void setUp() {
        storage = new Storage();
        storage.allShelves = new ArrayList<>();
        storage.availableShelves = new PriorityQueue<>();
        storage.items = new ArrayList<>();
        simulator = new Simulator();
    }

    @Test
    void testAddShelf() {
        setUp();
        Shelf shelf = new Shelf("S1", new Volume(100, 50, 50), 10);

        simulator.addShelf(shelf);

        assertTrue(storage.allShelves.contains(shelf));
        assertTrue(storage.availableShelves.contains(shelf));
    }

    @Test
    void testAddItemSuccess() {
        setUp();
        Shelf shelf = new Shelf("S1", new Volume(100, 50, 50), 10);
        simulator.addShelf(shelf);

        Item item = new Item("I1", new Volume(20, 10, 10));

        Shelf result = simulator.addItem(item);

        assertNotNull(result);
        assertEquals(shelf, result);
        assertEquals(shelf, item.getShelf());
        assertTrue(storage.items.contains(item));
    }

    @Test
    void testAddItemNoFit() {
        setUp();
        Shelf shelf = new Shelf("S1", new Volume(10, 5, 5), 1);
        simulator.addShelf(shelf);

        Item item = new Item("I1", new Volume(50, 10, 10)); // too big

        Shelf result = simulator.addItem(item);

        assertNull(result);
        assertNull(item.getShelf());
        assertFalse(storage.items.contains(item));
    }

    @Test
    void testRemoveItem() {
        setUp();
        Shelf shelf = new Shelf("S1", new Volume(100, 50, 50), 10);
        simulator.addShelf(shelf);

        Item item = new Item("I1", new Volume(20, 10, 10));
        simulator.addItem(item);

        try {
            Shelf result = simulator.removeItem(item);
            assertEquals(shelf, result);
            assertNull(item.getShelf());
            assertFalse(storage.items.contains(item));
        } catch (ShelfSimulatorException e) {
            System.err.println(e.getMessage());
        }



    }

    @Test
    void testRemoveItemNotInShelf() {
        setUp();
        Item item = new Item("I1", new Volume(10,10,10));

        try {
            Shelf result = simulator.removeItem(item);

            assertNull(result);
        } catch (ShelfSimulatorException e) {
            System.err.println(e.getMessage());
        }

    }

    @Test
    void testFindItem() {
        setUp();
        Shelf shelf = new Shelf("S1", new Volume(100, 50, 50), 10);
        simulator.addShelf(shelf);

        Item item = new Item("I1", new Volume(20, 10, 10));
        simulator.addItem(item);

        Item found = simulator.findItem("I1");

        assertNotNull(found);
        assertEquals(item, found);
    }

    @Test
    void testFindItemNotFound() {
        setUp();
        Item found = simulator.findItem("UNKNOWN");

        assertNull(found);
    }

    @Test
    void testFindShelf() {
        setUp();
        Shelf shelf = new Shelf("S1", new Volume(100, 50, 50), 10);
        simulator.addShelf(shelf);

        Item item = new Item("I1", new Volume(20, 10, 10));
        simulator.addItem(item);

        Shelf foundShelf = simulator.findShelfOfItem("I1");

        assertEquals(shelf, foundShelf);
    }

    @Test
    void testFindShelfItemNotFound() {
        setUp();
        assertNull(simulator.findShelfOfItem("UNKNOWN"));
    }
}