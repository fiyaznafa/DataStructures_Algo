package twoPointer;


import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class IntersectionArray {

    @Test
    public void test1(){
        int[] x= {1,2,2,1};
        int[] y= {2,2};
        Assert.assertArrayEquals(new int[]{2,2},findIntersection(x,y));
    }

    @Test
    public void test2(){
        int[] x= {1,2,3,1};
        int[] y= {2,3};
        Assert.assertArrayEquals(new int[]{1,2},findIntersection(x,y));
    }

    @Test
    public void test3(){
        int[] x= {1,2,3,4};
        int[] y= {5,6};
        Assert.assertArrayEquals(new int[]{},findIntersection(x,y));
    }

    /*
        Two pointer algo
        PseudoCode
        1. Sort the Array
        2. With one pointer on 1st array and 2nd pointer on 2nd array iterate
        3. If value of 1st array < Value of 2nd array move the 1st array pointer next
        (also check if next element is same then keep moving ahead until next element is different)
        4. If value of 2nd array < Value of 1st array move the 2nd array pointer next
        5. If value matches then add to list
        5. Iterate until any of the array reaches end
     */



    private int[] findIntersection(int[] x, int[] y) {
        Arrays.sort(x);
        Arrays.sort(y);

        Set<Integer> set = new HashSet<>();
        int m=0,n=0;
        while(m< x.length && n< y.length){
            if(x[m]==y[n]) {
                set.add(x[m]);
                m++;n++;
            }
            else if (x[m]<y[n]){
                m++;
            }
            else{
                n++;
            }
        }
        int[] output = new int[set.size()];
        int j=0;
        for (int i:set) {
            output[j++]=i;
        }
        return output;
    }
}
