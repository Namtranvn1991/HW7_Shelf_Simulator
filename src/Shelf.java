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

    public Shelf addItem(Item item){
        items.add(item);
        item.setShelf(this);
        remainingWidth -= item.getVolume().getWidth();
        checkFull();
        return this;
    }

    public void removeItem(Item item){
        if (items.contains(item)){
            items.remove(item);
            item.setShelf(null);
            remainingWidth += item.getVolume().getWidth();
            checkFull();
        }
    }


    public boolean checkCanAddItem(Item item){
        if (isFull()) return false;
        if (item.getVolume().getHeight() >= this.getVolume().getHeight()) return false;
        if (item.getVolume().getDepth() >= this.getVolume().getDepth()) return false;
        if (remainingWidth > item.getVolume().getWidth()){
            return true;
        }
        return false;
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
        if (remainingWidth < o.remainingWidth) return -1;
        if (remainingWidth > o.remainingWidth) return 1;
        return 0;
    }
}
