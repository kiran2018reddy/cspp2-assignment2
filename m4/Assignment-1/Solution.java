import java.util.Scanner;
/**
 * { item_description }.
 */
public final class Solution {
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
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        int[]a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (a[i] > max) {
                max = a[i];
            }
        }
        System.out.println(max);
    }
}
