package Maps;

import org.junit.Test;

import java.util.*;

public class DominoPairsTest {

    //https://leetcode.com/problems/number-of-equivalent-domino-pairs/

/*
	Pseudocode - Brute force O[n2]
	1. Iterate through the array
	2. For first array , add all the elements to initalMap
	3. Iterate the whole array length and add each element to secondMap
	4. If secondMap ==  initalMap , count++;
	5. Take the next element
*/

    @Test
    public void test1(){
        int[][]  dominoes = new int[][]{{1,2},{2,1},{3,4},{5,6}};
        System.out.println(findNoDominosesMap(dominoes));
    }

    @Test
    public void test2(){
        int[][]  dominoes = new int[][]{{1,2},{1,2},{1,1},{1,2},{2,2}};
        System.out.println(findNoDominosesMap(dominoes));
    }

    private int findNoDominoes(int[][] dominoes){
        int count=0;
        Set<Integer> initalSet = new HashSet<>();
        Set<Integer> secondSet = new HashSet<>();
        for(int i=0;i<dominoes.length-1;i++){
            initalSet.clear();
            for(int nos:dominoes[i])initalSet.add(nos);
            for(int j=i+1;j<dominoes.length;j++){
                for(int nos:dominoes[j])secondSet.add(nos);
                if(initalSet.equals(secondSet))count++;
                secondSet.clear();
            }
        }
        return count;
    }

    private int findNoDominosesMap(int[][] dominoes){
        Map<Integer,Integer> map = new HashMap<>();
        int count=0;
        for (int[] eachDomino: dominoes) {
            int temp=Math.min(eachDomino[0],eachDomino[1])*10+Math.max(eachDomino[0],eachDomino[1]);
            map.put(temp,map.getOrDefault(temp,0)+1);
        }

        for (Integer values:map.values()) {
            if(values>1)
                count+=(values*(values-1))/2;
        }
        return count;
    }




}
