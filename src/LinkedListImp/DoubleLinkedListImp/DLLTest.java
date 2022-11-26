package LinkedListImp.DoubleLinkedListImp;

public class DLLTest {

    public static void main(String[] args) {
        DoubleLinkedListImp list = new DoubleLinkedListImp();
        list.addAtEnd(10);
        list.addAtEnd(20);
        list.addAtEnd(30);
        list.display();
        list.addAtStart(5);
        list.display();

        list.addAtStart(3);
        list.display();

        System.out.println(list.get(0));
        System.out.println(list.get(2));
        System.out.println(list.get(4));

        list.remove(1);
        list.display();

        list.remove(3);
        list.display();

        list.set(0,0);
        list.display();

        list.set(2,2);
        list.display();

        list.set(1,1);
        list.display();

        list.addAtEnd(20);
        list.addAtEnd(30);
        list.addAtStart(20);
        list.addAtStart(50);
        list.addAtStart(20);
        list.addAtEnd(20);
        list.display();
        list.removeAllValue(20);
        list.display();
        System.out.println(list.size());
        int[] arr = new int[]{1,2,3,4,5};
        list.addAll(arr);
        list.display();
        System.out.println(list.size());
    }
}
