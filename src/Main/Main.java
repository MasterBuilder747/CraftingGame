package Main;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        /*
        Reg.add("apple");
        Reg.add("banana");
        Reg.add("carrot");
        Reg.add("dog");

        Inventory i = new Inventory();

        i.add(new String[]{"apple", "banana"}, new int[]{2, 2});
        i.print();

        Recipe r = new Recipe("apple * 1, banana * 1", "carrot * 1");
        i.doRecipe(r);
        i.print();
        */

        Reg.regElements();
        Reg.printElements();

    }

}
