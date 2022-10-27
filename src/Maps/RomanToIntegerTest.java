package Maps;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class RomanToIntegerTest {

    //https://leetcode.com/problems/roman-to-integer/

    @Test
    public void test1(){
        String str = "LVIII";
        Assert.assertEquals(58,romanToInteger(str));
    }

    @Test
    public void test2(){
        String str = "MCMXCIV";
        Assert.assertEquals(1994,romanToInteger(str));
    }

/*
	Pseudocode
	1. Add all roman no and corresponding value to map
	2. Iterate through the str from the right, and add the sum
	3. Check if character is 'V' and prev character is I, then reduce the value by 1
	4. Check if character is 'L' or 'C' and prev character is X, then reduce the value by 10
	5. Check if character is 'D' or 'M' and prev character is C, then reduce the value by 100
*/

    private int romanToInteger(String str){
        int index=str.length()-1;
        int sum=0;
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        while(index>=0){
            if(str.charAt(index)=='I' && index<str.length()-1 && (str.charAt(index+1)=='X'||str.charAt(index+1)=='V'))sum-=1;
            else if(str.charAt(index)=='X' && index<str.length()-1 && (str.charAt(index+1)=='L'||str.charAt(index+1)=='C')) sum-=10;
            else if(str.charAt(index)=='C' && index<str.length()-1 && (str.charAt(index+1)=='D'||str.charAt(index+1)=='M'))sum-=100;
            else sum+=map.get(str.charAt(index));
            index--;
        }
        return sum;
    }
}
