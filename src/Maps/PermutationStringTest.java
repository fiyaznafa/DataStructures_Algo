package Maps;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class PermutationStringTest {
    //567. Permutation in String
//https://leetcode.com/problems/permutation-in-string/

    @Test
    public void test1(){
        String s1="ab";
        String s2="eidbaooo";
        Assert.assertTrue(checkInclusion( s1,  s2));
    }

    @Test
    public void test2(){
        String s1="ab";
        String s2="eidboaoo";
        Assert.assertFalse(checkInclusion( s1,  s2));
    }

/*
	Pseudocode
	1. Create an array of 26
	2. Iterate the s1 string and increment the count of each  char in array
	3. Create a second array for string s2
	4. Iterate over string s2, when length of reaches s2 check if both array are equal
	5. When length greater than s2 , reduce the count of the right char
*/

    private boolean checkInclusion(String s1,String s2){
        if(s1.length()>s2.length())return false;
        int[] s1Array = new int[26];
        int[] s2Array = new int[26];
        for(char c:s1.toCharArray())s1Array[c-'a']++;

        for(int i=0;i<s2.length();i++){
            if(i>=s1.length())s2Array[s2.charAt(i-s1.length())-'a']--;
            s2Array[s2.charAt(i)-'a']++;
            if(Arrays.equals(s1Array,s2Array))return true;
        }
        return false;
    }
}
