package Main;

import java.util.ArrayList;

public class Inventory {

    ArrayList<Item> inv = new ArrayList<>();

    //Item addition/removal
    //add one class type item of a amount to inventory
    public void add(Item item, int a) {
        if (this.get(item) != null) {
            this.get(item).amount += a;
        } else {
            item.amount = a;
            this.inv.add(item);
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
                if (this.amount(in) >= in.amount) {
                    this.remove(in, r.getAmountIn(0));
                    this.add(out, r.getAmountOut(0));
                } else {
                    System.out.println("not enough items");
                }
            } else {
                System.out.println("item does not exist");
            }
        } else {
            //Multiple recipe (multiple inputs, multiple outputs)
            //make sure all the items exist in the inventory, regardless of amounts right now
            //this may be redundant
            boolean check = true;
            for (Item i : r.input) {
                if (!this.has(i)) {
                    check = false;
                    break;
                }
            }
            //now check amounts
            if (check) {
                boolean amt = true;
                for (int i = 0; i < r.input.length; i++) {
                    if (!(this.amount(r.input[i]) >= r.inAmount[i])) {
                        amt = false;
                        break;
                    }
                }
                if (amt) {
                    this.remove(r.input, r.inAmount);
                    this.add(r.output, r.outAmount);
                } else {
                    System.out.println("not enough of item(s)");
                }
            } else {
                System.out.println("missing items in inventory");
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
