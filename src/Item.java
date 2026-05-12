public class Item {
    private String itemId;
    private Volume volume;
    private Shelf shelf;

    /*
     * Preconditions:
     * 1. itemId must not be null or empty
     * 2. volume must not be null
     *
     * Postconditions:
     * 1. itemId and volume are initialized
     * 2. shelf is initially null
     */

    public Item(String itemId, Volume volume) {
        if (itemId == null || itemId.isEmpty()) {
            throw new IllegalArgumentException(
                    "Item ID cannot be null or empty.");
        }

        if (volume == null) {
            throw new IllegalArgumentException(
                    "Volume cannot be null.");
        }

        this.itemId = itemId;
        this.volume = volume;
        this.shelf = null;
    }



    public String getItemId() {
        return itemId;
    }

    /*
     * Preconditions:
     * 1. itemId must not be null or empty
     */

    public void setItemId(String itemId) {
        if (itemId == null || itemId.isEmpty()) {
            throw new IllegalArgumentException(
                    "Item ID cannot be null or empty.");
        }

        this.itemId = itemId;
    }

    public Volume getVolume() {
        return volume;
    }

    /*
     * Preconditions:
     * 1. volume must not be null
     */

    public void setVolume(Volume volume) {
        if (volume == null) {
            throw new IllegalArgumentException(
                    "Volume cannot be null.");
        }
        this.volume = volume;
    }

    public Shelf getShelf() {
        return shelf;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }

    @Override
    public String toString() {
        return "Item ID: " + itemId
                + ", Volume: " + volume;
    }
}
