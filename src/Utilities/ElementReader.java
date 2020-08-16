package Utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import Items.Element;

public class ElementReader {

    /*
    int row1
    [repeating]:
    int atomic number
    String symbol
    String name
    double atomic weight
    int row2
    [repeating]:
    etc...
    */

    public static ArrayList<Element> readFile(BufferedReader br) throws IOException {
        String pd = null;
        ArrayList<Element> out = new ArrayList<>();
        while (true) {
            String s1 = br.readLine(); //row value or atomic number
            if (s1 != null) {
                //first is always a number
                String s2 = br.readLine(); //atomic number or symbol (use stored row value)
                //System.out.println(s1 + " " + s2);
                if (isNumeric(s2)) {
                    //s2 = atomic number; store the row number
                    //period, number, symbol, name, weight
                    pd = s1;
                    out.add(new Element(Integer.parseInt(s1), Integer.parseInt(s2), br.readLine(), br.readLine(), Double.parseDouble(br.readLine())));
                } else {
                    //s2 = symbol; use the saved row number
                    //period, number, symbol, name, weight
                    if (pd != null) {
                        //System.out.println(pd + " " + s1 + " " + s2 + " " + br.readLine() + " " + br.readLine());
                        out.add(new Element(Integer.parseInt(pd), Integer.parseInt(s1), s2, br.readLine(), Double.parseDouble(br.readLine())));
                    } else {
                        throw new IllegalAccessError("Must provide the period first before listing elements");
                    }
                }
            } else {
                break;
            }
        }
        return out;
    }

    public static boolean isNumeric(String s) {
        if (s == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}

