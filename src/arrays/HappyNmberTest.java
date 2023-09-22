package arrays;


import org.junit.Test;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

public class HappyNmberTest {

    //https://leetcode.com/problems/happy-number/
//Start : 20:37 End

    @org.junit.Test
    public void test1(){
        int n = 19;
        Assert.assertTrue(isHappy(n));
    }

    @Test
    public void test2(){
        int n = 2;
        Assert.assertFalse(isHappy(n));
    }

/*
	Pseudo Code
	1. Add the no to set
	2. Get each digit and square them
	3. Add the squares
	4. Check the no is 1, return true
	5. Add the no generated to set
	6. Repeat the process
	7. If not able to add to set return false;
*/

    private boolean isHappy(int n){
        if(n==1) return true;
        Set<Integer> set = new HashSet<>();
        set.add(n);
        int sum,digit,num=n;
        do{
            sum=0;
            while(num>0){
                digit = num%10;
                sum=sum+(digit*digit);
                num=num/10;
            }
            if(!set.add(sum))return false;
            num=sum;
        }while(sum!=1);
        return true;
    }
}
