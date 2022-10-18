package arrays;

import org.junit.Test;

import java.util.Arrays;

public class ArrangeCookiesTest {
    //https://leetcode.com/problems/assign-cookies/

/*
Test Data
1) Positive - g = [1,2,3], s = [1,1]
2) Negative - g = [4,6,5], s = [2,2,3]
3) Edge    	- g = [3,2,5], s = [1,1,1,1,1,1,1]
*/

/*	PseudoCode
	1. Sort both array
	2. Iterate either no of child is complete or no of cookies is complete
	3. Assign left pointer to child array and right pointer to cookie array
	4. If child is less than equal to cookie value increment both pointers
	5. Else increment cookie pointer
	4. Return the left pointer value at the end of the iteration.
*/

    @Test
    public void test1(){
        int[] g = {1,2,3};
        int[] s = {1,1};
        System.out.println(assignCookies(g,s));    }

    @Test
    public void test2(){
        int[] g = {4,6,5};
        int[] s = {2,2,3};
        System.out.println(assignCookies(g,s));
    }


    @Test
    public void test3(){
        int[] g = {3,2,5};
        int[] s = {1,1,1,1,1,1,1};
        System.out.println(assignCookies(g,s));
    }


    @Test
    public void test4(){
        int[] g = {10,9,8,7};
        int[] s = {5,6,7,8};
        System.out.println(assignCookies(g,s));
    }

    private int assignCookies(int[] child, int[] cookie){
        int left=0, right =0;
        Arrays.sort(child);
        Arrays.sort(cookie);
        while(left<child.length && right<cookie.length){
            if(child[left]<=cookie[right]) left++;
            right++;
        }
        return left;
    }
}
