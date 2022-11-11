package slidingWindow;

import org.junit.Assert;
import org.junit.Test;

public class BuddyStringTest {

    @Test
    public void test1(){
        String s = "ab", goal = "ba";
        Assert.assertTrue(buddyString(s,goal));
    }

    @Test
    public void test2(){
        String s = "ab", goal = "ab";
        Assert.assertFalse(buddyString(s,goal));
    }


    @Test
    public void test3(){
        String s = "aa", goal = "aa";
        Assert.assertTrue(buddyString(s,goal));
    }

    /*
        Pseudocode
        1. Case1: If both string length are diff return false
        2. Case2: Check each character simultaneously , if they are not equal increment mismatch count
        3. If the mismatch count is greater than 2 return false
        4. If swap of mismatch elements are equal return true
        5. Case3: If both strings are equal
        6. Check if any char is repeated , return true else return false
        Time O[n] Space - O[1]
     */

    private boolean buddyString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if(s.equals(goal)) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) ++count[c - 'a'];
            for (char c : s.toCharArray()) if (count[c-'a'] > 1) return true;
            return false;
        }
        int[] mismatchIndex = new int[2];
        int misMatchCount=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!=goal.charAt(i)) {
                if(misMatchCount==2)return false;
                mismatchIndex[misMatchCount++]=i;
            }
        }
        return     s.charAt(mismatchIndex[0])==goal.charAt(mismatchIndex[1]) && s.charAt(mismatchIndex[1])==goal.charAt(mismatchIndex[0]);

    }
}
