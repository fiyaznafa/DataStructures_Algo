package Search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KClosestElementsTest {

    @Test
    public void test1(){
        int[] nums ={1,2,3,4,5};
        int k=4,x=3;
        System.out.println(findClosestElements(nums,k,x));
    }

    @Test
    public void test2(){
        int[] nums ={1,2,3,4,5};
        int k=4,x=-1;
        System.out.println(findClosestElements(nums,k,x));
    }

    @Test
    public void test3(){
        int[] nums ={1,2,3,4,8,10,11};
        int k=4,x=6;
        System.out.println(findClosestElement(nums,k,x));
    }

    /*
        Pseudocode - Using search
        1. Find the index if available or where it would be inserted
        2. If index-no is lesser than left(i.e. index-1) - no  then add index to list and increment index value
        3. Else add left(index-1) and decrement left value
        4. If reached the end then add the elements from other end
     */
    private List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int right=findIndex(arr,x);
        int left=right-1;
        while(right<arr.length && left>=0 && list.size()<k){
            int no=Math.abs(arr[left]-x)<=Math.abs(arr[right]-x)?arr[left--]:arr[right++];
            list.add(no);
        }

        if(list.size()<k && right==arr.length){
            while(list.size()<k)list.add(arr[left--]);
        }

        else if(list.size()<k && left<=0){
            while(list.size()<k)list.add(arr[right++]);
        }
        Collections.sort(list);
        return list;
    }

    public int findIndex(int[] arr,int x){
        int low =0, high=arr.length-1,mid;
        while(low<=high){
            mid=(low+high)/2;
            if(arr[mid]==x)return mid;
            else if(x>arr[mid])low=mid+1;
            else high=mid-1;
        }
        return low;
    }


    /*
        Pseudocode - Two pointer
        1. Since it is sorted use two pointers to get the range of the elements , left at 0 and right at end
        2. Iterate until the size of the range (i.e. right-left==k)
        3. If x- value at left is greater than value right - x, then increment left
        4. Else Decrement right
        5. When right-left==k add values to list
     */

    public List<Integer> findClosestElement(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int left=0,right=arr.length-1;
        while(right-left>=k){
            if(x-arr[left]  > arr[right]-x)left++;
            else right--;
        }

        for(int i=left;i<=right;i++)
            list.add(arr[i]);
        return list;
    }
}
