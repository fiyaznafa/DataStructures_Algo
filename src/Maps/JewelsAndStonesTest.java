package Maps;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStonesTest {
    //https://leetcode.com/problems/jewels-and-stones/

    @Test
    public void test1(){
        String jewels="aA";
        String stones="aAAbbbb";
        Assert.assertEquals(3,noOfJewelsInStones(jewels,stones));
    }

    @Test
    public void test2(){
        String jewels="z";
        String stones="ZZ";
        Assert.assertEquals(0,noOfJewelsInStones(jewels,stones));
    }

    private int noOfJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        int count=0;
        for (Character c:jewels.toCharArray()) {
            set.add(c);
        }
        for (Character c:stones.toCharArray()) {
            if(set.contains(c))count++;
        }
        return count;
    }
}
