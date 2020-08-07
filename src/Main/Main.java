package Main;

public class Main {

    public static void main(String[] args) {

        Inventory inv = new Inventory();

        Item a = new Item("Apple");
        Item b = new Item("Banana");

        Item c = new Item("Carrot");
        Recipe r = new Recipe(b, c, 2, 2);

        inv.add(a, 4);
        inv.add(b, 4);
        inv.print();

        inv.doRecipe(r);
        inv.print();

    }

}
