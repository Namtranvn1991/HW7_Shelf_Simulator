import java.util.ArrayList;
import java.util.List;

public class Shelf extends StorageUnit implements Comparable<Shelf> {
    public List<Item> items;
    public double remainingWidth;
    public double minimumWidth;

    public Shelf(String id, Volume volume, double minimumWidth) {
        super(id, volume);
        items = new ArrayList<Item>();
        this.remainingWidth = getVolume().getWidth();
        this.minimumWidth = minimumWidth;
    }

    public Shelf addItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null.");
        }

        if (!checkCanAddItem(item)) {
            throw new IllegalArgumentException("Item cannot fit on this shelf.");
        }

        items.add(item);
        item.setShelf(this);
        remainingWidth -= item.getVolume().getWidth();
        checkFull();

        return this;
    }

    public void removeItem(Item item){
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null.");
        }

        if (items.contains(item)){
            items.remove(item);
            item.setShelf(null);
            remainingWidth += item.getVolume().getWidth();
            checkFull();
        }
    }


    public boolean checkCanAddItem(Item item){
        if (isFull()) return false;
        if (item.getVolume().getHeight() > this.getVolume().getHeight()) return false;
        if (item.getVolume().getDepth() > this.getVolume().getDepth()) return false;
        if (item.getVolume().getWidth() > remainingWidth) {
            return false;
        }
        return true;
    }

    public void checkFull(){
        if (remainingWidth <= minimumWidth){
            setFull(true);
        } else
        {
            setFull(false);
        }
    }

    @Override
    public int compareTo(Shelf o) {
        return Double.compare(o.remainingWidth, this.remainingWidth);
    }

    public double getUsedWidth() {
        return getVolume().getWidth() - remainingWidth;
    }

    public double getUtilizationRate() {
        return getUsedWidth() / getVolume().getWidth();
    }

    public int getItemCount() {
        return items.size();
    }

    public void displayShelfInfo() {
        System.out.println("Shelf ID: " + getId());
        System.out.println("Remaining width: " + remainingWidth);
        System.out.println("Item count: " + items.size());
        System.out.println("Utilization rate: " + getUtilizationRate());
    }
}
