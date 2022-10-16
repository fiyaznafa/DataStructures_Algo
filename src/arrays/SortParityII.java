package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SortParityII {

    @Test
    public void test1(){
        int[] nums = {4,2,5,7};
        System.out.println(Arrays.toString(sortParity(nums)));
    }

    @Test
    public void test2(){
        int[] nums = {4,2,5,7};
        System.out.println(Arrays.toString(sortParityOptimizeInSpace(nums)));
    }

    @Test
    public void test3(){
        int[] nums = {3,1,4,2};
        System.out.println(Arrays.toString(sortParityOptimizeInSpace(nums)));
    }

    @Test
    public void test4(){
        int[] nums = {648,831,560,986,192,424,997,829,897,843};
        System.out.println(Arrays.toString(sortParityOptimizeInSpace(nums)));
    }



    /*
        Pseudocode
        1. Create to counter 1 for odd and 1 for even
        2. Iterate through the loop and check if value is even if it is even add to even index and increment the counter by 2
        3. If it is odd add to odd and increment the counter by 2

     */

    private int[] sortParity(int[] nums) {

        int[] output = new int[nums.length];
        int evenCount=0, oddCount=1;
        for(int i=0;i<nums.length;i++){
            if((nums[i]^1)>nums[i]) {
                output[evenCount] =nums[i];
                evenCount+=2;
            }
            else {
                output[oddCount] =nums[i];
                oddCount+=2;
            }
        }
        return output;
    }

    /*
     * 	PseudoCode
     *  1. Take two pointer 1 - even starting at 0 , 2nd pointer starting at 1
     *  2. Navigate through the loop
     *  3. If i is even and element at i is even - incerement the even pointer by 2
     *     If i is even and element at i is odd -  add to tempEven variable
     *     If i is odd and element at i is odd - incerement the odd counter by 2
     *     If i is odd and element at i is even -  add to tempOdd variable
     *  4. If tempEven and tempOdd are having value - swap them
     */


    private int[] sortParityOptimizeInSpace(int[] nums) {
        int even=0,odd=1,temp ;

        while(even<= nums.length-2&&odd<= nums.length-1){

            if(nums[even]%2!=0 && nums[odd]%2==0) {
                temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;
                even+=2;odd+=2;
            }

            else if(nums[even]%2==0 && nums[odd]%2==0)even+=2;
            else if(nums[even]%2!=0 && nums[odd]%2!=0)odd+=2;
            else {even+=2;odd+=2;}

        }

        return nums;
    }
}
