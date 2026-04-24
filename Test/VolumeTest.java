import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class VolumeTest {

    @Test
    public void testInitialization() {
        Volume v = new Volume(10, 20, 30);

        assertEquals(10, v.getHeight(), 000.1);
        assertEquals(20, v.getWidth(), 000.1);
        assertEquals(30, v.getDepth(), 000.1);
    }


    @Test
    void testSetters() {
        Volume v = new Volume(1, 1, 1);

        v.setHeight(5);
        v.setWidth(6);
        v.setDepth(7);

        assertEquals(5, v.getHeight(), 000.1);
        assertEquals(6, v.getWidth(), 000.1);
        assertEquals(7, v.getDepth(), 000.1);
    }

    @Test
    void testGetVolume() {
        Volume v = new Volume(2, 3, 4);
        assertEquals(24, v.getVolume(), 000.1);
    }

    @Test
    void testGetBottomArea() {
        Volume v = new Volume(10, 5, 2);
        assertEquals(10, v.getBottomArea(), 000.1);
    }
}