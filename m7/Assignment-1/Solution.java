import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
    /**
     * { var_description }.
     */
    private String input;
    /**
     * Constructs the object.
     *
     * @param      giveninput  The giveninput
     */
    InputValidator(final String giveninput) {
        this.input = giveninput;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public boolean validateData() {
        final int a = 6;
        return this.input.length() >= a;
    }
}
/**
 * { item_description }.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        InputValidator inputclass = new InputValidator(input);
        System.out.println(inputclass.validateData());
    }
}
