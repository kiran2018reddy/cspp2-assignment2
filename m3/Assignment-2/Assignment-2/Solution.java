
import java.util.Scanner;
/*
	Do not modify this main function.
	*/
public class Solution {
/* Fill the main function to print the number of 7's between 1 to n*/
    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);      
        int n = s.nextInt();
        int count = 0;
        final int div = 10;
        final int adiv = 10;
        final int result = 7;
        for (int i = 1; i<=n; i++) {
        	int j = i;
        	while (j!= 0) {
        		if (j % div == result){
        			count = count + 1;
        		}
        		j = Math.round(j/adiv);
        	}
        }
        System.out.println(count);
        
       
        
    }
}