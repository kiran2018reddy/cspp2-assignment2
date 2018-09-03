
// Given an String, Write a java method that returns the decimal value for the given binary string.


import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution{
    /**
     * Constructs the object.
     */
    private Solution() { }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0;i <= n - 1;i++){
            String s = sc.nextLine();
            String res = binaryToDecimal(s);//Write binaryToDecimal function
            System.out.println(res);
        }
    }
    /**
     * { function_description }
     *
     * @param      s     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
static String binaryToDecimal(final String s) {
    int sum = 0;
    int a = 1;
    int b = s.length() - 1;
    for (int i = 0;i < s.length();i++){
        a = (int)Math.pow(2,b);
        sum = sum + (a * Character.getNumericValue(s.charAt(i)));
        b = b - 1;
    }
    return Integer.toString(sum);

}
}