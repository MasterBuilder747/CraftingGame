package Main;

public class Recipe {

    //simple blueprint that allows for one of each item type (can be the same) as an input and output
    //multiple amounts of each item can be used
    Item[] input;
    Item[] output;
    int[] inAmount;
    int[] outAmount;

    public Item getInput(int index) {
        if (index >= 0) {
            return this.input[index];
        } else {
            return null;
        }
    }
    public Item getOutput(int index) {
        if (index >= 0) {
            return this.output[index];
        } else {
            return null;
        }
    }
    public int getAmountIn(int index) {
        if (index >= 0) {
            return this.inAmount[index];
        } else {
            return 0;
        }
    }
    public int getAmountOut(int index) {
        if (index >= 0) {
            return this.outAmount[index];
        } else {
            return 0;
        }
    }

    public Recipe(Item input, Item output, int in, int out) {
        this.input = new Item[1];
        this.input[0] = input;
        this.output = new Item[1];
        this.output[0] = output;
        this.inAmount = new int[1];
        this.inAmount[0] = in;
        this.outAmount = new int[1];
        this.outAmount[0] = out;
    }
    public Recipe(Item[] input, Item[] output, int[] in, int[] out) {
        if (input.length == in.length && output.length == out.length) {
            this.input = input;
            this.output = output;
            this.inAmount = in;
            this.outAmount = out;
        } else {
            throw new IllegalArgumentException("Array sizes must match");
        }
    }
}
