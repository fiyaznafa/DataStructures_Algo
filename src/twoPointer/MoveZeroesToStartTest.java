package twoPointer;

import org.junit.Test;

import java.util.Arrays;

public class MoveZeroesToStartTest {


    @Test
    public void test1(){
        int[] arr ={0,2,0,0,1,4,6,3};
        moveZeroesStart(arr);
    }

    @Test
    public void test2(){
        int[] arr ={0,2,3,4,1,4,6,0};
        moveZeroesStart(arr);
    }

    @Test
    public void test3(){
        int[] arr ={8,0,0,0,0,0};
        moveZeroesStart(arr);
    }
    /*[0,2,0,0,1,4,6,3]

      [0,0,0,2,1,0,6,3]


*/


    /*
        Pseudocode - two pointer
        1. Iterate from the end to start
        2. Whenever the el r=0,
     */


    public static void moveZeroesStart(int[] arr) {
        int right= arr.length-1,left= arr.length-1;
        int temp=0;
        while(left>=0){
            if(arr[left]==0){
                right=left;
                while (right>0 && arr[right]==0)right--;
                temp=arr[left];
                arr[left]=arr[right];
                arr[right--]=temp;
            }
            left--;

        }
        System.out.println(Arrays.toString(arr));
        }

}
