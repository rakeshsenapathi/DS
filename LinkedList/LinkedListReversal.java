
import java.util.Scanner;

/**
 * Created by Senapathi on 15-10-2017.
 * <p>
 * The list is traversed iteratively
 */
public class LinkedListReversal {

    Node head;

    class Node {


        Node next;

        int data;

        Node(int d) {

            data = d;
            next = null;

        }

    }

    private Node ListReversal() {

        Node previous = null;

        Node current = head;

        Node next_node = null;


        while (current != null) {

            next_node = current.next;

            current.next = previous;

            previous = current;

            current = next_node;


        }

        return previous;


    }


    private void ListAppend(int new_data) {

        Node new_node = new Node(new_data);

        if (head == null) {

            head = new_node;
            new_node.next = null;
            return;

        }


        Node last = head;

        while (last.next != null) {

            last = last.next;
        }

        last.next = new_node;
        return;


    }


    private Node RecursiveReverse(Node last) {


        if (last.next == null) {

            head = last;
        }

        RecursiveReverse(last.next);

        Node q = last.next;

        q.next = last;

        last.next = null;


    }

    private void printlist() {

        Node node = head;

        while (node != null) {

            System.out.print(" ---> " + node.data);
            node = node.next;
        }


    }

    private void printlist(Node previous) {

        Node node = previous;

        while (node != null) {

            System.out.print(" ---> " + node.data);
            node = node.next;
        }


    }


    public static void main(String args[]) {

        LinkedListReversal l_list = new LinkedListReversal();


        char ch;


        do {

            System.out.println("1. Append  2.Reverse 3.Recursive Reverse");
            Scanner sc = new Scanner(System.in);

            int choice = sc.nextInt();
            switch (choice) {

                case 1:
                    System.out.println("Enter value :");
                    l_list.ListAppend(sc.nextInt());
                    l_list.printlist();
                    break;

                case 2:
                    System.out.println("Reversing List...");
                    System.out.println("After list is reversed: ");
                    l_list.printlist(l_list.ListReversal());
                    break;

                case 3:
                    l_list.RecursiveReverse(l_list.head);
                    l_list.printlist();
                    break;

                default:
                    System.out.println("Enter valid number");
                    break;


            }

            System.out.println("\n \t");
            System.out.println("Enter Y or N");
            ch = sc.next().charAt(0);


        } while (ch == 'Y' || ch == 'y');


    }
}
