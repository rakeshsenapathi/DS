/**
 * Created by Senapathi on 23-10-2017.
 * Implementation of Binary Search Tree using Double LinkedList
 */
public class BinarySearchTree {

    private Node root = null;


    // In bst left subtree stores lesser values than node and right subtree, the higher values
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

    private Boolean searchTree(Node root, int data) {

        if (root == null) return false;
        else if (root.data == data) return true;
        else if (data <= root.data) return searchTree(root.left, data);
        else return searchTree(root.right, data);


    }

    public static void main(String args[]) {

        BinarySearchTree bst = new BinarySearchTree();
        Node root = bst.root;
        root = bst.insert(root, 20);
        root = bst.insert(root, 10);
        root = bst.insert(root, 25);
        root = bst.insert(root, 35);
        root = bst.insert(root, 32);

        Boolean flag = bst.searchTree(root, 25);

        if (flag) {
            System.out.println("Element found");
        } else System.out.println("Element not found    ");


    }


}
