import java.util.LinkedList;

/**
 * Created by Senapathi on 17-10-2017.
 * Implementation of stack using single linked list.
 * We know that push and pop operations are possible from only one end. Applying this to link to linked list,
 * There are 2 possible options 1.Add at beginning 2. Add at end
 * Add at beginning is choosen because we can do the push() pop() in O(1) time
 */
public class LinkedListStack {

    private Node top;

    class Node {

        Node next;
        int data;

        Node(int d) {
            data = d;
            next = null;
        }


    }


    private void push(int data) {

        Node new_node = new Node(data);

        new_node.next = top;

        top = new_node;


    }

    private void pop() {

        if (top == null) return;

        top = top.next;

    }

    private void printStack() {

        Node temp = top;
        while (temp != null) {

            System.out.print(temp.data + " ");
            temp = temp.next;
        }


    }

    public static void main(String args[]) {

        LinkedListStack stack_list = new LinkedListStack();

        stack_list.push(5);
        stack_list.push(25);
        stack_list.push(98);
        stack_list.push(33);
        stack_list.push(5);

        stack_list.printStack();

        System.out.println("\n \t");
        stack_list.pop();
        stack_list.pop();
        stack_list.printStack();    


    }


}
