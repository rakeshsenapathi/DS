/**
 * Created by Senapathi on 24-10-2017.
 * Includes Implementation for Inorder, Post, Pre order traversal recursively
 * Since the tree is BST, inorder traversal sorts the tree.
 * Inorder : <left><root><right> PreOrder : <root><left><right> Post Order: <left><right><root>
 */
public class PrePostInTraversal {


    // If root node is root then
    private Node root = null;


    private class Node {
        private int data;
        private Node left;
        private Node right;

    }

    //  preOrderTraversal iteratively
    private void preOrderTraversal(Node root) {

        if (root == null) return;

        System.out.println(root.data);

        preOrderTraversal(root.left);

        preOrderTraversal(root.right);


    }

    //Inorder Traversal
    private void inOrderTraversal(Node root) {

        if (root == null) return;

        inOrderTraversal(root.left);

        System.out.println(root.data);

        inOrderTraversal(root.right);


    }

    //Post Order Traversal
    private void postOrderTraversal(Node root) {

        if (root == null) return;

        postOrderTraversal(root.left);

        postOrderTraversal(root.right);

        System.out.println(root.data);


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

        PrePostInTraversal obj = new PrePostInTraversal();

        Node root = obj.root;
        root = obj.insert(root, 20);
        root = obj.insert(root, 10);
        root = obj.insert(root, 25);
        root = obj.insert(root, 35);
        root = obj.insert(root, 32);

//        obj.preOrderTraversal(root);
//        obj.inOrderTraversal(root);
        obj.postOrderTraversal(root);
    }


}
