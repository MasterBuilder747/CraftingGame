package Items;

import java.util.ArrayList;
import java.lang.StringBuilder;

public class Compound {

    public String name;

    //one or more elements of varying amounts
    //defines the elements that make it up
    private final ArrayList<Element> elements = new ArrayList<>();

    public Compound(String name) {
        this.name = name;
    }

    public void addElements(Element[] ele, int[] amounts) {
        if (ele.length == amounts.length) {
            for (int i = 0; i < ele.length; i++) {
                ele[i].amount = amounts[i];
                this.elements.add(ele[i]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Element e : this.elements) {
            sb.append(e.symbol).append(e.amount);
        }
        return sb.toString();
    }
}
