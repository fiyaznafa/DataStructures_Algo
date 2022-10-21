package arrays;

import org.junit.Test;

public class ReversePrefixTest {
    //https://leetcode.com/problems/reverse-prefix-of-word/
//Start 15:34  end 15:53 , Debug Start 15:53 end 15:59

    @Test
    public void test1(){
        String word ="abcdefd";
        char ch='d';
        System.out.println(reversePrefixWord(word,ch));
    }

    @Test
    public void test2(){
        String word ="xyxzxe";
        char ch='z';
        System.out.println(reversePrefix(word,ch));
    }

    @Test
    public void test3(){
        String word ="abcd";
        char ch='z';
        System.out.println(reversePrefix(word,ch));
    }

    @Test
    public void test4(){
        String word ="eqdvhs";
        char ch='s';
        System.out.println(reversePrefix(word,ch));
    }


/*
	Pseudocode
	1. Take pointe right =0,index;
	2. Iterate till target char is found and assign index;
	3. Reverse the substring by navigating the char from right till 1st character add to string
	4. From i+1 char add till the end of the string
*/

    private String reversePrefixWord(String word,char ch){
        if(word.length()==1) return word;
        StringBuilder sb = new StringBuilder();
        int right=0,index;
        boolean flag=false;
        while(right<word.length()){
            if(word.charAt(right)==ch && !flag){
                index = right;
                while(right >=0) sb.append(word.charAt(right--));
                right=index;
                flag=true;
            }
            else if(flag)sb.append(word.charAt(right));
            right++;
        }
        if(!flag)sb.append(word);
        return sb.toString();
    }

    private String reversePrefix(String word,char ch) {
        if (word.length() == 1) return word;
        StringBuilder sb = new StringBuilder();
        int right = 0, index = 0;
        while (right < word.length()) {
            if (word.charAt(right) == ch ) {
                index = right;
                break;
            }
            right++;
        }
        if(right==word.length())return word;

        while(right>=0)sb.append(word.charAt(right--));
        right=index+1;
        while(right<word.length())sb.append(word.charAt(right++));

        return sb.toString();
    }
}
