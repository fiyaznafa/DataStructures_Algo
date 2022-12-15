package twoPointer;

import org.junit.Test;

public class MinLengthStringDeletingEndsTest {

    //https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/description/
    //1750. Minimum Length of String After Deleting Similar Ends

    @Test
    public void test1(){
        String str = "ca";
        System.out.println(minimumLength(str));
    }

    @Test
    public void test2(){
        String str = "cabaabac";
        System.out.println(minimumLength(str));
    }

    @Test
    public void test3(){
        String str = "aabccabba";
        System.out.println(minimumLength(str));
    }

    @Test
    public void test4(){
        String str = "cccc";
        System.out.println(minimumLength(str));
    }


    /*      Pseudocode
           1. With left pointer at start of the string and the right pointer at the end of the string
           2. If the char are matching the increase the left pointer and decrease the right pointer
           3. If char are not equal then return the length - right -left
        */
    public int minimumLength(String s) {

        int left=0,right=s.length()-1;
        char startChar,endChar;
        while(left<=right){
            if(s.charAt(left)==s.charAt(right)){
                startChar=s.charAt(left);
                endChar=s.charAt(right);
                while(s.charAt(left)==startChar && left<=right &&left<s.length()-1){
                    System.out.println(left);
                    left++;
                }
                while(s.charAt(right)==endChar && left<right)right--;
            }
            else break;
        }
        return Math.abs(right-left+1);
    }
}
