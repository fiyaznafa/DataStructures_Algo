package QueueImp;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class StudentAndSandwichesTest {
    //https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/description/
//1700. Number of Students Unable to Eat Lunch

    @Test
    public void test1(){
        int[] students={1,1,0,0};
        int[] sandwiches={0,1,0,1};
        Assert.assertEquals(0,countStudents(students,sandwiches));
    }

    @Test
    public void test2(){
        int[] students={1,1,1,0,0,1};
        int[] sandwiches={1,0,0,0,1,1};
        Assert.assertEquals(3,countStudents(students,sandwiches));
    }

/*
	Pseudocode
	1. Implement two queue studentQueue and sandwichQueue
	2. If the element at studentQueue matches sandwichQueue remove both studentQueue and sandwichQueue , reset counter to zero
	3. If the element at studentQueue is not same as sandwichQueue
		Remove the student from studentQueue and add to the Queue (end)
		and increase counter
	4. Iterate until end of the queue or till count reaches greater than size of studentQueue

*/

    private int countStudents(int[] students, int[] sandwiches){
        Queue<Integer> studentQueue = new ArrayDeque<>();
        Queue<Integer> sandwichQueue = new ArrayDeque<>();

        for (int eachStudent:students) studentQueue.add(eachStudent);
        for (int eachSandwich:sandwiches) sandwichQueue.add(eachSandwich);

        int count=0;
        while(count!=studentQueue.size()&& !studentQueue.isEmpty()){
            if(studentQueue.peek().equals(sandwichQueue.peek())){
                sandwichQueue.remove();
                count=0;
            }
            else {
                studentQueue.add(studentQueue.peek());
                count++;
            }
            studentQueue.remove();
        }
        return count;
    }
}
