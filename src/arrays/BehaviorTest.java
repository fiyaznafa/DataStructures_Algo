package arrays;

import org.junit.Test;

public class BehaviorTest {

    @Test
    public void test1(){
        int[] behaviour={3,1,4,5,2};
        System.out.println(findBehaviour(behaviour));
    }

    private int findBehaviour(int[] behaviour) {
        int current=0, prevValue=0,nextValue=0,result=0;
        while(current< behaviour.length){
            if(current==0){
                prevValue=0;
                nextValue=behaviour[current+1];
            }
            else if(current== behaviour.length-1){
                nextValue=0;

            }
            else{
                prevValue=current-1;
                nextValue=current+1;
            }
            if(((behaviour[prevValue]+behaviour[nextValue])/2) < behaviour[current])result++;
            current++;
        }

    return result;
    }
}
