import java.util.List;
import java.util.PriorityQueue;

public class Storage {
    public static List<Shelf> allShelves;
    public static PriorityQueue<Shelf> availableShelves;
    public static List<Item> items;

    //availableShelves is PriorityQueue because it helps us can find properly shelf faster
    public static void add(Shelf shelf) {
        allShelves.add(shelf);
        availableShelves.add(shelf);
    }
}
