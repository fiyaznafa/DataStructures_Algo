package arrays;

import org.junit.Assert;
import org.junit.Test;

public class FlippingImageTest {

    //https://leetcode.com/problems/flipping-an-image/

//13:30
/*
	Input: image = [[1,1,0],[1,0,1],[0,0,0]]
	Output: [[1,0,0],[0,1,0],[1,1,1]]

	Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
	Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
*/

/* 13:36
	Pseudocode
	1. Iterate the array each element
	2. For each element start from the end and flip the value and add to the output arr
*/

    //Code End - 13: 47 Time complexity O[n2]
    @Test
    public void testData1(){
        int[][] image={{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        Assert.assertArrayEquals(new int[][]{{1,1,0,0},{0,1,1,0},{0,0,0,1},{1,0,1,0}},flipImage(image));
    }

    @Test
    public void testData2(){
        int[][] image={{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        Assert.assertArrayEquals(new int[][]{{1,1,0,0},{0,1,1,0},{0,0,0,1},{1,0,1,0}},flipImageBitWiseOperation(image));
    }

    private int[][] flipImage(int[][] image){
        int [][] output=new int[image.length][image.length];
        for(int i=0;i<image.length;i++){
            for(int j=image.length-1,start=0;j>=0;j--,start++){
                if(image[i][j]==0)output[i][start]=1;
                else output[i][start]=0;
            }
        }
        return output;
    }

    private int[][] flipImageBitWiseOperation(int[][] image){
        for(int i=0;i<image.length;i++){
            for(int start=0,end= image.length-1;start<=end;start++,end--){
                if(start==end)image[i][start]^=1;
                else if(image[i][start]==image[i][end]){
                    image[i][start]^=1;
                    image[i][end]^=1;
                }
            }
        }
        return image;
    }

}
