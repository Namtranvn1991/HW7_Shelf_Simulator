public abstract class  StorageUnit {
    private String id;
    private Volume volume;
    private boolean isFull;

    public StorageUnit(String id, Volume volume) {
        this.id = id;
        this.volume = volume;
        this.isFull = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Volume getVolume() {
        return volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }
}
