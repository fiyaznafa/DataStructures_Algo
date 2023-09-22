package Sets;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class WordsCanBeTypedTest {
    //1935. Maximum Number of Words You Can Type
//https://leetcode.com/problems/maximum-number-of-words-you-can-type/

    @Test
    public void test1(){
        String text="hello world";
        String brokenLetters="ad";
        Assert.assertEquals(1,maxTypedWords(text,brokenLetters));
    }

    @Test
    public void test2(){
        String text="leet code";
        String brokenLetters="lt";
        Assert.assertEquals(1,maxTypedWords(text,brokenLetters));
    }

    @Test
    public void test3(){
        String text="leet code";
        String brokenLetters="e";
        Assert.assertEquals(0,maxTypedWords(text,brokenLetters));
    }

/*
	Psuedocode
	1. Add all banned letters to Set
	2. Iterate each word
	3. For each word check each letters
	4. If char is present in set return false
	5. Else increment count and return count
*/


    private int maxTypedWords(String text, String brokenLetters){
        Set<Character> set = new HashSet<>();
        int count=0;
        for(char c:brokenLetters.toCharArray())set.add(c);
        for(String word:text.split(" ")){
            if(canBeTyped(word,set))count++;
        }
        return count;
    }

    private boolean canBeTyped(String word,Set<Character> bannedLetters){
        for(char c: word.toCharArray())if(bannedLetters.contains(c))return false;
        return true;
    }
}
