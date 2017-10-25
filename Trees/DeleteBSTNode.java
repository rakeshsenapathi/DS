
/**
 * Created by Senapathi on 25-10-2017.
 * Deleting a BST Node maintaining BST after deletion as well.
 * 3 possible cases arise when removing a node
 * Case 1 : Node to be deleted is a leaf node.
 * It can simply solved by returning null when you find the node.
 * <p>
 * Case 2 : Node has a single child(left / right)
 * By returning root.left / root.right.
 * <p>
 * Case 3 : Node has 2 children
 * Find the min element in the right subtree of node and copy it's data or
 * Find the max element in the left subtree of node
 */
public class DeleteBSTNode {

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

    private Node deleteNode(Node root, int data) {

        if (root == null) return root;

        else if (data < root.data) root.left = deleteNode(root.left, data);

        else if (data > root.data) root.right = deleteNode(root.right, data);

        else if (root.data == data) {

            //Case 1: Has no children
            if (root.left == null && root.right == null) {

                return null;

            }

            //Case 2: Has one children (left/right)

            else if (root.left == null) {
                // Has child to the right

                root = root.right;

            } else if (root.right == null) {
                // Has child to the left

                root = root.left;

            }
            // Case 3 : Has 2 children
            else {

                Node min_node = root.right;

                root.data = min_node.data;

                root.right = deleteNode(min_node, min_node.data);

            }


        }

        return root;

    }


    public static void main(String args[]) {

        DeleteBSTNode bst = new DeleteBSTNode();

        Node root = bst.root;
        root = bst.insert(root, 12);
        root = bst.insert(root, 5);
        root = bst.insert(root, 14);
        root = bst.insert(root, 3);
        root = bst.insert(root, 7);
        root = bst.insert(root, 13);
        root = bst.insert(root, 17);
        root = bst.insert(root, 9);
        root = bst.insert(root, 20);
        root = bst.insert(root, 8);
        root = bst.insert(root, 11);
        root = bst.insert(root, 18);

        root = bst.deleteNode(root, 14);


    }


}
