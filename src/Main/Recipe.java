package Main;

public class Recipe {

    //simple blueprint that allows for one of each item type (can be the same) as an input and output
    //multiple amounts of each item can be used
    String[] input;
    String[] output;
    int[] inAmount;
    int[] outAmount;
    //String name;

    public Item getInput(int index) {
        if (index >= 0) {
            return new Item("");
        } else {
            return null;
        }
    }
    public Item getOutput(int index) {
        if (index >= 0) {
            return new Item("");
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

    private Recipe() {

    }
    //String syntax: item * 1, item * 2, item * 3...
    public Recipe(String in, String out) {
        String[] in1 = in.split(",\\s*");
        String[] out1 = in.split(",\\s*");
        String[] input = new String[in1.length];
        String[] output = new String[out1.length];
        for (String s : in1) {
            String s1 = s.strip();
            if (s1.contains("*")) {

            } else {

            }
        }
    }
}
