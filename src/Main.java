public class Main {
    public static void main(String[] args) {
        Simulator simulator = new Simulator();

        Shelf shelf1 = new Shelf("S1", new Volume(10, 100, 50), 5);
        Shelf shelf2 = new Shelf("S2", new Volume(8, 60, 40), 5);

        simulator.addShelf(shelf1);
        simulator.addShelf(shelf2);

        Item item1 = new Item("I1", new Volume(5, 20, 30));
        Item item2 = new Item("I2", new Volume(7, 50, 35));
        Item item3 = new Item("I3", new Volume(12, 10, 10)); // too tall

        simulator.addItem(item1);
        simulator.addItem(item2);

        Shelf failedShelf = simulator.addItem(item3);
        if (failedShelf == null) {
            System.out.println("Item I3 could not be stored.");
        }

        simulator.displayAllShelves();
        simulator.displayAllItems();

        simulator.removeItem(item1);

        System.out.println("After removing I1:");
        simulator.displayAllShelves();
        simulator.displayAllItems();
    }
}