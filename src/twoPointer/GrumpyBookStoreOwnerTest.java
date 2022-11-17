package twoPointer;

import org.junit.Test;

public class GrumpyBookStoreOwnerTest {
    //1052. Grumpy Bookstore Owner
//https://leetcode.com/problems/grumpy-bookstore-owner/

    @Test
    public void test1(){
        int[] customers={1,0,1,2,1,1,7,5};
        int[] grumpy={0,1,0,1,0,1,0,1};
        int minutes=3;
        System.out.println(maxSatisfied(customers,grumpy,minutes));
    }

    @Test
    public void test2(){
        int[] customers={1,0,1,2,1,1,7,5};
        int[] grumpy={1,1,0,1,0,1,1,1};
        int minutes=3;
        System.out.println(maxSatisfied(customers,grumpy,minutes));
    }

    private int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int happyCustomers=0,canBeHappy=0,maxCanBeHappy=0;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==0)happyCustomers+=customers[i];
        }
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==1)canBeHappy+=customers[i];
            if(i>=minutes && grumpy[i-minutes]==1)canBeHappy-=customers[i-minutes];
            maxCanBeHappy=Math.max(canBeHappy,maxCanBeHappy);
        }
        return happyCustomers+maxCanBeHappy;
    }

}