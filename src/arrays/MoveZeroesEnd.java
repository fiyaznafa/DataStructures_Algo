package arrays;

import org.testng.annotations.Test;

import java.util.Arrays;

public class MoveZeroesEnd {

    @Test
    public void test1(){
        int arr[] ={1,0,0,1,1,0};
        int[] output= moveZeroToEnd(arr);
        System.out.println(Arrays.toString(output));
    }

    @Test
    public void test2(){
        int arr[] ={1,1,1,1,1};
        int[] output= moveZeroToEnd(arr);
        System.out.println(Arrays.toString(output));
    }

    @Test
    public void test3(){
        int arr[] ={0,0,0,0,0};
        int[] output= moveZeroToEnd(arr);
        System.out.println(Arrays.toString(output));
    }

    @Test
    public void test4(){
        int arr[] ={};
        int[] output= moveZeroToEnd(arr);
        System.out.println(Arrays.toString(output));
    }

    private int[] moveZeroToEnd(int[] arr) {
        int size=arr.length;

        if(size==0)
            throw new RuntimeException();

        int output[]= new int[size];
        int x=0, y=size-1;

        for (int i=0;i<size;i++) {
            if(arr[i]==0)  output[y--]=0;
            else output[x++]=1;
        }
        return output;
    }
}
