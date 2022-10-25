package twoPointer;

import org.junit.Test;

public class IsPalindromeIITest {
    //https://leetcode.com/problems/valid-palindrome-ii/

/*
	Str - acbdba
	Str - abcdedcb
	Str - abcdfcba
	Str - abc
*/

    @Test
    public void test1(){
        String str ="acbdba";
        System.out.println(canBePalindrome(str));
    }

    @Test
    public void test2(){
        String str ="ebcbbececabbacecbbcbe";
        System.out.println(canBePalindrome(str));
    }

    @Test
    public void test3(){
        String str ="abcdfcba";
        System.out.println(canBePalindrome(str));
    }

    @Test
    public void test4(){
        String str ="abc";
        System.out.println(canBePalindrome(str));
    }

/*
	Pseudocode
	1. Take two pointers left at start of string and 2nd at end of string
	2. Compare each char at left and right
	3. If char are not equal & count is 0, check if next char matches (either left char matches next right char  or   right char matches next left char)
	4. If cannot match return false;
	5. Continue till left<right
*/


    private boolean canBePalindrome(String str){
        int left=0,right =str.length()-1;

        while(left<right){
            if (str.charAt(left++)==str.charAt(right--));
            else return isPalindrome(str.substring(left - 1, right + 1)) || isPalindrome(str.substring(left, right + 2));
        }
        return true;
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
