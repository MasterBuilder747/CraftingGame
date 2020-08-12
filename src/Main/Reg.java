package Main;

import java.util.ArrayList;

public class Reg {

    //short for registry
    //defines the dictionary of items that exist in the instance
    //allows for quick finding of items
    //only one registry exists, so all of its methods are static
    private static final ArrayList<Item> dict = new ArrayList<>();

    public static void add(String s) {
        dict.add(new Item(s));
    }

    //returns the item class given the name
    //name given must be exact; it is case-sensitive
    public static Item get(String s) {
        for (Item i : dict) {
            if (i.name.matches(s)) {
                return i;
            }
        }
        //does not exist
        return null;
    }

}
