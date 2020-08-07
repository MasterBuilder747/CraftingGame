package Main;

import java.util.ArrayList;

public class Inventory {

    ArrayList<Item> inv = new ArrayList<>();

    public void add(Item item, int a) {
        if (this.has(item)) {
            (this.inv.get(this.inv.indexOf(item)).amount) += a;
        } else {
            item.amount = a;
            this.inv.add(item);
        }
    }

    public void remove(Item item, int a) {
        if (this.has(item)) {
            if (this.inv.get(this.inv.indexOf(item)).amount > a) {
                (this.inv.get(this.inv.indexOf(item)).amount) -= a;
            } else if (this.inv.get(this.inv.indexOf(item)).amount == a) {
                this.inv.remove(item);
            } else {
                System.out.println("You are removing more items than what is in your inventory.");
            }
        } else {
            System.out.println("Item does not exist in inventory.");
        }
    }

    public boolean has(Item item) {
        return this.inv.contains(item);
    }

    public int amount(Item item) {
        if (this.has(item)) {
            return this.inv.get(this.inv.indexOf(item)).amount;
        } else {
            return 0;
        }
    }

    public void doRecipe(Recipe r) {
        if (this.has(r.input)) {
            if (this.amount(r.input) >= r.input.amount) {
                this.remove(r.input, r.inAmount);
                this.add(r.output, r.outAmount);
            }
        }
    }

    public void print() {
        System.out.println("Your inventory:");
        System.out.println("Amount x Item");
        for (Item item : this.inv) {
            System.out.println(item.amount + " x \t" + item.name);
        }
        System.out.println();
    }
}
