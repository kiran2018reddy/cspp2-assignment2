import java.io.BufferedInputStream;
import java.util.Scanner;

public class Solution {
	

	public static void main(String[] args) {
        // create an object of the list to invoke methods on it
        StringList sl = new StringList();
        StringListInterface l=(StringListInterface)sl;//Typecasting is done for StringListInterface
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
                case "add":
	                l.add(tokens[1]);
                break;
                case "addAll":
                if(tokens.length==2){
                String[] t1 = tokens[1].split(",");
                l.addAll(t1);
                }
                break;
                case "size":
                // invoke size method and print the list size
                // BTW, list size is not the array size
                // it is the number of items in the list
                System.out.println(l.size());
                break;
                case "print":
                // print the list (implement toString in StringList class
                //for this to work)
                // expected format is [item-1,item-2,...,item-n]
                // review the output testcase file
                System.out.println(l);
                break;
                case "remove":
                l.remove(Integer.parseInt(tokens[1]));
                break;
                case "indexOf":
                System.out.println(l.indexOf(tokens[1]));
                break;
                case "get":
                System.out.println(l.get(Integer.parseInt(tokens[1])));
                break;
                case "contains":
                System.out.println(l.contains(tokens[1]));
                break;
            }
        }
	}
}
