package Items;

public class InvItem<I> {

    //this is a universal item that is represented in the inventory
    //it points to all the different types of items
    //this will mean, however, that every item must have its own unique name regardless of type now

    public I item;
    public int amount;
    public String name;

    public InvItem(I item) {
        this.item = item;
        this.amount = 1;
    }

    public void amount(int amt) {
        this.amount = amt;
    }

}
