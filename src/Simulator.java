import java.util.ArrayList;
import java.util.List;

public class Simulator {
    public Storage storage;

    public void addShelf(Shelf shelf) {
        Storage.allShelves.add(shelf);
        Storage.availableShelves.add(shelf);
    }

    // add item into available Shelf and update availableShelves
    public Shelf addItem(Item item) {
        List<Shelf> temp = new ArrayList<>();

        while (!Storage.availableShelves.isEmpty()) {
            Shelf shelf = Storage.availableShelves.poll();

            if (shelf.checkCanAddItem(item)) {
                Shelf shelfCanAdd = shelf.addItem(item);
                if (!shelf.isFull()) {
                    Storage.availableShelves.add(shelf);
                }
                Storage.availableShelves.addAll(temp);
                Storage.items.add(item);
                return shelfCanAdd;
            } else {
                temp.add(shelf);
            }
        }
        Storage.availableShelves.addAll(temp);
        return null;
    }

    // remove item and update availableShelves
    public Shelf removeItem(Item item) {
        Shelf shelf = item.getShelf();

        if (shelf == null) return null;

        Storage.availableShelves.remove(shelf);

        shelf.removeItem(item);
        if (!shelf.isFull()) {
            Storage.availableShelves.add(shelf);
        }
        Storage.items.remove(item);

        return shelf;
    }

    //find item in shelves with id
    public Item findItem(String itemId) {
        for (Item item: Storage.items){
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
        for (Shelf shelf : Storage.allShelves) {
            shelf.displayShelfInfo();
            System.out.println();
        }
    }

    public void displayAllItems() {
        for (Item item : Storage.items) {
            System.out.println("Item ID: " + item.getItemId());

            if (item.getShelf() != null) {
                System.out.println("Stored in shelf: " + item.getShelf().getId());
            } else {
                System.out.println("Not stored");
            }

            System.out.println();
        }
    }
}
