package Week1;
public class SingelyLinkedList {
    public static class Node{
        Node next;
        int data;
        Node(int data){
            this.data= data;
            this.next= null;
        }
    }
    Node head= null;
    Node tail= null;
    int size = 0;

    public void addNode(int data){
        size++;
        Node newnode = new Node(data);
        if(head == null){
            head = tail= newnode;
        }
        else{
            tail.next = newnode;
            tail = newnode;
        }

    }

    public int getSize(){
        return size;
    }

    public void printSinglyLinkedList() {
        if (!isEmpty()) {
            Node current = head;

            // System.out.print("graph.SinglyLinkedList: ");
            while (current.next != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.print(current.data);
            System.out.println();
        }
    }


    boolean isEmpty() {
        return head == null;
    }

    public int getDataAtAnyPos(int pos){
        Node current = head;
        for(int i=1; i<=pos; i++){
            current = current.next;
        }
        return current.data;
    }

}
