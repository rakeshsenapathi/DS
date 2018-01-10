/**
 * Created by Senapathi on 08-01-2018.
 * Reversing a doubly linkedlist:
 * Interchanging prev and next values and then iterating through head.prev
 * until reaching the end of the list results in the reversal of the list.
 */
public class DoubleLinkedReversal {

    public Node head;

    class Node {

        private int data;

        private Node prev;

        private Node next;


        Node(int data) {


            this.data = data;

            this.prev = null;

            this.next = null;


        }


    }


    private Node insertNode(int data) {

        Node new_node = new Node(data);
        if (head == null) {


            head = new_node;


            return head;
        }

        // Reversing prev and next
        new_node.next = head;

        head.prev = new_node;

        head = new_node;

        return head;

        //

    }

    private void displayNodes(Node head) {

        Node temp = head;

        while (temp != null) {

            System.out.println(temp.data);

            temp = temp.next;


        }


    }

    private Node ListReversal(Node head) {

        if (head == null) {

            return head;

        }

        Node temp = head.next;

        head.next = head.prev;

        head.prev = temp;


        if (head.prev == null) return head;

        return ListReversal(head.prev);


    }


    public static void main(String args[]) {


        DoubleLinkedReversal dll = new DoubleLinkedReversal();


        Node head = dll.head;
        head = dll.insertNode(5);

        head = dll.insertNode(21);

        head = dll.insertNode(12);

        head = dll.insertNode(31);

        dll.displayNodes(head);

        head = dll.ListReversal(dll.head);

        System.out.println("After reversal :\n ");

        dll.displayNodes(head);


    }


}
