/**
 * Created by Senapathi on 06-11-2017.
 * AVL Tree is a self balancing tree , Here difference between the left,subtrees should not greater than 1.
 * Rotations are to be done to keep the tree balanced when a new node is inserted.
 * 4 possible cases :
 * Left - Left , Right - Right, Left- Right, Right - Left
 * Since we are inserting bst way, Time Complexity is O(logn) to insert
 * Takes constant time to insert O(1).
 * In this program Height(left) - Height(right) is used, so +ve value represents Leftside is heavy and viceversa.
 */
public class AVLTreeDeletion {

    private Node root = null;

    private class Node {

        private int data;

        private int height;

        private Node left;

        private Node right;


    }

    private Node getNewNode(int data) {
        // Creating an new Node

        Node new_node = new Node();
        new_node.data = data;
        new_node.height = 1;
        return new_node;


    }


    private Node doInsert(Node root, int data) {

        if (root == null) {

            return getNewNode(data);

        } else if (data < root.data) {
            root.left = doInsert(root.left, data);
        } else if (data > root.data) {
            root.right = doInsert(root.right, data);
        } else {
            return root;
        }

        updateHeight(root);

        int balance = getBalance(root);

        // This means that node is left heavy, So problem is reduced L-L or L-R case.
        if (balance > 1) {

            if (data < root.left.data) {

                root = rotateRight(root);
            }
            // Left - Right condition, so we have to rotate right first.
            else {
                // We first left rotate to make it compatible to right rotate.
                root.left = rotateLeft(root.left);
                root = rotateRight(root);
            }


        }
        // Tree is right heavy
        else if (balance < -1) {


            if (data > root.right.data) {

                root = rotateLeft(root);

            }
            // R-l case
            else {
                root.right = rotateRight(root.right);
                root = rotateLeft(root);
            }

        }

        return root;


    }

    private Node rotateLeft(Node root) {

        if (root == null) return root;

        Node new_node = root.right;

        Node temp = new_node.left;

        new_node.left = root;

        root.right = temp;

        updateHeight(root);

        updateHeight(new_node);

        return new_node;
    }

    private Node rotateRight(Node root) {

        if (root == null) return root;

        Node new_node = root.left;

        Node temp = new_node.right;

        new_node.right = root;

        root.left = temp;
        updateHeight(root);

        updateHeight(new_node);


        return new_node;


    }


    private int getBalance(Node root) {

        if (root == null) return 0;
        return (getHeight(root.left)) - (getHeight(root.right));


    }

    private void updateHeight(Node root) {

        if (root == null) {
            return;
        }

        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;


    }

    private int getHeight(Node node) {

        if (node == null) return 0;

        else return node.height;

    }

    private void inOrderTraversal(Node root) {
        // Inorder traversal of BST gives sorted elements.


        if (root == null) return;

        inOrderTraversal(root.left);

        System.out.print(root.data + " -- ");

        inOrderTraversal(root.right);


    }


    private Node deleteAVLNode(Node root, int data) {

        if (root == null) return root;

        else if (data < root.data) {
            root.left = deleteAVLNode(root.left, data);
        } else if (data > root.data) {
            root.right = deleteAVLNode(root.right, data);
        }

        // Found the element
        else {

            /* There are 3 possible cases when deleting a node in BST
            * Case 1 : The node to deleted has no child nodes.
            * Case 2 : Has a single child
            * Case 3 : Has both child nodes
            * */

            // Case 1
            if (root.left == null && root.right == null) {

                return null;

            }

            // Case 2
            else if (root.left == null) {

                root = root.right;

            } else if (root.right == null) {

                root = root.left;

            }

            // Case 3
            else {

                Node temp = minValueNode(root.right);

                root.data = temp.data;

                root.right = deleteAVLNode(root.right, temp.data);

            }
        }

        //If there is only one node before deletion, Tree is empty
        if (root == null) return root;

        //Update the height
        updateHeight(root);

        int balance = getBalance(root);

        // This means that node is left heavy, So problem is reduced L-L or L-R case.
        if (balance > 1) {

            if (data < root.left.data) {

                root = rotateRight(root);
            }
            // Left - Right condition, so we have to rotate right first.
            else {
                // We first left rotate to make it compatible to right rotate.
                root.left = rotateLeft(root.left);
                root = rotateRight(root);
            }


        }
        // Tree is right heavy
        else if (balance < -1) {


            if (data > root.right.data) {

                root = rotateLeft(root);

            }
            // R-l case
            else {
                root.right = rotateRight(root.right);
                root = rotateLeft(root);
            }

        }

        return root;
    }

    private Node minValueNode(Node root) {

        Node current = root;

        while (current.left != null) current = current.left;
        return current;
    }

    public static void main(String args[]) {

        AVLTreeDeletion avlTree = new AVLTreeDeletion();

        Node root = avlTree.root;

        root = avlTree.doInsert(root, 10);
        root = avlTree.doInsert(root, 20);
        root = avlTree.doInsert(root, 30);
        root = avlTree.doInsert(root, 4);
        root = avlTree.doInsert(root, 6);
        root = avlTree.doInsert(root, 5);

        avlTree.inOrderTraversal(root);
        System.out.println("");

        root = avlTree.deleteAVLNode(root, 30);

        avlTree.inOrderTraversal(root);


    }


}


