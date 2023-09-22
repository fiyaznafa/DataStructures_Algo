package Sets;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class KeyBoradRowTest {
    //500. Keyboard Row
//https://leetcode.com/problems/keyboard-row/

    @Test
    public void test1(){
        String[] eachWords={"Hello","Alaska","Dad","Peace"};
        System.out.println(Arrays.toString(findeachWords(eachWords)));
    }

    @Test
    public void test2(){
        String[] eachWords={"omk"};
        System.out.println(Arrays.toString(findeachWords(eachWords)));
    }
    @Test
    public void test3(){
        String[] eachWords={"adsdf","sfd"};
        System.out.println(Arrays.toString(findeachWords(eachWords)));
    }

    @Test
    public void test4(){
        String[] eachWords={"a","b"};
        System.out.println(Arrays.toString(findeachWords(eachWords)));
    }

/*
	Pseudocode
	1. Create 3 set for each row and a counter for each row - row1Set ,row2Set, row3Set and row1Count,row2Count, row3Count
	2. Iterate over each char and check if it contains in set1 set2 and set3
		if(row1Count>1 && row2Count==0 && row3Count==0);
		else if(row2Count>1 && row1Count==0 && row3Count==0);
		else if(row3ount>1 && row1Count==0 && row2Count==0);
		else break;
	3. If you reach end of the string add to the list
	4. Return the list
*/


    HashSet<Character> row1Set = new HashSet<>(Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
    HashSet<Character> row2Set = new HashSet<>(Arrays.asList('a','s','d','f','g','h','j','k','l'));

    private String[] findeachWords(String[] eachWords){
        List<String> list = new ArrayList<>();
        for(String eachWord: eachWords)
            if(sameRowKeyBoard(eachWord))list.add(eachWord);
        return list.toArray(new String[0]);
    }

    private boolean sameRowKeyBoard(String word) {
        int row1Count=0,row2Count=0,row3Count=0;

        for(char c:word.toCharArray()){
            if(row1Set.contains(Character.toLowerCase(c)))row1Count++;
            else if(row2Set.contains(Character.toLowerCase(c)))row2Count++;
            else row3Count++;

            if(row1Count>=1 && row2Count>=1 )return false;
            else if(row2Count>=1 && row3Count>=1)return false;
            else if(row1Count>=1 && row3Count>=1)return false;
        }
        return true;
    }
}
