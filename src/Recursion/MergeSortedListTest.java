package Recursion;

import LinkedListImp.LinkedListImplementation;
import LinkedListImp.ListNode;
import org.junit.Test;

public class MergeSortedListTest {

    @Test
    public void test1(){
        LinkedListImplementation list1 = new LinkedListImplementation();
        list1.add(1);
        list1.add(5);
        list1.add(6);
        LinkedListImplementation list2 = new LinkedListImplementation();
        list2.add(2);
        list2.add(4);
        list2.add(5);
        ListNode sortedList =mergeList(list1.head,list2.head);
        while(sortedList!=null){
            System.out.print(sortedList.value+" ");
            sortedList=sortedList.next;
        }
        System.out.println();
    }


    @Test
    public void test2(){
        LinkedListImplementation list1 = new LinkedListImplementation();
        list1.add(1);
        list1.add(2);
        LinkedListImplementation list2 = new LinkedListImplementation();
        list2.add(3);
        list2.add(4);
        list2.add(5);
        ListNode sortedList =mergeList(list1.head,list2.head);
        while(sortedList!=null){
            System.out.print(sortedList.value+" ");
            sortedList=sortedList.next;
        }
        System.out.println();
    }

    @Test
    public void test3(){
        LinkedListImplementation list1 = new LinkedListImplementation();
        LinkedListImplementation list2 = new LinkedListImplementation();
        list2.add(3);
        list2.add(4);
        list2.add(5);
        ListNode sortedList =mergeList(list1.head,list2.head);
        while(sortedList!=null){
            System.out.print(sortedList.value+" ");
            sortedList=sortedList.next;
        }
        System.out.println();
    }

    @Test
    public void test4(){
        LinkedListImplementation list1 = new LinkedListImplementation();
        LinkedListImplementation list2 = new LinkedListImplementation();
        list1.add(3);
        list1.add(4);
        list1.add(5);
        ListNode sortedList =mergeList(list1.head,list2.head);
        while(sortedList!=null){
            System.out.print(sortedList.value+" ");
            sortedList=sortedList.next;
        }
        System.out.println();
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;
        if(l1.value<= l2.value){
            l1.next=mergeList(l1.next,l2);
            return l1;
        }
        else {
            l2.next=mergeList(l1,l2.next);
            return l2;
        }
    }

}

