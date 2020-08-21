package Items;

import java.util.ArrayList;
import java.util.Arrays;

public class Material<M> extends Item {

    //this will act as the parent of all of the material parts.
    //this is usually implementing an element or some other item
    //then it will register the appropriate parts of its material type.
    //Note that the name and the item/element that it implements is required

    //only accepts Element, and Compound
    public M mat;
    public ArrayList<Part> parts = new ArrayList<>();

    public Material(String name, M mat) {
        super(name);
        this.mat = mat;
    }

    public void print() {
        System.out.println(this.mat.toString());
    }

    public void addPart(Part[] partList) {
        this.parts.addAll(Arrays.asList(partList));
    }

}
