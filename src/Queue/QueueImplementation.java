package Queue;


public class QueueImplementation {

    QueueNode head;
    QueueNode tail;
    int length=0;

    public void add(int value){
        if(head==null)head=tail=new QueueNode(value);
        else{
            tail.next=new QueueNode(value);
            tail=tail.next;
        }
        length++;
    }

    public void addFirst(int value){
        if(head==null)head=tail=new QueueNode(value);
        else{
           QueueNode temp = new QueueNode(value);
           temp.next=head;
           head= temp;
        }
        length++;
    }

    public QueueNode get(int index){
        if(index<0 || head==null || index>length) System.out.println(("List is empty or index is not valid"));
        int count=0;
        QueueNode temp=head;
        while (count!=index && temp!=null){
            temp=temp.next;
            count++;
        }
        return temp;
    }

    public void set(int index,int value){
        if(index<0 || head==null || index>=length) System.out.println(("List is empty or index is not valid"));
        int count=0;
        QueueNode temp=head;
        while (count!=index && temp!=null){
            temp=temp.next;
            count++;
        }
        temp.value=value;
    }
    public void removeIndex(int index){
        if(index<0 || head==null || index>=length) System.out.println(("List is empty or index is not valid"));
        if(index==0){head=head.next;length-=1;return;}
        int count=0;
        QueueNode temp=head;
        while(count!=index-1){temp=temp.next;count++;}
        if(temp.next.next==null){temp.next=null;tail=temp;}
        else temp.next=temp.next.next;
        length-=1;
    }

    public void removeValue(int removeValue){
        if(head==null) System.out.println(("List is empty"));
        QueueNode temp =head;
        if(head.value==removeValue){head=head.next;length-=1;return;}
        while(temp.next!=null && temp.next.value!=removeValue)temp=temp.next;
        if(temp.next==null)return;
        if(temp.next.value==removeValue){
            if(temp.next.next==null)temp.next=null;
            else
            temp.next=temp.next.next;
            length-=1;
        }
    }


    public void removeFirst(){
        if(head==null) {System.out.println(("List is empty")); return;}
        head=head.next;
        length-=1;
    }

    public void removeLast(){
        if(head==null) {System.out.println(("List is empty")); return;}
        QueueNode temp =head;
        if(length==1)removeFirst();
        while(temp.next.next!=null)temp=temp.next;
        temp.next=null;
        length-=1;
        tail=temp;
        }
    public int indexOf(int search){
        QueueNode temp = head;
        int index=0;
        if(head==null) {System.out.println("List is empty");return -1;}
        else{
            while(temp.next!=null && temp.value!=search) {
                temp = temp.next;
                index++;
            }
        }
        return temp.value==search?index:-1;
    }

    public int lastIndexOf(int search){
        QueueNode temp = head;
        int count=0,index=0;
        if(head==null) {System.out.println("List is empty");return -1;}
        else{
            do {
                if(temp.value==search)index=count;
                count++;
                temp = temp.next;
            }while (temp!=null);
        }
        return index;
    }


    public void displayList(){
        QueueNode temp=head;
        while(temp!=null) {
            System.out.print(temp.value+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    public int size(){
        return length;
    }

    public static void main(String[] args) {
        QueueImplementation queue = new QueueImplementation();
        queue.add(10);
        queue.add(15);
        queue.add(13);
        queue.displayList();
        queue.removeIndex(0);
        queue.displayList();
        queue.removeIndex(1);
        queue.displayList();
        queue.add(10);
        queue.add(15);
        queue.add(13);
        queue.displayList();
        queue.removeValue(10);
        System.out.println("Removing value");
        queue.displayList();
        System.out.println(queue.size());
        queue.add(25);
        queue.set(0,0);
        queue.displayList();
        queue.set(1,12);
        queue.displayList();
        queue.set(3,3);
        queue.displayList();
        System.out.println(queue.indexOf(0));
        System.out.println(queue.indexOf(12));
        System.out.println(queue.indexOf(13));
        System.out.println(queue.indexOf(3));
        System.out.println(queue.indexOf(4));
        queue.add(12);
        queue.displayList();
        System.out.println(queue.lastIndexOf(0));
        System.out.println(queue.lastIndexOf(12));
        queue.addFirst(30);
        queue.displayList();
    }

}
