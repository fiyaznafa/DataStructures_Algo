package arrays;

import org.junit.Assert;
import org.junit.Test;

public class IsomorphicStringTest {

    //https://leetcode.com/problems/isomorphic-strings/

    @Test
    public void test1(){
       String s = "egg", t = "add";
        Assert.assertTrue(isIsoMorphic(s,t));
    }
    @Test
    public void test2(){
        String s = "paper", t = "title";
        Assert.assertTrue(isIsoMorphic(s,t));
    }
    @Test
    public void test3(){
        String s = "foo", t = "bar";
        Assert.assertFalse(isIsoMorphic(s,t));
    }
    @Test
    public void test4(){
        String s = "badc", t = "baba";
        Assert.assertFalse(isIsoMorphic(s,t));
    }

    /*
        Pseudocode
        1. Iterate the string and check each character value
        2. If value is '\u0000' (null or default value of char), replace with character from 2nd string
        2. If value is present other than null check if it matches with char at same point from t
        3. If value is present and is not matching with corresponding value in second string,return false.
     */

    private boolean isIsoMorphic(String s, String t) {
        if(s.length()==1)return  true;
        char[] countS= new char[128];
        char[] countT= new char[128];
        for (int i = 0; i <s.length() ; i++) {
            if(countS[s.charAt(i)]=='\u0000')countS[s.charAt(i)]=t.charAt(i);
            if(countT[t.charAt(i)]=='\u0000')countT[t.charAt(i)]=s.charAt(i);
            if(countS[s.charAt(i)]!=t.charAt(i) || countT[t.charAt(i)]!=s.charAt(i))return false;
        }
        return true;
    }
}
