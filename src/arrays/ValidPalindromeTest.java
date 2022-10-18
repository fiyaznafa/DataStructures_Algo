package arrays;

import org.junit.Test;

public class ValidPalindromeTest {

    //https://leetcode.com/problems/valid-palindrome/

    @Test
    public void test1(){
        String s ="A man, a plan, a canal: Panama";
        System.out.println(validPalindrome(s));
    }

    @Test
    public void test2(){
        String s ="A , a plan, a canal: Panama";
        System.out.println(validPalindrome(s));
    }

    @Test
    public void test3(){
        String s ="0P";
        System.out.println(validPalindrome(s));
    }

    @Test
    public void test4(){
        String s ="1b1";
        System.out.println(validPalindrome(s));
    }

    /*
        Pseudo Code
     */

    private boolean validPalindrome(String s) {
        int left=0,right=s.length()-1;
        String str =s.toLowerCase();

        while(left<=right){
            if(Character.isLetterOrDigit(str.charAt(left))&&Character.isLetterOrDigit(str.charAt(right))) {
                if (str.codePointAt(left) != str.codePointAt(right)) return false;
                left++;right--;
            }
            else if (!Character.isLetterOrDigit(str.charAt(left)))
                left++;
            else right--;
        }
        return true;
    }
}
