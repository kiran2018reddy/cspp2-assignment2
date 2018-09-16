es (51 sloc)  1.4 KB
import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Class for solution.
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
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        while (stdin.hasNext()) {
            String line = stdin.nextLine();
            String[] keys = line.split(" ", 2);
            BookYourShow bys = new BookYourShow();
            switch (keys[0]) {
            case "add":
                bys.addAShow(keys[1]);
                break;
            case "get":
                ArrayList shows = bys.getAShow(keys[1]);
                if (shows.size() == 1) {
                    System.out.println(shows.get(0));
                } else {
                    for (int i = 0; i < shows.size(); i++) {
                        System.out.println(shows.get(i));
                    }
                }
                break;
            case "book":
                bys.bookAShow(keys[1]);
                break;
            case "print" :
                bys.printTickets(keys[1]);
                break;
            case "showAll":
                bys.showAll();
                break;
            default:

            }
        }
    }
}