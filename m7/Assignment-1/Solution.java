import java.util.Scanner;
class InputValidator {
    private String input;
    InputValidator(final String giveninput) {
        this.input =giveninput;
    }
    public boolean validateData() {
        final int a=6;
        return this.input.length()>=a;
    }
}
final class Solution {
    private Solution() {
    }
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        InputValidator inputclass = new InputValidator(input);
        System.out.println(inputclass.validateData());
    }
}