package slidingWindow;

import org.junit.Test;

public class NumberOfNiceSubArrayTest {
    //https://leetcode.com/problems/count-number-of-nice-subarrays/description/
    //1248. Count Number of Nice Subarrays

    @Test
    public void test1(){
        int[] nums ={1,2,1,2,3};
        int k=2;
        System.out.println(numberOfSubarrays(nums,k));
    }

    @Test
    public void test2(){
        int[] nums ={2,4,6};
        int k=1;
        System.out.println(numberOfSubarrays(nums,k));
    }

    @Test
    public void test3(){
        int[] nums ={2,2,2,1,2,2,1,2,2,2};
        int k=2;
        System.out.println(numberOfSubarrays(nums,k));
    }

    @Test
    public void test4(){
        int[] nums ={1,1,1};
        int k=1;
        System.out.println(numberOfSubarrays(nums,k));
    }

        private int numberOfSubarrays(int[] nums, int k) {
            return atMostCount(nums,k)-atMostCount(nums,k-1);
        }



    private int atMostCount(int[] nums, int k) {
        int countK=0, left=0,right=0, subArrayCount=0;
        for(int i=0;i<nums.length;i++){
            if(nums[right]%2==1)countK++;
            while(countK>k && left<right){
                if(nums[left++]%2==1)countK--;
            }
            subArrayCount+=countK>k?0:right-left+1;
            right++;
        }
        //System.out.println(subArrayCount);
        return subArrayCount;
    }
}
