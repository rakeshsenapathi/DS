import java.util.Stack;

/**
 * Created by Senapathi on 17-10-2017.
 * Using Linked List to implement a stack which then is used to reverse a list.
 */
public class ListStackReversal {


    private Node top;

    class Node {

        private int data;

        private Node next;

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

    private void printStack() {
        Node temp = top;
        while (temp != null) {

            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }

    private void doReversal() {

        if (top == null) return;

        Stack<Node> stack = new Stack<>();

        Node temp = top;

        while (temp != null) {

            stack.push(temp);
            temp = temp.next;
        }

        temp = stack.peek();

        top = temp;

        stack.pop();

        while (!stack.isEmpty()) {

            temp.next = stack.peek();

            stack.pop();

            temp = temp.next;


        }

        temp.next = null;


    }

    public static void main(String args[]) {

        ListStackReversal listStackReversal = new ListStackReversal();

        listStackReversal.push(5);
        listStackReversal.push(143);
        listStackReversal.push(32);
        listStackReversal.push(842);
        listStackReversal.push(12);
        listStackReversal.push(524);

        listStackReversal.printStack();

        System.out.println("");

        listStackReversal.doReversal();

        System.out.println("");

        listStackReversal.printStack();


    }


}
