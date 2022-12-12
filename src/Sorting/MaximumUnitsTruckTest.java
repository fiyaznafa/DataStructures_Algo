package Sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumUnitsTruckTest {

    @Test
    public void test1(){
        int[][] boxTypes={{1,3},{2,2},{3,1}};
        System.out.println(maximumUnits(boxTypes,4));
    }


    @Test
    public void test2(){
        int[][] boxTypes={{5,10},{2,5},{4,7},{3,9}};
        System.out.println(maximumUnits(boxTypes,10));
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        //Arrays.sort(intervals,(i,j)->{if(i[0]!=j[0]) return i[0]-j[0]; else return i[1]-j[1];});
        //Arrays.sort(boxTypes,(i, j)->{if(i[0]!=j[0]) return j[1]-i[1]; else return j[0]-i[0];});

        Arrays.sort(boxTypes,(i,j)->{if(i[1]!=j[1])return  j[1]-i[1]; else return j[0]-i[0];});

        int count=0;
            for (int[] eachBox : boxTypes) {
               while (eachBox[0]-->0 && truckSize>0){
                   count+=eachBox[1];
                   truckSize--;

            }
        }

        return count;
    }


}
