import java.util.ArrayList;
import java.util.List;

/**
 * Simulation controller.
 * Handles adding/removing items and managing shelves.
 */

public class Simulator {
    public Storage storage;

    public void addShelf(Shelf shelf) {
        storage.allShelves.add(shelf);
        storage.availableShelves.add(shelf);
    }

    // add item into available Shelf and update availableShelves
    /**
     * Attempts to place an item into an available shelf.
     * Uses priority queue to select best shelf.
     *
     * @param item item to add
     * @return shelf where item was placed, null if failed
     */
    public Shelf addItem(Item item) {
        List<Shelf> temp = new ArrayList<>();

        while (!storage.availableShelves.isEmpty()) {
            Shelf shelf = storage.availableShelves.poll();

            if (shelf.checkCanAddItem(item)) {
                Shelf shelfCanAdd = shelf.addItem(item);
                if (!shelf.isFull()) {
                    storage.availableShelves.add(shelf);
                }
                storage.availableShelves.addAll(temp);
                storage.items.add(item);
                return shelfCanAdd;
            } else {
                temp.add(shelf);
            }
        }
        storage.availableShelves.addAll(temp);
        return null;
    }

    // remove item and update availableShelves
    public Shelf removeItem(Item item) {
        Shelf shelf = item.getShelf();

        if (shelf == null) return null;

        storage.availableShelves.remove(shelf);

        shelf.removeItem(item);
        if (!shelf.isFull()) {
            storage.availableShelves.add(shelf);
        }
        storage.items.remove(item);

        return shelf;
    }

    //find item in shelves with id
    public Item findItem(String itemId) {
        for (Item item: storage.items){
            if(item.getItemId().equals(itemId)){
                return item;
            }
        }
        return null;
    }

    public Shelf findShelf(String itemId) {
        Item item = findItem(itemId);
        if (item == null) return null;
        return item.getShelf();
    }

    public void displayAllShelves() {
        for (Shelf shelf : storage.allShelves) {
            shelf.displayShelfInfo();
            System.out.println();
        }
    }

    public void displayAllItems() {
        for (Item item : storage.items) {
            System.out.println("Item ID: " + item.getItemId());

            if (item.getShelf() != null) {
                System.out.println("Stored in shelf: " + item.getShelf().getId());
            } else {
                System.out.println("Not stored");
            }

            System.out.println();
        }
    }

    public void runSimulator(){

    }

    void main() {

    }
}
