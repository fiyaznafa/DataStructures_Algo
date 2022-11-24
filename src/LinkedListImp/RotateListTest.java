package LinkedListImp;

import org.junit.Test;

public class RotateListTest {
    //https://leetcode.com/problems/rotate-list/
//Rotate List

    @Test
    public void test1(){
        LinkedListImplementation list = new LinkedListImplementation();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        ListNode node = rotateRight(list.head, 10);

        while(node!=null){
            System.out.println(node.value);
            node=node.next;
        }

    }

    @Test
    public void test2(){
        LinkedListImplementation list = new LinkedListImplementation();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        ListNode node = rotateRight(list.head, 2);

        while(node!=null){
            System.out.println(node.value);
            node=node.next;
        }

    }

/*
	Pseudocode
	1. Find the length of the list
	2. If k>=length , then k=k%length;
	3. Iterate temp -> till length-k
	4. Assign next element as tempHead
	5. temp -> next - null
	6. Iterate tempHead till null and assign to head
	7. Make tempHead as new head
	8. Return head;
*/

    private ListNode rotateRight(ListNode head, int k){
        if(k==0)return head;
        ListNode temp = head;
        int length=0;
        while(temp!=null){temp=temp.next;length++;}
        if(length<2)return head;
        if(k>length)k=k%length;
        if(k==length || k==0 )return head;
        int count=1;
        temp=head;
        ListNode tempHead;
        while(count<length-k){temp=temp.next;count++;}
        tempHead=temp.next;
        temp.next=null;
        temp=tempHead;
        while(temp.next!=null)temp=temp.next;
        temp.next=head;
        head=tempHead;
        return head;
    }
}
