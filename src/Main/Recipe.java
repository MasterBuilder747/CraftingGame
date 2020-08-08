package Main;

public class Recipe {

    //simple blueprint that allows for one of each item type (can be the same) as an input and output
    //multiple amounts of each item can be used
    Item input;
    Item output;
    int inAmount;
    int outAmount;

    public Recipe(Item input, Item output, int in, int out) {
        this.input = input;
        this.output = output;
        this.inAmount = in;
        this.outAmount = out;
    }
}
