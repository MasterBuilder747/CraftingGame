package Main;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Reg.regElements();
        //Reg.printElements();

        Recipe r1 = new Recipe(Reg.getElement("H") + " * 1", Reg.getElement("C") + " * 1");

        Inventory i = new Inventory();
        i.add(Reg.getElement("H"), 2);
        i.print();
        i.doRecipe(r1);
        i.print();
    }

}
