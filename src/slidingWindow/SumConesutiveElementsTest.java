package slidingWindow;

import org.junit.Test;

import static java.lang.Integer.MIN_VALUE;

public class SumConesutiveElementsTest {
    //Highest sum of k consecutive elements


/*
	Start 14:56 End 15:11
	Pseudocode
	1. Two pointers , left - 0, right - 1
	2. Iterate and add the elements to sum till, right -left =3
	3. Move right to next element and add to sum , if right -left >3 , subtract the left value from sum and validate the max value
*/


    @Test
    public void test1() {
        int[] nums = {1, 5, 2, 3, 7, 1};
        int k = 3;
        System.out.println(maxSum(nums, k));
    }

    @Test
    public void test2() {
        int[] nums = {1, 3, 5, 4, 4, 5, 7, 8};
        int k = 4;
        System.out.println(maxSum(nums, k));
    }

    private int maxSum(int[] nums, int k) {
        if (nums.length < k) return 0;
        int left = 0, right = 1;
        int sum = nums[left] + nums[right];
        int maxSum = MIN_VALUE;

        while (right <= nums.length-k+1 ) {

            sum += nums[++right];
            if (right - left == k-1) {
                maxSum = Math.max(sum, maxSum);
            } else if (right - left > k-1) {
                sum -= nums[left++];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }
}
