package slidingWindow;

import org.junit.Test;

public class ConsecutiveBlackBlocksTest {
    //https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/

/* Start 17:40
Test data
blocks = "WBBWWBBWBW", k = 7;
blocks = "W", k = 1;
blocks = "B", k = 1;
blocks = "WBWBBBW", k = 2
*/

    @Test
    public void test1(){
        String blocks ="WBBWWBBWBW";
        int k=7;
        System.out.println(consecutiveBlocks(blocks,k));
    }

    @Test
    public void test2(){
        String blocks ="W";
        int k=1;
        System.out.println(consecutiveBlocks(blocks,k));
    }

    @Test
    public void test3(){
        String blocks ="W";
        int k=1;
        System.out.println(consecutiveBlocks(blocks,k));
    }

    @Test
    public void test4(){
        String blocks ="WBWBBBW";
        int k=2;
        System.out.println(consecutiveBlocks(blocks,k));
    }

/*
	Pseudocode
	1. Iterate from i till k , count no of changed character from W to B
	2. Continue iteration till end of string length, add count if next character is W and reduce the count if last character is W
	3. Calcuate the min from count and min
*/


    private int consecutiveBlocks(String blocks, int k){
        int i=0,count=0,min;
        while(i<k){
            if(blocks.charAt(i++)=='W')count++;
        }
        min=count;


        while(i<blocks.length()){
            if(blocks.charAt(i-k)=='W')count--;
            if(blocks.charAt(i++)=='W')count++;
            min=Math.min(min,count);
        }
        return min;
    }


}
