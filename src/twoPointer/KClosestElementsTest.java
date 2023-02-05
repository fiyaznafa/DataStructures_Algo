package twoPointer;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KClosestElementsTest {
    //https://leetcode.com/problems/find-k-closest-elements/
//658. Find K Closest Elements
    @Test
    public void test1(){
        int[]	arr = new int[]{1,2,3,4,5};
        int k=4;
        int x=3;
        System.out.println(findClosestElements(arr,k,x));
    }

    @Test
    public void test2(){
        int[]	arr = new int[]{1,2,3,4,5};
        int k=4;
        int x=7;
        System.out.println(findClosestElements(arr,k,x));
    }

    @Test
    public void test4(){
        int[]	arr = new int[]{1,3};
        int k=1;
        int x=2;
        System.out.println(findClosestElements(arr,k,x));
    }

    @Test
    public void test3(){
        int[]	arr = new int[]{1,2,3,4,9,10,13};
        int k=4;
        int x=11;
        System.out.println(findClosestElements(arr,k,x));
    }

    private List<Integer> findClosestElements(int[] arr , int k, int x){
        List<Integer> list = new ArrayList<>();
        if(x<=arr[0]){
            for(int i=0;i<k;i++)
                list.add(arr[i]);
            return list;
        }
        else if(x>=arr[arr.length-1]){
            for(int i=arr.length-k;i<arr.length;i++)
                list.add(arr[i]);
            return list;
        }
        else {
            int index=findIndex(arr,x);
            list.add(arr[index]);
            int left=index-1,right=index+1,element=0;
            while(list.size()!=k && left>=0 && right<arr.length){
                element = Math.abs(x-arr[left])<=Math.abs(arr[right]-x)?left--:right++;
                list.add(arr[element]);
            }
            if(list.size()!=k){
                if(right>=arr.length){
                    while(list.size()!=k)list.add(arr[left--]);
                }
                else {
                    while(list.size()!=k)list.add(arr[right++]);
                }
            }
        }
        Collections.sort(list);

        return list;
    }

    public int findIndexBinarySearch(int[] arr,int x){
        int low =0, high=arr.length-1;
        int mid=(low+high)/2;
        while(low<high){
            if(arr[mid]==x)return mid;
            else if(x<arr[mid])high=mid-1;
            else low=mid+1;
            mid=(low+high)/2;
        }
        if(low==high)return low;
        return Math.abs(arr[low]-x)<=Math.abs(arr[high]-x)?low:high;
    }


    public int findIndex(int[] arr,int x){
        int low =0, high=arr.length-1;
        int mid=(low+high)/2;
        while(low<high){
            if(arr[mid]==x)return mid;
            else if(x<arr[mid])high=mid-1;
            else low=mid+1;
            mid=(low+high)/2;
        }
        if(low==high)return low;
        return Math.abs(arr[low]-x)<=Math.abs(arr[high]-x)?low:high;
    }
}
