package twoPointer;

import org.junit.Assert;
import org.junit.Test;

public class BinarySubStringTest {
    //https://leetcode.com/problems/count-binary-substrings/

    @Test
    public void test1(){
        String s ="00110011";
        Assert.assertEquals(6,noOfBinaryStringOptimized(s));
    }

    @Test
    public void test2(){
        String s ="0010011";
        Assert.assertEquals(4,noOfBinaryStringOptimized(s));
    }


    @Test
    public void test3(){
        String s ="010101";
        Assert.assertEquals(5,noOfBinaryStringOptimized(s));
    }

/*
	Pseudocode
	1. Iterate the loop , left pointer at right at 0
	2. Iterate right till character is same
	3. If char is diff, store the length in temp var and move left to right
	4. Iterate right till char is same and less than temp length, increment count
	5. Continue iteration of left till last but 1 index
*/

    private int  noOfBinarySubString(String str){
        int count=0,temp=0,left=0,right=0;
        while(left<str.length()-1){
            while( right<str.length()&& str.charAt(left)==str.charAt(right))right++;
            temp=right-left;
            left=right;
            while(right<str.length() && right-left<temp && str.charAt(left)==str.charAt(right))right++;
            count+=right-left;
            right=left;
        }
        return count;
    }

    /*
        Pseudocode
        1. Calculate current length when char is matching next char
        2. If char is diff the assign current length to previous length
        3. Calculate current length
        4. If current length is less than or equal to previous length , increment count
        5. Return count
     */


    private int noOfBinaryStringOptimized(String str){
        int currLength=1,prevLength=0,count=0;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==str.charAt(i-1))currLength++;
            else{
                prevLength=currLength;
                currLength=1;
            }
            if(prevLength>=currLength)count++;

        }

        return count;
    }
}
