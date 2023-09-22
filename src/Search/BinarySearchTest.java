package Search;


import org.junit.Test;

public class BinarySearchTest {

 /*   Given an array of integers nums which is sorted in ascending order, and an integer target,
    write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
    Input: nums = [-1,0,3,5,9,12], target =9*/
//09:09
@Test
public void test1(){
int [] arr =new int[]{-1,0,3,5,9,12,26,34};
int target=9;
    System.out.println(findIndex(arr,target));
}

/*Pseudo code - Binary Search
	09:11 - 09:16
1. Assign start end index
2. Calculate mid value - start+end/2
3. If mid is equal to target then return mid
4. Iterate in a loop and
	i. if value at mid is greater than the target, target can be present left of mid - end =mid-1
	ii. if value at mid is greater than the target, target can be present right of mid - start = mid+1
	iii. mid value = start+end/2

	//09:17 - 09:19*/
private int findIndex(int[] arr, int target){
	int start =0, end = arr.length-1;
	int mid = (start+end)/2;

	while(start<=end){
	if(arr[mid]==target)return mid;
	if(arr[mid]>target)end = mid-1;
	else if(arr[mid]<target)start=mid+1;
	mid=(start+end)/2;
	}
	return -1;
}
}
