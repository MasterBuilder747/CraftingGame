package Utilities;

public class ExpandableArray {

    public static long count;

    public static String[] expandArray(String[] a) {
        String[] b = new String[a.length + 1];

        for(int i = 0; i < a.length; i++) {
            b[i] = a[i];
            count++;
        }
        return b;
    }

}
