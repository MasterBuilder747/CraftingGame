package Main;

import java.util.ArrayList;

public class Inventory {

    ArrayList<Item> inv = new ArrayList<>();

    //Item addition/removal
    //add one class type item of a amount to inventory
    public void add(Item item, int a) {
        if (a > 0) {
            if (this.get(item) != null) {
                this.get(item).amount += a;
            } else {
                item.amount = a;
                this.inv.add(item);
            }
        } else {
            throw new IllegalArgumentException("Cannot add an amount of 0 or less of items");
        }
    }
    public void add(Item[] item, int[] a) {
        if (item.length == a.length) {
            for (int i = 0; i < item.length; i++) {
                this.add(item[i], a[i]);
            }
        } else {
            throw new IllegalArgumentException("item array size must be the same as amount array size");
        }
    }
    //remove one class type item of a amount from inventory
    public void remove(Item item, int a) {
        if (this.get(item) != null) {
            int amount = this.amount(item);
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
    public void remove(Item[] item, int[] a) {
        if (item.length == a.length) {
            for (int i = 0; i < item.length; i++) {
                this.remove(item[i], a[i]);
            }
        } else {
            throw new IllegalArgumentException("item array size must be the same as amount array size");
        }
    }

    //Utilities
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

    //Recipes
    //process a simple recipe with one of each item type of a and b amounts
    public void doRecipe(Recipe r) {
        if (r.input.length == 1 && r.output.length == 1) {
            //Singular recipe (1 input, 1 output)
            Item in = r.getInput(0);
            Item out = r.getOutput(0);
            if (this.has(in)) {
                if (this.amount(in) >= r.getAmountIn(0)) {
                    this.remove(in, r.getAmountIn(0));
                    this.add(out, r.getAmountOut(0));
                } else {
                    int amt = r.getInput(0).amount;
                    if (amt == 1) {
                        System.out.println("Missing 1 " + r.getInput(0).name);
                    } else {
                        System.out.println("Missing " + amt + r.getInput(0).name + "s");
                    }
                }
            } else {
                System.out.println("You don't have any " + r.getInput(0).name + "s");
            }
        } else {
            //Multiple recipe (multiple inputs, multiple outputs)
            //make sure all the items exist in the inventory, regardless of amounts right now
            //this may be redundant
            ArrayList<Item> missing = new ArrayList<>();
            int j = 0;
            for (int i = 0; i < r.input.length; i++) {
                if (this.amount(r.input[i]) < r.getAmountIn(i)) {
                    missing.add(r.input[i]);
                    missing.get(j).amount = r.getAmountIn(i) - this.amount(r.input[i]);
                    j++;
                }
            }
            //now check amounts
            if (missing.size() == 0) {
                this.remove(r.input, r.inAmount);
                this.add(r.output, r.outAmount);
            } else {
                this.printMissing(missing);
            }
        }
    }

    //Display
    //entire inventory
    public void print() {
        if (this.inv.size() != 0) {
            System.out.println("Your inventory:");
            System.out.println("Amount x Item");
            for (Item item : this.inv) {
                System.out.println(this.amount(item) + " x \t " + this.get(item).name);
            }
        } else {
            System.out.println("Your inventory is empty");
        }
        System.out.println();
    }
    //missing recipe input(s) dump
    public void printMissing(ArrayList<Item> miss) {
        System.out.println("Missing item(s) for recipe:");
        System.out.println("Amount x Item");
        for (Item i : miss) {
            System.out.println(i.amount + " x \t " + i.name);
        }
        System.out.println();
    }
}
