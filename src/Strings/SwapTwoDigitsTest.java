package Strings;

import org.junit.Test;

import java.util.*;

public class SwapTwoDigitsTest {


    /*
	 * Swap any two digits to get the biggest number
�
Example 1:
Input: num = 2736.
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:
Input: num = 9973
Output: 9973
Explanation: No swap.
1996-9916
	 */

    @Test
    public  void  test1(){
        int n=2736;
        System.out.println(swapTogetHighest(n));
    }

    @Test
    public  void  test2(){
        int n=9916;
        System.out.println(swapTogetHighest(n));
    }

    @Test
    public  void  test3(){
        int n=12349;
        System.out.println(swapTogetHighest(n));
    }

    @Test
    public  void  test4(){
        int n=9016;
        System.out.println(swapTogetHighest(n));
    }



	 /*Pseudocode
	 1. Convert the Integer to String
	 2. Iterate each digit and Find the max digit in the array
	 3. Swap the max digit with first digit
	 4. Return the Integer value of the array
	 */

    public int swapTogetHighest(int n) {
        int temp = n;
        String str = Integer.toString(n);
        char[] chars = str.toCharArray();
        char[] reverseChar = chars;
        for (char eachChar:chars) {

        }
        return 1;
    }


    /*
        2736
        2736%10 =6
        2736/10 =273

        6*1000+273

        Find the length of the number by
     */


}
