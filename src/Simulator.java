import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public Shelf findShelfOfItem(String itemId) {
        Item item = findItem(itemId);
        if (item == null) return null;
        return item.getShelf();
    }

    public Shelf findShel(String shelfId) {
        for (Shelf shelf: storage.allShelves){
            if(shelf.getId().equals(shelfId)){
                return shelf;
            }
        }
        return null;
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
        storage = new Storage();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== SHELF SIMULATOR ===");

        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Shelf");
            System.out.println("2. Add Item");
            System.out.println("3. Remove Item");
            System.out.println("4. Search Item");
            System.out.println("5. Display All Shelves");
            System.out.println("6. Display All Items");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    // Add Shelf
                    System.out.print("Enter Shelf ID: ");
                    String shelfId = scanner.nextLine().trim();

                    Shelf shelfCheck = findShel(shelfId);
                    if (shelfCheck != null) {
                        System.out.println("Already have shelf with ID: " + shelfId);
                        continue;
                    }

                    System.out.print("Enter height: ");
                    double h = Double.parseDouble(scanner.nextLine().trim());
                    System.out.print("Enter width: ");
                    double w = Double.parseDouble(scanner.nextLine().trim());
                    System.out.print("Enter depth: ");
                    double d = Double.parseDouble(scanner.nextLine().trim());

                    System.out.print("Enter max items capacity: ");
                    int capacity = Integer.parseInt(scanner.nextLine().trim());

                    Shelf shelf = new Shelf(shelfId, new Volume(h, w, d), capacity);
                    addShelf(shelf);
                    System.out.println("Shelf '" + shelfId + "' added successfully.");
                }

                case 2 -> {
                    // Add Item
                    System.out.print("Enter Item ID: ");
                    String itemId = scanner.nextLine().trim();

                    Item itemCheck = findItem(itemId);
                    if (itemCheck != null) {
                        System.out.println("Already have item with ID: " + itemId);
                        continue;
                    }


                    System.out.print("Enter height: ");
                    double h = Double.parseDouble(scanner.nextLine().trim());
                    System.out.print("Enter width: ");
                    double w = Double.parseDouble(scanner.nextLine().trim());
                    System.out.print("Enter depth: ");
                    double d = Double.parseDouble(scanner.nextLine().trim());

                    Item item = new Item(itemId, new Volume(h, w, d));
                    Shelf placed = addItem(item);
                    if (placed != null) {
                        System.out.println("Item '" + itemId + "' placed on shelf: " + item.getShelf().getId());
                    } else {
                        System.out.println("No available shelf fits item '" + itemId + "'.");
                    }
                }

                case 3 -> {
                    // Remove Item
                    System.out.print("Enter Item ID to remove: ");
                    String itemId = scanner.nextLine().trim();
                    Item item = findItem(itemId);
                    Shelf shelf = removeItem(item);
                    if (shelf != null) {
                        System.out.println("Item '" + itemId + "' removed.");
                    } else {
                        System.out.println("Item '" + itemId + "' not found.");
                    }
                }

                case 4 -> {
                    // Search Item
                    System.out.print("Enter Item ID to search: ");
                    String itemId = scanner.nextLine().trim();
                    Item found = findItem(itemId);
                    if (found != null) {
                        System.out.println("Found: " + found);
                    } else {
                        System.out.println("Item '" + itemId + "' not found.");
                    }
                }

                case 5 -> displayAllShelves();

                case 6 -> displayAllItems();

                case 0 -> {
                    running = false;
                    System.out.println("Exiting simulator. Goodbye!");
                }

                default -> System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }

    void main() {
        runSimulator();
    }
}
