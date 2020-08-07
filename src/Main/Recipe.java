package Main;

public class Recipe {

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
