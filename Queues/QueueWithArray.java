/**
 * Created by Senapathi on 21-10-2017.
 * Array implementation for Queue ADT.
 * We deque from the front and add from the rear. And array is modified to make it circular.
 */
public class QueueWithArray {

    private int size;
    private int queue[];

    private int front = -1, rear = -1;

    private QueueWithArray(int N) {

        size = N;
        queue = new int[size];


    }


    private void enQueue(int data) {

        if ((rear + 1) % size == front) return; // If list is full i.e next element is front.

        else if (isEmpty()) {

            front = rear = 0; //If the queue is empty, if we add the value front=rear

        } else {

            rear = (rear + 1) % size; //Modulus returns 0 when real+1 = size, thereby making circular array
        }

        queue[rear] = data; //Add the element


    }

    private void deQueue() {

        if (isEmpty()) return;

        else if (front == rear) {

            front = rear = -1; //After removing from queue, it will become empty.
        } else front = (front + 1) % size; // else iterate circularly


    }

    private void printQueue() {


        /* To find the count of no of elements */
        int count = (rear + size - front) % size + 1;
        for (int i = 0; i < count; i++) {

            System.out.print(queue[(front + i) % size] + "   "); //To iterate circularly
        }


    }


    private boolean isEmpty() {

        return front == -1 && rear == -1;
    }

    public static void main(String args[]) {

        QueueWithArray obj = new QueueWithArray(10);
        obj.enQueue(10);
        obj.enQueue(34);
        obj.enQueue(22);
        obj.enQueue(84);
        obj.enQueue(64);
        obj.deQueue();
        obj.deQueue();
        obj.printQueue();


    }
}
