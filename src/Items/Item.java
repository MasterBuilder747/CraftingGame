package Items;

public class Item {

    public String name;
    //double volume; //will implement this later as the max total items in an inventory
    public int amount;

    public Item(String name) {
        this.name = name;
        this.amount = 1;
    }
}
