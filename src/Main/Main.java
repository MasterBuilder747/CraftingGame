package Main;

import Items.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Reg.regElements();
        //Reg.printElements();

        Recipe r1 = new Recipe(Reg.getElementName("H") + " * 1", Reg.getElementName("C") + " * 1");

//        Inventory i = new Inventory();
//        i.add(Reg.getElement("H"), 2);
//        i.print();
//        i.doRecipe(r1);
//        i.print();

        Compound steel = new Compound("Steel");
        steel.addElements(new Element[]{Reg.getElement("Fe")}, new int[]{4});

        Material<Compound> stel = new Material<>("steel", steel);
        stel.print();
    }

}
