import static java.lang.StrictMath.max;

/**
 * Created by Senapathi on 23-10-2017.
 */
public class HeightofBST {
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

    // Height = max of left_subtree_height,right_subtree_height + 1
    private int findTreeHeight(Node root) {

        if (root == null) return -1; //Termination condition for recursion

        int left_height = findTreeHeight(root.left);

        int right_height = findTreeHeight(root.right);

        return max(left_height, right_height) + 1;
    }

    public static void main(String args[]) {

        HeightofBST bst = new HeightofBST();
        Node root = bst.root;
        root = bst.insert(root, 20);
        root = bst.insert(root, 10);
        root = bst.insert(root, 25);
        root = bst.insert(root, 35);
        root = bst.insert(root, 32);
        System.out.println(bst.findTreeHeight(root));


    }
}
