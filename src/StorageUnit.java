/*
 * Preconditions:
 * 1. id must not be null or empty.
 * 2. volume must not be null.
 *
 * Postconditions:
 * 1. id is initialized.
 * 2. volume is initialized.
 * 3. isFull is initialized as false.
 */

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

    /*
     * Preconditions:
     * 1. id must not be null or empty.
     *
     * Postconditions:
     * 1. id is updated.
     */
    public void setId(String id) {
        this.id = id;
    }

    public Volume getVolume() {
        return volume;
    }

    /*
     * Preconditions:
     * 1. volume must not be null.
     *
     * Postconditions:
     * 1. volume is updated.
     */
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
