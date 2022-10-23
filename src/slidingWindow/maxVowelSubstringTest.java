package slidingWindow;

import org.junit.Test;

public class maxVowelSubstringTest {
    /*Given a string s and a number k, find the maximum number of vowels in substring of size k.
    String: "workaattech"
    k: 3
    */

/*
	Test Data
	1. String: "workaattech" k=3
	2. String: "workaattech" k=4
	3. String: "a" k=1
	3. String: "work" k=5
*/

    @Test
    public void test1(){
        String str= "workaattech";
        int k=3;
        System.out.println((maxVowelsSubString(str,k)));
    }

    @Test
    public void test2(){
        String str= "workaattech";
        int k=2;
        System.out.println((maxVowelsSubString(str,k)));
    }


    @Test
    public void test3(){
        String str= "a";
        int k=1;
        System.out.println((maxVowelsSubString(str,k)));
    }

    @Test
    public void test4(){
        String str= "work";
        int k=5;
        System.out.println((maxVowelsSubString(str,k)));
    }
    /*
    *   Bruteforce
    *   1. Using two for loops, one till
    *   2.
    */



/*
	Pseudocode - Sliding window
	1. Iterate the loop till k and count the vowels
	2. From k iterate till the end of the loop
	3. Increment pointer on right and remove the value to left if it is vowel
	4. If count  > max , replace max with count
	5. If max is equal to k , return k
*/

    private int maxVowelsSubString(String str, int k){
        int count = 0,max,i=0;
        if(k>str.length())return 0;
        while(i<k){
            if(isVowel(str.charAt(i++)))count++;
        }
        max=count;

        while(i<str.length()){
            if(isVowel(str.charAt(i-k)))count--;
            if(isVowel(str.charAt(i++)))count++;
            max=Math.max(count,max);
            if(max==k)
                return k;
        }
        return max;
    }

    private boolean isVowel(char c){
         return (c == 'a' || c=='e' || c=='i' || c=='o' || c=='u');
    }
}
