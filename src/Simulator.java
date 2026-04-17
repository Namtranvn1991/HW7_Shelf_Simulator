import java.util.List;

public class Simulator {
    public Storage storage;
    public List<Item> items;

    public void addShelf(Shelf shelf) {
        storage.shelves.add(shelf);
    }

    public void addItem(Item item) {
        items.add(item);
        //find shelf can add then add into the shelf
    }

    public Item findItem(String itemId) {
        //find item in shelves with id
        return null;
    }

    public Shelf findShelf(String itemId) {
        //find shelf contain the item
        return null;
    }
}
