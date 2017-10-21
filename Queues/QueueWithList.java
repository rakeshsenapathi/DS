/**
 * Created by Senapathi on 21-10-2017.
 * Linkedlist based implementation of Queue ADT.
 */
public class QueueWithList {


    private Node front;
    private Node rear;

    private QueueWithList() {

        front = null;
        rear = null;

    }


    class Node {

        private int data;

        private Node next;

    }

    private void enQueue(int data) {

        Node new_node = new Node();
        new_node.data = data;
        new_node.next = null;

        if (front == null) {

            front = new_node;
            rear = new_node;
            return;

        }

        rear.next = new_node;
        rear = new_node;

    }

    private void deQueue() {

        if (front == null) return;

        else if (front == rear) {

            front = null;
            rear = null;
        }

        front = front.next;

    }

    private void printQueue() {

        Node temp = front;

        while (temp != null) {

            System.out.print(temp.data + " ");
            temp = temp.next;

        }


    }

    public static void main(String args[]) {

        QueueWithList obj = new QueueWithList();
        obj.enQueue(35);
        obj.enQueue(21);
        obj.enQueue(53);
        obj.enQueue(23);
        obj.enQueue(72);
        obj.enQueue(101);
        obj.deQueue();
        obj.deQueue();
        obj.printQueue();


    }


}


