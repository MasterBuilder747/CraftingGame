package Main;

public class Recipe {

    //simple blueprint that allows for one of each item type (can be the same) as an input and output
    //multiple amounts of each item can be used
    String[] input;
    String[] output;
    int[] inAmount;
    int[] outAmount;
    //String name;

    //String syntax: item * 1, item * 2, item * 3...
    public Recipe(String in, String out) {
        String[] in1 = in.split(",\\s*");
        String[] out1 = out.split(",\\s*");
        if (in1.length > 0 && out1.length > 0) {
            this.input = new String[in1.length];
            this.inAmount = new int[in1.length];
            this.output = new String[out1.length];
            this.outAmount = new int[out1.length];
            int j = 0;
            for (String s : in1) {
                String s1 = s.replace(" ", "");
                if (s.contains("*")) {
                    if (Reg.get(s1.substring(0, s1.indexOf("*"))) != null) {
                        this.input[j] = s1.substring(0, s1.indexOf("*"));
                        this.inAmount[j] = Integer.parseInt(s1.substring(s1.indexOf("*") + 1));
                        j++;
                    } else {
                        throw new IllegalArgumentException("Item does not exist");
                    }
                } else {
                    if (Reg.get(s1) != null) {
                        this.input[j] = s1;
                        j++;
                    } else {
                        throw new IllegalArgumentException("Item does not exist");
                    }
                }
            }
            j = 0;
            for (String s : out1) {
                String s1 = s.replace(" ", "");
                if (s.contains("*")) {
                    if (Reg.get(s1.substring(0, s1.indexOf("*"))) != null) {
                        this.output[j] = s1.substring(0, s1.indexOf("*"));
                        this.outAmount[j] = Integer.parseInt(s1.substring(s1.indexOf("*") + 1));
                        j++;
                    } else {
                        throw new IllegalArgumentException("Item does not exist");
                    }
                } else {
                    if (Reg.get(s1) != null) {
                        this.output[j] = s1;
                        j++;
                    } else {
                        throw new IllegalArgumentException("Item does not exist");
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Invalid recipe syntax: no items specified");
        }
    }
}
