package twoPointer;

import org.junit.Test;

public class IsPalindromeTest {
    //Palindrome


/*

	Pseudocode
	1. Take two pointers , left at start right at end
	2. Iterate through the string , if char at left is equal to character at right , increase left and decrease right
	3. If not equal return false


*/

    @Test
    public void test1(){
        String str ="radar";
        System.out.println(isPalindrome(str));
    }

    @Test
    public void test2(){
        String str ="a";
        System.out.println(isPalindrome(str));
    }

    @Test
    public void test3(){
        String str ="";
        System.out.println(isPalindrome(str));
    }

    @Test
    public void test4(){
        String str ="hello";
        System.out.println(isPalindrome(str));
    }


    private boolean isPalindrome(String str){
        if(str.length()==0)return false;
        int left=0, right = str.length()-1;

        while(left<right){
            if(str.charAt(left++)!=str.charAt(right--))return false;
        }
        return true;
    }
}
