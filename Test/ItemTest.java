import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void testConstructorAndGetters() {
        Volume v = new Volume(10, 20, 30);
        Item item = new Item("I1", v);

        assertEquals("I1", item.getItemId());
        assertEquals(v, item.getVolume());
        assertNull(item.getShelf());
    }

    @Test
    void testSetItemId() {
        Item item = new Item("I1", new Volume(20,30,40));

        item.setItemId("I2");

        assertEquals("I2", item.getItemId());
    }

    @Test
    void testSetVolume() {
        Item item = new Item("I1", new Volume(1,1,1));
        Volume newVolume = new Volume(5, 6, 7);

        item.setVolume(newVolume);

        assertEquals(newVolume, item.getVolume());
    }

    @Test
    void testSetShelf() {
        Item item = new Item("I1", new Volume(10,20,30));
        Shelf shelf = new Shelf("S1", new Volume(100,50,50), 10);

        item.setShelf(shelf);

        assertEquals(shelf, item.getShelf());
    }
}