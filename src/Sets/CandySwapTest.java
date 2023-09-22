package Sets;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class CandySwapTest {

    //888. Fair Candy Swap
//https://leetcode.com/problems/fair-candy-swap/

    @Test
    public void test1(){
        int[] aliceSizes ={1,1};
        int[] bobSizes  ={2,2};
        Assert.assertArrayEquals(new int[]{1,2}, fairCandySwap(aliceSizes,bobSizes));
    }

    @Test
    public void test2(){
        int[] aliceSizes ={1,2};
        int[] bobSizes  ={2,3};
        Assert.assertArrayEquals(new int[]{1,2}, fairCandySwap(aliceSizes,bobSizes));
    }

    @Test
    public void test3(){
        int[] aliceSizes ={2};
        int[] bobSizes  ={1,3};
        Assert.assertArrayEquals(new int[]{2,3}, fairCandySwap(aliceSizes,bobSizes));
    }

/*
	Pseudcode
	1. Add all the elements of aliceSizes to aliceList and find the aliceSum
	2. Add all the elements of bobSizes to bobList and find the bobSum
	3. Find the avg of the sums, diffAlice
	4. Iterate through each element of aliceSize and find diffAlice+element of aliceSizes is present in bobSizes
	5. Return  diffAlice+element and aliceCandy

*/

private int[] swapCandies(int[] aliceSizes, int[] bobSizes){
    int aliceTotal=0,bobTotal=0,avg=0,diff=0;
    Set<Integer>  set = new HashSet<>();
    for(int eachCandy:aliceSizes){
        aliceTotal+=eachCandy;
        set.add(eachCandy);
    }
    for(int eachCandy:bobSizes)bobTotal+=eachCandy;
    avg=(aliceTotal+bobTotal)/2;
    diff=aliceTotal-avg;
    for(int eachCandy:bobSizes){
        if(set.contains(eachCandy+diff))
            return new int[] {eachCandy+diff,eachCandy};
    }
    return new int[]{};
    }

    public int[] fairCandySwap(int[] A, int[] B) {
        int dif = (IntStream.of(A).sum() - IntStream.of(B).sum()) / 2;
        HashSet<Integer> S = new HashSet<>();
        for (int a : A) S.add(a);
        for (int b : B) if (S.contains(b + dif)) return new int[] {b + dif, b};
        return new int[0];
    }
}
