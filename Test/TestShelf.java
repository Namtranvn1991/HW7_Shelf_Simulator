import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.*;
import java.util.*;

public class TestShelf {



    @BeforeEach
    void setUp() {
        Volume shelfVolume = new Volume(100, 200, 50); // width, height, depth
        Shelf shelf = new Shelf("S1", shelfVolume, 10);
        Volume itemVolume = new Volume(20, 30, 30);
        Item item = new Item("I1", itemVolume);
    }

    @Test
    public void testInitialization() {
        Volume shelfVolume = new Volume(100, 200, 50); // width, height, depth
        Shelf shelf = new Shelf("S1", shelfVolume, 10);

        assertEquals(200, shelf.remainingWidth, 0.001);
        assertFalse(shelf.isFull());
        assertTrue(shelf.items.isEmpty());
    }

    @Test
    public void testAddItem() {
        Volume shelfVolume = new Volume(100, 200, 50); // width, height, depth
        Shelf shelf = new Shelf("S1", shelfVolume, 10);
        Volume itemVolume = new Volume(20, 30, 30);
        Item item = new Item("I1", itemVolume);

        shelf.addItem(item);

        assertEquals(170, shelf.remainingWidth, 0.001);
        assertTrue(shelf.items.contains(item));
        assertEquals(shelf, item.getShelf());
    }

    @Test
    public void testRemoveItem() {
        Volume shelfVolume = new Volume(100, 200, 50); // width, height, depth
        Shelf shelf = new Shelf("S1", shelfVolume, 10);
        Volume itemVolume = new Volume(20, 30, 30);
        Item item = new Item("I1", itemVolume);

        shelf.addItem(item);

        assertTrue(shelf.items.contains(item));
        assertNotNull(item.getShelf());

        shelf.removeItem(item);

        assertFalse(shelf.items.contains(item));
        assertNull(item.getShelf());
    }

    @Test
    public void testCheckCanAddItem() {
        Volume shelfVolume = new Volume(100, 200, 50); // width, height, depth
        Shelf shelf = new Shelf("S1", shelfVolume, 10);

        Volume itemVolume = new Volume(20, 30, 30);
        Item item = new Item("I1", itemVolume);
        assertTrue(shelf.checkCanAddItem(item));

        Volume bigVolume = new Volume(200, 30, 30);
        Item bigItem = new Item("I2", bigVolume);
        assertFalse(shelf.checkCanAddItem(bigItem));

        Volume tallVolume = new Volume(110, 50, 30);
        Item tallItem = new Item("I3", tallVolume);
        assertFalse(shelf.checkCanAddItem(tallItem));

        Volume depthVolume = new Volume(50, 50, 70);
        Item depthItem = new Item("I4", depthVolume);
        assertFalse(shelf.checkCanAddItem(depthItem));

    }


    @Test
    public void testCheckFull() {
        Volume shelfVolume = new Volume(100, 200, 50); // width, height, depth
        Shelf shelf = new Shelf("S1", shelfVolume, 10);

        Volume v = new Volume(95, 195, 30); // almost full
        Item bigItem = new Item("bigItem", v);
        shelf.addItem(bigItem);

        assertTrue(shelf.isFull());
    }

    @Test
    public void testNotFullAfterRemove() {
        Volume shelfVolume = new Volume(100, 200, 50); // width, height, depth
        Shelf shelf = new Shelf("S1", shelfVolume, 10);

        Volume v = new Volume(95, 190, 30);
        Item bigItem = new Item("bigItem", v);

        shelf.addItem(bigItem);
        assertTrue(shelf.isFull());

        shelf.removeItem(bigItem);
        assertFalse(shelf.isFull());
    }
}
