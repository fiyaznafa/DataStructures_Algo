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

}
