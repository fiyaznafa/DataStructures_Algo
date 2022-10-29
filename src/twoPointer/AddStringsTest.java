package twoPointer;

import org.junit.Assert;
import org.junit.Test;

public class AddStringsTest {
    //https://leetcode.com/problems/add-strings/
//13:04 - 13:19

    @Test
    public void test1(){
        String num1 = "11";
        String num2 = "123";
        Assert.assertEquals("134",addTwoStrings(num1,num2));
    }


    @Test
    public void test2(){
        String num1 = "156";
        String num2 = "99";
        Assert.assertEquals("255",addTwoStrings(num1,num2));
    }

    @Test
    public void test3(){
        String num1 = "0";
        String num2 = "0";
        Assert.assertEquals("0",addTwoStrings(num1,num2));
    }

/*
Pseudocode
	1. Take two i - starting from end of num1 and j starting from end of num2 and carry as 0
	2. Iterate till both strings end and carry is 0
	3. Calcualate the sum by adding numeric value of each character
	4. Sum should be sum%10 and carry should be sum/10;
	5. Add sum to string and return the string at end of iteration   Complete:13:13
*/

    private String addTwoStrings(String num1,String num2){
        int i=num1.length()-1,j=num2.length()-1,sum,carry=0;
        int nums1,nums2;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>=0 || carry==1){
            if(i>=0)nums1=Character.getNumericValue(num1.charAt(i--));
            else nums1=0;
            if(j>=0)nums2=Character.getNumericValue(num2.charAt(j--));
            else nums2=0;
            sum=nums1+nums2+carry;
            carry=sum/10;
            sb.append(sum%10);
        }
        return sb.reverse().toString();

    }
}
