package Sorting;

import org.junit.Test;

import java.util.Arrays;

public class ElectronicsShopTest {
    //https://www.hackerrank.com/challenges/electronics-shop/problem?h_r=next-challenge&h_v=legacy&isFullScreen=false

    @Test
    public void test1(){
        int b=60;
        int[] keyboards={40,50,60};
        int[] drives={5,8,12};
        System.out.println(moneySpent(keyboards,drives,b));
    }

    @Test
    public void test2(){
        int b=4;
        int[] keyboards={1,1,1};
        int[] drives={5};
        System.out.println(moneySpent(keyboards,drives,b));
    }

    @Test
    public void test3(){
        int b=5;
        int[] keyboards={2,1,1};
        int[] drives={2,1,3};
        System.out.println(moneySpent(keyboards,drives,b));
    }

    private int moneySpent(int[] keyboards, int[] drives, int b) {
        Arrays.sort(keyboards);
        Arrays.sort(drives);
        int k=keyboards.length-1;
        int d=0;
        int maxSum=-1;
        while(k>=0 && d<drives.length){

            if(keyboards[k]+drives[d]>b)k--;
            else {
                maxSum=Math.max(maxSum,keyboards[k]+drives[d++]);
            }
        }
        return maxSum;
    }
}
