package Main;

public class Main {

    public static void main(String[] args) {

        Reg.add("apple");
        Reg.add("banana");
        Reg.add("carrot");
        Reg.add("dog");

        Inventory i = new Inventory();

        i.add(new String[]{"apple", "banana"}, new int[]{1, 1});
        i.remove(new String[]{"banana", "apple"}, new int[]{2, 1});
        i.print();

    }

}
