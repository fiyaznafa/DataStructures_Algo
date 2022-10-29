package twoPointer;

public class TwoSumIITest {
    /*
@Test
public void test1(){
int[] nums ={2,7,11,15};
int target =9;
twoSum(nums,target);
}

@Test
public void test2(){
int[] nums ={2,3,4};
int target =0;
twoSum(nums,target);
}


@Test
public void test3(){
int[] nums ={-4,-3,-2,0,1,2}|;
int target =-5;
twoSum(nums,target);
}

@Test
public void test3(){
int[] nums ={-4,-3,-2,0,1,2}|;
int target =0;
twoSum(nums,target);
}

*/

/*
	Pseudocode
	Brute force
	1. Outer loop, Iterate till last but one element  //i=0; i<nums.length-1
	2. Inner loop, Iterate till last element
	3. If target matches = nums[i]+nums[j] , return i and j
*/

        /*
private int[] twoSumBruteForce(int[] nums,int target){

	for(int i=0;i<nums.length-1;i++){
		for(int j=i;j<nums.length;j++){
		if(nums[i]+nums[j]==target)return new int[] {i,j};
		}
	}
	return new int[]{};
}
*/

    /*
        Pseudocode
        Algorithm Two Pointer

        1. Two pointers left - 0 and right at end , iterate till left <right
        2. If nums[left]+nums[right]>target  ->  right --
        3. If nums[left]+nums[right]<target  -> left++
        4. Else return left and right

    */
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) right--;
            else if (nums[left] + nums[right] < target) left++;
            else return new int[]{left + 1, right + 1};
        }

        return new int[]{};
    }
}


