package Main;

public class Item {

    String name;
    //double volume; //will implement this later as the max total items in an inventory
    int amount;

    public Item(String name) {
        this.name = name;
        this.amount = 1;
    }
}
