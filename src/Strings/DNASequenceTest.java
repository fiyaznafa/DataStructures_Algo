package Strings;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DNASequenceTest {
    //https://leetcode.com/problems/repeated-dna-sequences/description/
//187. Repeated DNA Sequences

    @Test
    public void test1(){
        String s="AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences(s));
    }

    @Test
    public void test2(){
        String s="ASDFAS";
        System.out.println(findRepeatedDnaSequences(s));
    }


/*
    Pseudocode - Sliding window
    1. If string length less than 10 digits, return empty list
    2. Take first 10 chars and check if it is available in the string from index 2 to end of string
    3. Move to next word i.e string length from 2 - 11 and check if string is available from 3rd index
    4. If the string is present then add to list
*/


    private List<String> findRepeatedDnaSequences(String s){
        Set<String> set = new HashSet<>();
        if(s.length()<11)return new ArrayList<>();

        for(int i=0;i<s.length()-10;i++){
            //AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT - AAAAACCCCC
                //AAAACCCCCAAAAACCCCCCAAAAAGGGTTT
            //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
            if(s.substring(i+1).contains(s.substring(i,i+10)))
                set.add(s.substring(i, i + 10));
        }
        return new ArrayList<>(set);
    }
}
