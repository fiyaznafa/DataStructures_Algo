package slidingWindow;

import org.junit.Assert;
import org.junit.Test;

public class maxVowelsStringTest {
    //1456. Maximum Number of Vowels in a Substring of Given Length
//https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/

    @Test
    public void test1(){
        String s="abciiidef";
        int k=3;
        Assert.assertEquals(3,maxVowels(s,k));
    }

    @Test
    public void test2(){
        String s="aeiou";
        int k=2;
        Assert.assertEquals(2,maxVowels(s,k));
    }

    @Test
    public void test3(){
        String s="leetcode";
        int k=3;
        Assert.assertEquals(2,maxVowels(s,k));
    }

/*
	Pseudocode
	Sliding window
	1. Create a helper function to check if character is vowel (return boolean)
	2. Iterate each character of String,
	3. If character is vowel then add to vowelCount
	4. If window size is reached
	5. If character at i-k is vowel, reduce the vowelCount and add the count to maxVowelCount
	6. If maxVowelCount is equal to k , return maxVowelCount or k
*/

    private int maxVowels(String s,int k){
        int vowelCount=0,maxVowelCount=0;
        for(int i=0;i<s.length();i++){
            if(i>=k)
                if(isVowel(s.charAt(i-k)))vowelCount--;
            if(isVowel(s.charAt(i)))vowelCount++;
            maxVowelCount=Math.max(vowelCount,maxVowelCount);
            if(maxVowelCount==k)return maxVowelCount;
        }
    return maxVowelCount;
    }

    private boolean isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
}
