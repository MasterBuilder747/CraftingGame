package Main;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Inventory inv = new Inventory();

        Item a = new Item("apple");
        Item b = new Item("banana");
        Item c = new Item("carrot");
        Item d = new Item("dog");

        Recipe r = new Recipe(b, c, 2, 2);
        Recipe j = new Recipe(new Item[]{a, b, c}, new Item[]{d}, new int[]{2, 2, 2}, new int[]{1});

        inv.add(a, 2);
        //inv.add(b, 0);
        inv.add(c, 1);
        inv.print();

        //inv.doRecipe(r);
        inv.doRecipe(j);
        inv.print();

    }

}
