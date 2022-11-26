package twoPointer;

public class SquareSortedArrayTest {

    //https://leetcode.com/problems/squares-of-a-sorted-array/
//977. Squares of a Sorted Array
// Start - 08:16 - 08:34




/*

testdata [-4,-1,0,3,10]
testdata [-7,-3,2,3,11]
	Pseudocode - Two pointer
	1. Iterate the array With one pointer at start of the                                                                                                                                                                                                       array and 2nd pointer at the end of the array.
	2. If Math.abs (left>right)
		Add the square to the left to output of array
		increase the left array
	3. Else add square of right to output array
		decrease the right pointer
*/

    public int[] sortedSquares(int[] nums) {

        int left=0,right=nums.length-1,index= nums.length-1;
        int[] output= new int[index+1];
        while(left<=right){
            if(Math.abs(nums[left])>Math.abs(nums[right])){
                output[index--]=nums[left]*nums[left];
                left++;
            }
            else{
                output[index--]=nums[right]*nums[right];
                right--;
            }
        }
        return output;
    }
}
