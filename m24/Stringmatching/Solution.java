import java.util.Scanner;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

/**
*Doc class.
*/
class Doc {
    /** empty constructor.
    */
    Doc() {
    }
    /**
    *text to string.
    *@param f File
    *@return str returns string of that text.
    */
    public static String toText(final File f) {
        String s = "";
        try {
            Scanner inp = new Scanner(new FileReader(f));
            StringBuilder t = new StringBuilder();
            while (inp.hasNext()) {
                t.append(inp.next());
                t.append(" ");
            }
            inp.close();
            s = t.toString();
        } catch (FileNotFoundException e) {
            System.out.println("No file");
        }
        return s;
    }
    /**
     *document distance.
     *@param text1 first file
     *@param text2 second file
     *@return document distance
     */

    public double stringMatching(final String text1, final String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        double tl = l1 + l2;
        int maxValue = 0;
        double lcs = 0;
        final int hundred = 100;
        int[][] arr = new int[l1][l2];
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                    if (maxValue < arr[i][j]) {
                        maxValue = arr[i][j];
                    }
                }
            }
        }
        lcs = (((maxValue * 2) / tl) * hundred);
        return lcs;
    }
}
/** this is the solution class.
*/
public final class Solution {
    /**constructor.
    */
    private Solution() {

    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        try  {
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        File fls = new File(inp);
        Doc obj1 = new Doc();
        File[] list = fls.listFiles();
        int len = list.length;
        double max = 0;
        final int hundred = 100;
        String res = "";
        double[][] fileM = new double[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    fileM[i][j] = hundred;
                } else {
                    fileM[i][j] = obj1.stringMatching(
                        obj1.toText(list[i]), obj1.toText(list[j]));
                    if (max < fileM[i][j]) {
                        max = fileM[i][j];
                        res = "Maximum similarity is between "
                        + list[i].getName() + " and "
                        + list[j].getName();
                    }
                }
            }
        }
        System.out.print("      \t");
        for (int i = 0; i < len - 1; i++) {
            System.out.print("\t" + list[i].getName());
        }
        System.out.println("\t" + list[len - 1].getName());
        for (int i = 0; i < len; i++) {
            System.out.print(list[i].getName() + "\t");
            for (int j = 0; j < len; j++) {
                    System.out.print(
                        String.format("%.1f", fileM[i][j]) + "\t\t");
            }
            System.out.println();
        }
     System.out.println(res);
    } catch (NoSuchElementException e) {
        System.out.println("Empty Directory");
    }
    }
}


