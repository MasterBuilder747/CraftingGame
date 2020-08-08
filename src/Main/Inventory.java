package Main;

import java.util.ArrayList;

public class Inventory {

    ArrayList<Item> inv = new ArrayList<>();

    //add one class type item of a amount to inventory
    public void add(Item item, int a) {
        if (this.get(item) != null) {
            (this.get(item).amount) += a;
        } else {
            item.amount = a;
            this.inv.add(item);
        }
    }

    //remove one class type item of a amount from inventory
    public void remove(Item item, int a) {
        if (this.get(item) != null) {
            int amount = this.get(item).amount;
            if (amount > a) {
                this.get(item).amount -= a;
            } else if (amount == a) {
                this.inv.remove(item);
            } else {
                System.out.println("You are removing more items than what is in your inventory.");
            }
        } else {
            System.out.println("Item does not exist in inventory.");
        }
    }

    //check if item exists in inventory
    public boolean has(Item item) {
        return this.inv.contains(item);
    }

    //get the class type of the item if it exists, otherwise null
    public Item get(Item item) {
        if (this.has(item)) {
            return this.inv.get(this.inv.indexOf(item));
        } else {
            return null;
        }
    }

    //get the amount of an item in an inventory
    public int amount(Item item) {
        if (this.get(item) != null) {
            return this.get(item).amount;
        } else {
            return 0;
        }
    }

    //process a simple recipe with one of each item type of a and b amounts
    public void doRecipe(Recipe r) {
        if (this.has(r.input)) {
            if (this.amount(r.input) >= r.input.amount) {
                this.remove(r.input, r.inAmount);
                this.add(r.output, r.outAmount);
            }
        }
    }

    //shows the current inventory
    public void print() {
        System.out.println("Your inventory:");
        System.out.println("Amount x Item");
        for (Item item : this.inv) {
            System.out.println(item.amount + " x \t" + item.name);
        }
        System.out.println();
    }
}
