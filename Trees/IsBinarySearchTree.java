/**
 * Created by Senapathi on 24-10-2017.
 * Checks if a binary tree is binary search tree or not.
 */
public class IsBinarySearchTree {

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

    private boolean isBSTUtil(Node root, int min_value, int max_value) {

        if (root == null) return true;

        else if (root.data > min_value && root.data < max_value
                && isBSTUtil(root.left, min_value, root.data)
                && isBSTUtil(root.right, root.data, max_value)) {
            return true;
        }

        return false;

    }

    private boolean isBST(Node root) {


        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);


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

        IsBinarySearchTree bst = new IsBinarySearchTree();

        Node root = bst.root;
        root = bst.insert(root, 20);
        root = bst.insert(root, 10);
        root = bst.insert(root, 25);
        root = bst.insert(root, 35);
        root = bst.insert(root, 32);

        System.out.println(bst.isBST(root));

    }

}
