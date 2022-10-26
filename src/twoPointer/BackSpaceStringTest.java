package twoPointer;

import org.junit.Assert;
import org.junit.Test;

public class BackSpaceStringTest {
    //https://leetcode.com/problems/backspace-string-compare/

    @Test
    public void test1(){
        String s = "ab#c";
        String t = "ad#c";
        Assert.assertTrue(backSpaceString(s,t));
    }

    @Test
    public void test2(){
        String s = "ab##";
        String t = "c#d#";
        Assert.assertTrue(backSpaceString(s,t));
    }

    @Test
    public void test3(){
        String s = "a#c";
        String t = "b";
        Assert.assertTrue(backSpaceString(s,t));
    }

    @Test
    public void test4(){
        String s = "###ab";
        String t = "#ab";
        Assert.assertTrue(backSpaceString(s,t));
    }

/*
	Pseudocode
	1. Iterate through the both the string with two pointers from the end
	2. If char at left is not # and matching to right reduce left and right
	3. If char at left is # keep reducing left
	4. If char at right is # keep reducing right
	5. At the end if left is not zero or right not zero , check if it is # and keep reducing
	6. If left and right both have reached zero then return true, else return false
*/

    private boolean backSpaceString(String s, String t) {
    return false;
    }
}