package arrays;


import org.junit.Test;

import java.util.Arrays;

public class PlusOneTest {

    @Test
    public void test1(){
        int[] digits = {1,2,3};
        System.out.println(Arrays.toString(plusone(digits)));
    }

    @Test
    public void test2(){
        int[] digits = {3,4,9};
        System.out.println(Arrays.toString(plusone(digits)));
    }

    @Test
    public void test3(){
        int[] digits = {9,9,9};
        System.out.println(Arrays.toString(plusone(digits)));
    }

    private int[] plusone(int[] digits) {
        int carry=1,val;
        for(int i= digits.length-1;i>=0;i--){
            val=digits[i]+carry;
            digits[i]=val%10;
            carry=val/10;
        }
        if(carry==1){
            int[] arr = new int[digits.length+1];
            arr[0]=1;
            if (arr.length - 1 - 1 >= 0) System.arraycopy(digits, 0, arr, 1, arr.length - 1 - 1);
            return arr;
        }
        return digits;
    }

}
