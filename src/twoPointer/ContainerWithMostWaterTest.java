package twoPointer;

import org.junit.Test;

public class ContainerWithMostWaterTest {

    @Test
    public void test1(){
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    @Test
    public void test2(){
        int[] height = new int[] {1,1};
        System.out.println(maxArea(height));
    }

    @Test
    public void test3(){
        int[] height = new int[] {1,2,1};
        System.out.println(maxArea(height));
    }


    //15:02 -15:13
    /*
        Pseudocode
        1. With 2 pointers left - 0 and right - end , iterate the array
        2. Calculate water stored - min(left,right)*right-left.
        3. Increase left if left is greater or decrease right if right is greater
        4. Calculcate water stored again and if it is greater than prev water stored then make it max
    */
    public int maxArea(int[] height) {
        int left=0,right=height.length-1,waterStored=0,maxWater=0;
        while(left<right){
            waterStored=Math.min(height[left],height[right])*(right-left);
            maxWater=Math.max(waterStored,maxWater);
            if(height[left]<height[right])left++;
            else right--;
        }
        return maxWater;
    }
}
