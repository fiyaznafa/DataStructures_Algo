package Sorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntevalsTest {

    @Test
    public void test2(){
        int[][] intervals={{1,3},{8,10},{2,6},{15,18}};
        System.out.println(Arrays.deepToString(mergeIntervals(intervals)));
    }

    @Test
    public void test1(){
        int[][] intervals={{1,2},{2,6},{1,10},{15,18}};
        System.out.println(Arrays.deepToString(mergeIntervals(intervals)));
    }

    private int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals,(i,j)->{
            if (i[0]!=j[0])return i[0]-j[0];else return i[1]-j[1];
        });
        List<int[]> list = new ArrayList<>();
        int[] interval = intervals[0];

        for (int[] newInterval : intervals) {
            if (interval[1] >= newInterval[0]) {
                list.remove(interval);
                interval[1] = Math.max(interval[1], newInterval[1]);
            }
            else interval=newInterval;
            list.add(interval);
        }
        return list.toArray(new int[][]{});
        }
}
