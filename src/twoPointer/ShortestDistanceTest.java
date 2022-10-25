package twoPointer;

import org.junit.Test;

import java.util.Arrays;

public class ShortestDistanceTest {

    @Test
    public void test1(){
        String s ="loveleetcode";
        char c ='e';
        System.out.println(Arrays.toString(shortestDistanceToChar(s,c)));
    }

    /*	PseudoCode
     *	1. Create an integer arr of length as string length
     *	2. Conver the string to char array
     *	3. Using two pointers , iterate to left of array and right array till either character found or end of array
     *	4. If character found return min of distance of left & right
     *
     */

    private int[] shortestDistanceToChar(String s,char c)
    {
        char[] charArray = s.toCharArray();
        int[] nums = new int [s.length()];

        int left, right,distance;
        for(int i=0;i<s.length();i++){
            left=i;
            right=i;
            distance = Integer.MAX_VALUE;
            while(left>0 && charArray[left]!=c)left--;
            if(charArray[left]==c) distance=Math.min(distance,Math.abs(i-left));
            while(right<nums.length-1 && charArray[right]!=c)right++;
            if(charArray[right]==c) distance=Math.min(distance,Math.abs(i-right));
            nums[i]=distance;
        }
        return nums;

    }
}
