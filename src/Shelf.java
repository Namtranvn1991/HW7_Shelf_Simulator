import java.util.ArrayList;
import java.util.List;

public class Shelf extends StorageUnit implements Comparable<Shelf> {
    public List<Item> items;
    public double remainingWidth;
    public double minimumWidth;

    public Shelf(String id, Volume volume,  List<Item> items) {
        super(id, volume);
        items = new ArrayList<Item>();
        this.remainingWidth = getVolume().getWidth();

    }

    public boolean addItem(Item item){
        boolean canAdd = checkCanAddItem(item);
        if (canAdd){
            items.add(item);
            remainingWidth -= item.getVolume().getWidth();
            if (remainingWidth < minimumWidth){
                setFull(true);
            }
        }
        return canAdd;
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


    @Override
    public int compareTo(Shelf o) {
        if (remainingWidth < o.remainingWidth) return -1;
        if (remainingWidth > o.remainingWidth) return 1;
        return 0;
    }
}
