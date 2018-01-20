package bcpack;

public class Bag {

    private Item[] slotArray;

    public Bag(){
        this.setSlotArray(new Item[20]);
    }



    public Item[] getSlotArray() {
        return slotArray;
    }

    public void setSlotArray(Item[] slotArray) {
        this.slotArray = slotArray;
    }
}
