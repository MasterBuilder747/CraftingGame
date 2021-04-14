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
    private static final ArrayList<Item> items = new ArrayList<>();
    private static ArrayList<Element> elements = new ArrayList<>();
    private static final ArrayList<Compound> compounds = new ArrayList<>();
    private static final ArrayList<Recipe> recipes = new ArrayList<>();

    //add to the registry
    public static void addItem(String s) {
        items.add(new Item(s));
    }
    public static void addElement(int period, int number, String symbol, String name, double weight) {
        elements.add(new Element(period, number, symbol, name, weight));
    }
    public static void addCompound(String name, Element[] ele, int[] amounts) {
        Compound c = new Compound(name);
        c.addElements(ele, amounts);
        compounds.add(c);
    }
    public static void addRecipe(String in, String out) {
        recipes.add(new Recipe(in, out));
    }

    //retrieve from the registry
    //returns the item class given the name
    //name given must be exact; it is case-sensitive
    public static Item getItem(String s) {
        for (Item i : items) {
            if (i.name.matches(s)) {
                return i;
            }
        }
        //does not exist
        return null;
    }
    //given the element symbol, return the element
    public static Element getElement(String s) {
        for (Element e : elements) {
            if (e.symbol.matches(s)) {
                return e;
            }
        }
        //does not exist
        return null;
    }
    public static Compound getCompound(String s) {
        for (Compound c : compounds) {
            if (c.name.matches(s)) {
                return c;
            }
        }
        //does not exist
        return null;
    }


    //given the element symbol, return the name
    public static String getElementName(String s) {
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
                System.out.println(e.toString());
            }
        }
    }
}
