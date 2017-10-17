import java.util.Scanner;

/**
 * Created by Senapathi on 14-10-2017.
 *
 * Implementation of LinkedList, it contains Append, insert, insertAfter position, delete elements operations.
 */


class SingleList {

    private Node head;

    class Node {

        private int data;

        Node next;

        Node(int d) { //contructor which assigns values to the node.

            data = d;

            next = null;

        }
    }

    private void append(int data) {

        // Appends newly created node

        Node new_node = new Node(data);

        if (head == null) {

            // If list is empty, make it has a head.

            head = new_node;
            new_node.next = null;
            return;

        }


        Node last = head;

        // Traverse the linkedlist until the last node
        while (last.next != null) {

            last = last.next;
        }

        // link last node to penultimate node.
        last.next = new_node;
        return;

    }

    private void push(int data) {

        /**
         * Adds the element before the head element
         * */
        Node new_node = new Node(data);

        if (head == null) {
            // If list is empty make new node is head.
            head = new_node;
            new_node.next = null;
            return;

        }

        // Now make new node as head.
        new_node.next = head;
        head = new_node;
        return;


    }

    private void insertAfter(int position, int new_data) {

        /**
        Insert after a given position
         */

        Node last = head;

        //If list is empty, node is not created.
        if (head == null) {
            System.out.print("Invalid attempt");
            return;
        }

        // Traverse through the list until we reach the position
        for (int i = 0; last.next != null && i < position - 1; i++) {
            last = last.next;
        }

        Node new_node = new Node(new_data);

        // Now change the nodes "next" field, which come before and after the new node
        new_node.next = last.next;
        last.next = new_node;
        return;


    }

    private void delete(int new_data) {

        /**
        *
        * Delete the node, given the data to be removed
        */

        Node temp = head, last = null;


        if (head == null) return; //If list is empty, return

        // If the node to be deleted is first one iteself
        if (temp != null && temp.data == new_data) {
            head = temp.next; // Changed head
            return;
        }

        while (temp != null && temp.data != new_data) {
            last = temp;

            temp = temp.next;

        }

        if (temp == null) return;

        last.next = temp.next;


    }


    private void printlist() {

        Node node = head;

        while (node != null) {

            System.out.print(" ---> " + node.data);
            node = node.next;
        }


    }

    public static void main(String args[]) {

        SingleList s_list = new SingleList();

        char ch;

        do {
            System.out.println("1. Push 2. Append 3. Delete 4. InsertAfter");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {

                case 1:
                    System.out.println("Enter value: ");
                    s_list.push(sc.nextInt());
                    s_list.printlist();
                    break;

                case 2:
                    System.out.println("Enter value: ");
                    s_list.append(sc.nextInt());
                    s_list.printlist();
                    break;
                case 3:
                    System.out.println("Enter value: ");
                    s_list.delete(sc.nextInt());
                    s_list.printlist();
                    break;
                case 4:
                    System.out.println("Enter position,data");
                    s_list.insertAfter(sc.nextInt(), sc.nextInt());
                    s_list.printlist();
                    break;


                default:
                    System.out.println("Enter valid choice");
                    break;
            }


            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = sc.next().charAt(0);


        } while (ch == 'Y' || ch == 'y');


    }


}