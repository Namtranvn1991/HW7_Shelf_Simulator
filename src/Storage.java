import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1. shelf must not be null
 * 2. shelf must not already exist in allShelves
 * 3. shelf must be comparable for PriorityQueue ordering
 */
public class Storage {
    public List<Shelf> allShelves = new ArrayList<>();
    public PriorityQueue<Shelf> availableShelves = new PriorityQueue<>();
    public List<Item> items = new ArrayList<>();

    Storage() {
        availableShelves = new PriorityQueue<>();
        items = new ArrayList<>();
        allShelves = new ArrayList<>();
    }

    //availableShelves is PriorityQueue because it helps us can find properly shelf faster
    public void add(Shelf shelf) {
        allShelves.add(shelf);
        availableShelves.add(shelf);
    }

}
