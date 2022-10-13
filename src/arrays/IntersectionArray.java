package arrays;

import org.testng.annotations.Test;

import java.util.*;

public class IntersectionArray {

    @Test
    public void test1(){
        int[] x= {1,2,2,1};
        int[] y= {2,2};
        Set<Integer> intersection = findIntersection(x, y);
        System.out.println(intersection);
    }

    @Test
    public void test2(){
        int[] x= {1,2,3,1};
        int[] y= {2,3};
        Set<Integer> intersection = findIntersection(x, y);
        System.out.println(intersection);
    }

    @Test
    public void test3(){
        int[] x= {1,2,3,4};
        int[] y= {5,6};
        Set<Integer> intersection = findIntersection(x, y);
        System.out.println(intersection);
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



    private Set<Integer> findIntersection(int[] x, int[] y) {
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
        return set;
    }
}
