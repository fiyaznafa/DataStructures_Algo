package Maps;

import org.junit.Test;
import org.testng.Assert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TownJudgeTest {
    //997. Find the Town Judge
    //https://leetcode.com/problems/find-the-town-judge/
    @Test
    public void test1(){
        int n=2;
        int[][]trust=new int[][]{{1,2}};
        Assert.assertEquals(2,townJudge(n,trust));
    }


    @Test
    public void test2(){
        int n=3;
        int[][]trust=new int[][]{{1,3},{2,3},{3,1}};
        Assert.assertEquals(-1,townJudge(n,trust));
    }

    @Test
    public void test3(){
        int n=3;
        int[][]trust=new int[][]{{1,3},{2,3}};
        Assert.assertEquals(3,townJudge(n,trust));
    }

    @Test
    public void test4(){
        int n=4;
        int[][]trust=new int[][]{{1,3},{1,4},{2,3},{2,4},{4,3}};
        Assert.assertEquals(3,townJudge(n,trust));
    }

    /*
        Pseudocode
        1. Add all the folks of the town to a set
        2. Check the people who are trusted - trust[i][1] and Add then to map
        3. The potential candidate whom every one trust and is not there in folk set is the Judge
            (In the map count of candidate should be n-1 and should not be present in folk set)
     */

    private int townJudge(int n, int[][] trust) {
        Set<Integer> folksTown = new HashSet<>();
        int allCandidate ;
        Map<Integer,Integer> candidate = new HashMap<>();
        for (int[] arr:trust) {
            folksTown.add(arr[0]);
        }
        for (int[] arr : trust){
            allCandidate=arr[1];
        candidate.put(allCandidate,candidate.getOrDefault(allCandidate,0)+1 );
        }
        for (int potentialCandidate:candidate.keySet())
            if((candidate.get(potentialCandidate)==n-1) && !folksTown.contains(potentialCandidate))return potentialCandidate;

        return -1;
    }
}
