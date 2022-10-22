package arrays;

import org.junit.Test;

public class UglyNumberTest {

    //https://leetcode.com/problems/ugly-number/

    @Test
    public void test1(){
        int n=67;
        System.out.println(isUglyNumber(n));
    }

    @Test
    public void test2(){
        int n=175;
        System.out.println(isUglyNumber(n));
    }

    @Test
    public void test3(){
        int n=6;
        System.out.println(isUglyNumber(n));
    }

    @Test
    public void test4(){
        int n=1;
        System.out.println(isUglyNumber(n));
    }


/*
	Pseudocode
	1. Take the number and check if it is 1 return true
	2. If no is 0 or less than 0 return false
	3. Divide the number starting from 2 and check if remainder is zero,
	4. If remainder is zero then reassign the no as  the Quotient
	5. If remainder is not zero increment the count
	6. If the no increases to greater than return false
*/

    private boolean isUglyNumber(int n){
        if(n<=0) return false;
        int i=2;
        while(i<=5 && n!=1){
            if(n%i==0){
                n=n/i;
                i=1;
            }
            i++;
        }
        return i<=5;
    }

}
