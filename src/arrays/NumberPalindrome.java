package arrays;

import org.testng.annotations.Test;

public class NumberPalindrome {

    @Test
    public void test1(){
        int x =121;
        System.out.println(palindrome(x));
    }

    @Test
    public void test2(){
        int x =121;
        System.out.println(checkPalindrome(x));
    }

    @Test
    public void test3(){
        int x =0;
        System.out.println(checkPalindrome(x));
    }
    /*
        Pseudocode
        1. Convert the Integer to String
        2. Start Two pointer one from start other from end and iterate
        3. If both don't match then no. is not palindrome

        2nd Approach
        1. Check if no. is negative or divisible by zero , not a palindrome
        3. Take a temporary variable and add the no. from reverse
        4. Verify the reversed number and the actual number
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

    private boolean checkPalindrome(int x){
        if (x<0) return false;
        int num=x,temp=0;
        while(num>0){
            temp*=10;
            temp+=num%10;
            num/=10;
        }
        if(x==temp)return true;
        return false;
    }





}















