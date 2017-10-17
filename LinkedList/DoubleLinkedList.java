import java.util.Scanner;

/**
 * Created by Senapathi on 16-10-2017.
 */
public class DoubleLinkedList {

    private Node head;

    class Node {

        Node prev;
        Node next;
        int data;

        Node(int d) {
            data = d;
            prev = null;
            next = null;
        }

    }

    private void insertAtHead(int data) {

        Node new_node = new Node(data);

        if (head == null) {
            head = new_node;
            return;

        }

        head.prev = new_node;
        new_node.next = head;
        head = new_node;

    }

    private void printList() {

        Node temp = head;

        while (temp != null) {

            System.out.print(temp.data + " --> ");
            temp = temp.next;

        }


    }

    private void reverseList() {

        Node temp = head;

        if (temp == null) return; // Empty list

        // Traverse till the last node
        while (temp.next != null) {

            temp = temp.next;

        }

        while (temp != null) {

            System.out.print(temp.data + "-->");
            temp = temp.prev;

        }

        System.out.print(" \n");


    }

    public static void main(String args[]) {

        DoubleLinkedList l_list = new DoubleLinkedList();

        char ch;

        do {

            System.out.println("1. Insert At Head");
            Scanner sc = new Scanner(System.in);

            int choice = sc.nextInt();
            switch (choice) {

                case 1:
                    System.out.println("Enter value :");
                    l_list.insertAtHead(sc.nextInt());
                    l_list.printList();
                    break;

                case 2:
                    System.out.print("Reversing..");
                    l_list.reverseList();
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
