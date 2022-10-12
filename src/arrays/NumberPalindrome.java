package arrays;

import org.testng.annotations.Test;

public class NumberPalindrome {

    @Test
    public void test1(){
        int x =-121;
        System.out.println(palindrome(x));
    }

    /*
        Pseudcode
        1.
     */



    private boolean palindrome(int x) {
        String intString = Integer.toString(x);
        int i=0, j=intString.length()-1;
        while(i<j){
            if(intString.charAt(i++)!=intString.charAt(j--))
                return false;
        }
        if(i==j || i>j)
            return true;
        return false;
    }
}
