package arrays;

import org.junit.Test;

public class PalindromicSubStringTest {
    //https://leetcode.com/problems/longest-palindromic-substring/

    @Test
    public void test1(){
        String s ="babad";
        System.out.println(palindromeString(s));
    }


    @Test
    public void test2(){
        String s ="cbbd";
        System.out.println(palindromeString(s));
    }

    @Test
    public void test3(){
        String s = "dbcbcbdghi";
        System.out.println(palindromeString(s));
    }


    private String palindromeString(String str){
        if(str.length()<2)return str;
        String maxPalindrome="";
        String palindromeSubstring;
        for(int i=0;i<str.length()-1;i++){
            palindromeSubstring=plaindromic(str,i,i);
            maxPalindrome=palindromeSubstring.length()>maxPalindrome.length()?palindromeSubstring:maxPalindrome;
            palindromeSubstring=plaindromic(str,i,i+1);
            maxPalindrome=palindromeSubstring.length()>maxPalindrome.length()?palindromeSubstring:maxPalindrome;

        }
        return maxPalindrome;
    }



    private String plaindromic(String str, int  left,int right){
        String palindrome;
        while(left>=0 && right <str.length()&& str.charAt(left)==str.charAt(right)){
            left--;
            right++;
        }
        palindrome=str.substring(left+1,right);
        return palindrome;
    }
}
