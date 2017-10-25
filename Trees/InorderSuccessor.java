/**
 * Created by Senapathi on 25-10-2017.
 * Finding the successor of an element effeciently.
 * Two cases arise during recursion Inorderly in BST
 * Case 1:
 * The element we want to find successor for(current) may have a right subtree i.e another recursion call to find left most node
 * In this scenario we have to Traversal the left part of right subtree to find the min_val which means end of the recursion
 * <p>
 * Case 2:
 * The element( current ) doesn't have a right subtree
 * In this case we should introduce ancestor to get the successor.
 * If there is no right subtree, the ancestor node i.e node which invoked the parent node is the successor.
 */
public class InorderSuccessor {

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


    // Recursive implementation of insertOperation in BST
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

    private Node getSuccessor(Node root, int data) {


        Node current = Find(root, data);

        if (current == null) return null;

        // case 1: Element has right child,so we have call left until we reach null i.e min
        if (current.right != null) {

            return FindMin(current.right);
        }

        // Case 2: Element has no right child then the oldest ancestor becomes the successor.
        else {

            Node successor = null; // Initially successor is null, so the last element doesn't satisfy if clause so it doesn't have a succesor

            Node ancestor = root; // We start from the root and walk down to the current

            // We iterate until we reach the current
            while (current != ancestor) {


                if (current.data < ancestor.data) {

                    successor = ancestor;

                    ancestor = ancestor.left; // The ancestor which last accessed this statement is the successor


                } else ancestor = ancestor.right;
            }


            return successor;

        }


    }

    private Node FindMin(Node current) {

        if (current == null) return null;

        while (current.left != null) {

            current = current.left;

        }

        return current;
    }

    private Node Find(Node root, int data) {

        if (root == null) return null;

        else if (data < root.data) return Find(root.left, data);

        else if (data == root.data) return root;

        else return Find(root.right, data);


    }


    public static void main(String args[]) {

        InorderSuccessor obj = new InorderSuccessor();


        Node root = obj.root;
        root = obj.insert(root, 12);
        root = obj.insert(root, 5);
        root = obj.insert(root, 14);
        root = obj.insert(root, 3);
        root = obj.insert(root, 7);
        root = obj.insert(root, 13);
        root = obj.insert(root, 17);
        root = obj.insert(root, 9);
        root = obj.insert(root, 20);
        root = obj.insert(root, 8);
        root = obj.insert(root, 11);
        root = obj.insert(root, 18);

        /*
        *
        *
        *
        *
        *
        *
        * */

        Node sucessor = obj.getSuccessor(root, 7);
        if (sucessor == null) System.out.println("Successor Not found");

        else System.out.println("Successor : " + sucessor.data);

    }


}
