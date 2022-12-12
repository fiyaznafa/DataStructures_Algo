package arrays;

import org.junit.Test;

import java.util.Arrays;

public class ProductOtherNosTest {



    @Test
    public void test1(){
        int[] arr ={1,2,3,4};
        System.out.println(Arrays.toString(findArray(arr)));
    }

    @Test
    public void test2(){
        int[] arr ={3,2,0,4};
        System.out.println(Arrays.toString(findArray(arr)));
    }

    @Test
    public void test3(){
        int[] arr ={3,2,0,0};
        System.out.println(Arrays.toString(findArray(arr)));
    }

    public int[] findArray(int[] nums){
        boolean flag=false;
        int product=1;
        for (int num : nums) {
            if (num == 0) {
                flag = true;
                continue;
            }
            product *= num;
        }

        for(int i=0;i<nums.length;i++)
        {
            if(flag && nums[i]==0)nums[i]=product;
            else if(flag && nums[i]!=0)nums[i]=0;
            else nums[i]=product/nums[i];

        }
        return nums;

    }
}
