import java.util.LinkedList;

/**
 * Created by Senapathi on 23-10-2017.
 * Binary Search Tree code reused, tree will be just binary tree after invertion or mirroring.
 */
public class InvertBST {
    private Node root = null;


    private class Node {
        private int data;
        private Node left;
        private Node right;

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

    //Recursive Solution
    private Node invertTreeRec(Node root) {

        if (root == null) return null;

        Node left = invertTreeRec(root.left);

        Node right = invertTreeRec(root.right);

        root.left = right;
        root.right = left;

        return root;

    }

    // Iterative Solution
    private Node invertTreeIter(Node root) {

        LinkedList<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            Node q = queue.poll();

            if (q.left != null) queue.add(q.left);

            if (q.right != null) queue.add(q.right);

            Node temp = q.left;

            q.left = q.right;

            q.right = temp;

        }

        return root;


    }

    public void printsubtree(Node root) {

        System.out.println("Left Subtree : " + root.left.data);
        System.out.println("Right Subtree : " + root.right.data);


    }


    public static void main(String args[]) {

        InvertBST bst = new InvertBST();
        Node root = bst.root;
        root = bst.insert(root, 20);
        root = bst.insert(root, 10);
        root = bst.insert(root, 25);
        root = bst.insert(root, 35);
        root = bst.insert(root, 32);
        System.out.println("Before Invertion");
        bst.printsubtree(root);


        root = bst.invertTreeRec(root);
        System.out.println("After Invertion Recursively");
        bst.printsubtree(root);

        root = bst.invertTreeIter(root);
        System.out.println("After Invertion Iteratively");
        bst.printsubtree(root);


    }


}





