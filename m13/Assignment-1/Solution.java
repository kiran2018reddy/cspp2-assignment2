import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
class Set {
    private int[] set;
    private int[] array;
    private int size;
    Set() {
        final int ten = 10;
        set = new int[ten];
        size = 0;
    }



    void add(final int[] item){
        for (int i = 0; i < item.length; i=i+1){
            add(item[i]);
        }
    }
    void resize(){
        set = Arrays.copyOf(set, 2 * size);
    }
     void add(final int item) {
        try {
            if (!contains(item)) {
                set[size] = item;
                size++;
            }
        } catch (Exception e) {
            resize();
        }
    }
    int size(){
        return size;
    }
        boolean contains(final int item) {
        for (int i = 0; i < size; i = i+1) {
            if (set[i] == item) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String res= "{";
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                res = res + set[i];
            } else {
                res = res + set[i] + ", ";
            }
        }
        res =res + "}";

        return res;
    }
        Set intersection(final Set item) {
        Set res1 = new Set();
        for (int i = 0; i < size; i = i+1){
            for (int j = 0; j < item.size; j = j+1) {
                if (set[i] == item.set[j]){
                    res1.add(item.set[j]);
                }
            }
        }
        return res1;

    }

    Set retainAll(final int[] item) {
        Set res3 = new Set();
        for (int i = 0; i < size; i = i+1) {
            for (int j = 0; j < item.length; j = j+1) {
                if (set[i] == item[j]){
                    res3.add(item[j]);
                }
            }
        }
        return res3;
    }

int[][] cartesianProduct(final Set item) {
        if (size == 0 || item.size == 0) {
            return null;
        }
        int[][] res4 = new int[item.size * size][2];
        int k = 0;
        for (int i = 0; i < size; i = i + 1) {
            for (int j = 0; j < item.size; j = j + 1) {
                res4[k][0] = set[i];
                res4[k][1] = item.set[j];
                k = k + 1;
            }

        }

        return res4;
    }




}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
               .mapToInt(Integer::parseInt)
               .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "size":
                System.out.println(s.size());
                break;
            case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
            case "print":
                System.out.println(s);
                break;
            case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
            case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
            case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
            case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
            default:
                break;
            }
        }
    }
}
