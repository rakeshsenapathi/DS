
import java.util.LinkedList;

/**
 * Created by Senapathi on 24-10-2017.
 * Depth first traversal of a binary tree, Elements are traversed level wise.
 */
public class DepthFirstTraversal {
    private Node root = null;


    private class Node {
        private int data;
        private Node left;
        private Node right;

    }

    private void Traversal(Node root) {

        if (root == null) {
            return;
        }

        LinkedList<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            Node treenode = queue.poll(); // pops the head element in the queue

            System.out.println(treenode.data);

            if (treenode.left != null) queue.add(treenode.left);

            if (treenode.right != null) queue.add(treenode.right);


        }


    }


    private Node getNewNode(int data) {
        // Creating an new Node

        Node new_node = new Node();
        new_node.data = data;
        new_node.left = null;
        new_node.right = null;
        return new_node;


    }

    // Recursive implementation of insertOperation
    private Node insert(Node root, int data) {

        if (root == null) {

            root = getNewNode(data);

        } else if (data <= root.data) {

            root.left = insert(root.left, data);


        } else {

            root.right = insert(root.right, data);
        }


        return root;

    }

    public static void main(String args[]) {

        DepthFirstTraversal dft = new DepthFirstTraversal();
        Node root = dft.root;
        root = dft.insert(root, 20);
        root = dft.insert(root, 10);
        root = dft.insert(root, 25);
        root = dft.insert(root, 35);
        root = dft.insert(root, 32);

        dft.Traversal(root);

    }


}
