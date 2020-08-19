package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Items.*;
import Utilities.ElementReader;

public class Reg {

    //short for registry
    //defines the dictionary of items that exist in the instance
    //allows for quick finding of items
    //only one registry exists, so all of its methods are static
    private static final ArrayList<Item> dict = new ArrayList<>();
    private static ArrayList<Element> elements = new ArrayList<>();

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
        for (Element e : elements) {
            if (e.name.matches(s)) {
                return e;
            }
        }
        //does not exist
        return null;
    }

    //given the element symbol, return the name
    public static String getElement(String s) {
        if (elements.size() > 0) {
            for (Element e : elements) {
                if (e.symbol.matches(s)) {
                    return e.name;
                }
            }
        }
        //does not exist
        return "";
    }

    public static void regElements() throws IOException {
        FileReader fr = new FileReader("/Users/Joseph/Documents/IdeaProjects/CraftingGame/src/elements.txt");
        BufferedReader br = new BufferedReader(fr);

        elements = ElementReader.readFile(br);
    }

    public static void printElements() {
        if (elements.size() > 0) {
            for (Element e : elements) {
                e.print();
            }
        }
    }
}
