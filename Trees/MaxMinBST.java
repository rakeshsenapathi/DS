/**
 * Created by Senapathi on 23-10-2017.
 */
public class MaxMinBST {

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

    // Recursively finds the max value and traces back when left is null
    private int MaxofTree(Node root) {

        if (root == null) {

            System.out.println("Tree is empty");
            return -1;
        }

        if (root.right == null) return root.data;

        else return MaxofTree(root.right);


    }


    private int MinofTree(Node root) {

        if (root == null) {

            System.out.println("Tree is empty");
            return -1;
        }

        if (root.left == null) return root.data;

        else return MinofTree(root.left);


    }

    private Boolean searchTree(Node root, int data) {

        if (root == null) return false;
        else if (root.data == data) return true;
        else if (data <= root.data) return searchTree(root.left, data);
        else return searchTree(root.right, data);


    }

    public static void main(String args[]) {

        MaxMinBST bst = new MaxMinBST();
        Node root = bst.root;
        System.out.println("Max value is : " + bst.MaxofTree(root));
        root = bst.insert(root, 20);
        root = bst.insert(root, 10);
        root = bst.insert(root, 25);
        root = bst.insert(root, 35);
        root = bst.insert(root, 32);

        System.out.println("Max value is : " + bst.MaxofTree(root));

        System.out.println("Min value is : " + bst.MinofTree(root));


    }


}
