public class Item {
    private String itemId;
    private Volume volume;
    public Shelf shelf;

    public Item(String itemId, Volume volume) {
        this.itemId = itemId;
        this.volume = volume;
    }

    public String getItemId() {
        return itemId;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Volume getVolume() {
        return volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }
}
