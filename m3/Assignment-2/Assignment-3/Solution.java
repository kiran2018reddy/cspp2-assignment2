
import java.util.Scanner;
/**
 * { item_description }.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() { }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */

    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        gcd(n1, n2);
    }

/**
 * { function_description }.
 *
 * @param      num1  The number 1
 * @param      num2  The number 2
 */

        static void gcd(final int num1, final int num2) {
            int k = 0;
        for (int i = 1; i <= num1 && i <= num2; i = i + 1) {
            if (num1 % i == 0 && num2 % i == 0) {
                k = i;
            }
        }
          System.out.println(k);
    }
}
