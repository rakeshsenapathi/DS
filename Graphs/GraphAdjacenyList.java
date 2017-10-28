import java.util.LinkedList;

/**
 * Created by Senapathi on 28-10-2017.
 * Implementing Graph data structure using Adjacency List approach.
 * An array stores all the head nodes of the linkedlists.
 * Using linkedlists reduces time complexity compared to adjacency matrix, where a matrix of size (|V| * |V|) is taken.
 * Since dynamical allocation of memory is done. Space complexity depends on Edges i.e O(|E|).
 * Further optimisation would be using Binary Search tree, whose operations take O(logn) time.
 */
public class GraphAdjacenyList {


    private int NO_OF_VERTICES;

    // This array stores all the head nodes of linkedlists.
    private Node[] pointerArray;

    //Initiate size of the pointerArray
    private GraphAdjacenyList(int V) {

        NO_OF_VERTICES = V;

        pointerArray = new Node[NO_OF_VERTICES]; //Instantiating an array of size given.

    }


    class Node {

        private int data;

        private Node next;

        private Node(int data) {

            this.data = data;

            this.next = null;

        }

    }


    private void addEdge(int source, int destination) {


        //Updating the source's Linkedlist
        Node src_node = new Node(destination);

        // In 1st case if array is empty then new_node is pointed to null. pointer[] always acts as a head node.
        src_node.next = pointerArray[source];

        pointerArray[source] = src_node;

        //Updating the destination's linkedlist.
        Node dst_node = new Node(source);

        dst_node.next = pointerArray[destination];

        pointerArray[destination] = dst_node;

    }

    private void printList() {

        for (int i = 0; i < NO_OF_VERTICES; i++) {

            Node head = pointerArray[i];

            System.out.println("At Vertex: " + i);

            while (head != null) {

                System.out.print(head.data + " --- ");

                head = head.next;

            }

            System.out.print("null");

            System.out.println("");

        }

    }

    public static void main(String args[]) {

        GraphAdjacenyList obj = new GraphAdjacenyList(5);

        obj.addEdge(0, 1);
        obj.addEdge(0, 4);
        obj.addEdge(1, 2);
        obj.addEdge(1, 3);
        obj.addEdge(1, 4);
        obj.addEdge(2, 3);
        obj.addEdge(3, 4);

        obj.printList();


    }

}
