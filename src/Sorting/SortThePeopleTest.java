package Sorting;

import org.junit.Test;

import java.util.*;

public class SortThePeopleTest {


    @Test
    public void test1(){
        String[] names={"Mary","John","Emma"};
        int[] heights ={180,165,170};
        String[] output =   sortPeople(names,heights);
        System.out.println(Arrays.toString(output));
    }

    private String[] sortPeople(String[] names, int[] heights) {
        Map<Integer,String> map = new TreeMap<>();
        for(int i=0;i<names.length;i++)
            map.put(heights[i],names[i]);
        return map.values().toArray(new String[0]);
    }
}
