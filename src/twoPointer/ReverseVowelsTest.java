package twoPointer;

import org.junit.Test;

public class ReverseVowelsTest {

    //https://leetcode.com/problems/reverse-vowels-of-a-string/	 08:26

/*Data
Input: s = "hello" Output: "holle"
Input: s = "leetcode" Output: "leotced
Input: s = "lbcedgh" Output:"lbcedgh"
*/

    @Test
    public void test1(){
        String s = "hello";
        System.out.println(reverseVowel(s));
    }

    @Test
    public void test2(){
        String s = "leetcode";
        System.out.println(reverseVowel(s));
    }

    @Test
    public void test3(){
        String s = "lbcedgh";
        System.out.println(reverseVowel(s));
    }

    @Test
    public void test4(){
        String s = "aA";
        System.out.println(reverseVowel(s));
    }

//8:30
/*
	Pseudocode
	1. Iterate through the string characters , left at 0 and right at end.
	2. If left is vowel  and right is vowel , swap them
	3. If right is not vowel , move only right
	4. If left is not vowel move only left
	5. Else move both left and right
*/

    public String reverseVowel(String s){
        int left =0, right =s.length()-1;
        char temp;
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        while(left<right){ //Time complexity O[n]


            if(isVowel(chars[left]) &&  isVowel(chars[right])){
                temp=chars[left];
                chars[left++]=chars[right];
                chars[right--]=temp;
            }

            else if (!isVowel(chars[left])) {
                left++;
            }
            else if(!isVowel(chars[right]))
            right--;
            else {
                left++;right--;
            }
        }
        for(char c:chars)
            sb.append(c);

        return  sb.toString();
    }
    
    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

}
