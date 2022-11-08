package twoPointer;

import org.junit.Assert;
import org.junit.Test;

public class LongestSubStrinVowelTest {

   // https://leetcode.com/problems/longest-substring-of-all-vowels-in-order/

    @Test
    public void test1(){
        String word="aeiaaioaaaaeiiiiouuuooaauuaeiu";
        Assert.assertEquals(13,longestBeautifulString(word));
    }

    @Test
    public void test2(){
        String word="aeeeiiiioooauuuaeiouuuuuu";
        Assert.assertEquals(10,longestBeautifulString(word));
    }

    @Test
    public void test3(){
        String word="a";
        Assert.assertEquals(0,longestBeautifulString(word));
    }

    @Test
    public void test4(){
        String word="aei" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" +
                "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii" +
                "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
                "uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu";
        Assert.assertEquals(2169,longestBeautifulString(word));
    }



/*
	Pseudocode
	1. Create a character array with vowels.
	2. With two pointers at 0th index of the word iterate the word
	3. Check if left pointer equal to vowel char in the array
	4. If equal go to the next character in the word (right++), else move both pointers (start and left ,reset vowel char array to intial position)
	5. If character is same , check next character is also same.
	6. If next character is different , compare the character with vowel+1 char
	7. Keep checking untill character is matching with vowel char array.
*/


    private int longestBeautifulString(String word){
        char[] vowelArray ={'a','e','i','o','u'};
        int vow=0,left=0,right=0,maxLength=0;

        while(right<word.length()){
            if(word.charAt(right)!=vowelArray[vow]){
                vow=0;
                if(word.charAt(right)!='a')right++;
                left=right;
            }
            else{
                while(right<word.length() && word.charAt(right)==vowelArray[vow])right++;
                if(vow==vowelArray.length-1){
                    maxLength=Math.max(maxLength,right-left);
                    vow=0;
                    left=right;
                }
                else vow+=1;
            }
        }
        return maxLength;
    }





    /*  Optimized -
     1. If character is  same as previous character - increment the length
     2. Else If character value is greater than the previous character - increment vowel count
     3. Else , reset the count to 1 and length to 1
     4. If vowel count reaches 5 , add to the maxlength

     int cnt=1;
        int len=1;
        int max_length=0;

        int n=word.length();

        for(int i=1;i<n;i++){
            if(word.charAt(i)==word.charAt(i-1)){
                 len++;
            }else if(word.charAt(i-1)<word.charAt(i)){
                cnt++;
                len++;
            }else{
                len=1;
                cnt=1;
            }

            if(cnt==5){
                max_length=Math.max(max_length,len);
            }
        }
        return max_length;
     */
}
