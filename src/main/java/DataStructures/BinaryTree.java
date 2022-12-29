package DataStructures;

public class BinaryTree {

    Node root;

    private class Node {
        Node left;
        Node right;
        int value;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }


    public void add(int data) {
        root = addRecursive(root, data);
    }

    private Node addRecursive(Node current, int data) {
        if (current == null) {
            current = new Node(data);
            System.out.println("Successfully added: " + data);
            return current;
        }

        if (data < current.value)
            current.left = addRecursive(current.left, data);

        if (data > current.value)
            current.right = addRecursive(current.right, data);


        return current;
    }


    private boolean containsRecursive(Node current, int data) {

        if (current == null)
            return false;

        if (current.value == data)
            return true;

        return current.value < data ? containsRecursive(current.left, data) : containsRecursive(current.right, data);
    }

    public boolean contains(int data) {
        return containsRecursive(root, data);
    }

    private Node deleteRecursive(Node current, int data) {

        if (current == null)
            return null;

        if (current.value == data)
            return deleteNode(current);

        if (data < current.value)
            current.left = deleteRecursive(current.left, data);
        else
            current.right = deleteRecursive(current.right, data);

        return current;
    }

    private Node deleteNode(Node current) {

        if (current.left == null && current.right == null)
            return null;

        if (current.left == null)
            return current.right;

        if (current.right == null)
            return current.left;

        return deleteDeepestNode(current);

    }

    private Node deleteDeepestNode(Node current) {
        int smallestValue = smallestValue(root);
        current.value = smallestValue;
        current.right = deleteRecursive(current.right, smallestValue);
        return current;
    }

    private int smallestValue(Node current) {
        return current.left == null ? current.value : smallestValue(current.left);
    }

    public void delete(int data) {
        root = deleteRecursive(root, data);
    }


    public void traverseLDR(Node current) {

        if (current != null) {
            traverseLDR(current.left);
            System.out.println(current.value);
            traverseLDR(current.right);
        }


    }

    public void traverseLRD(Node current) {
        if (current == null)
            return;

        traverseLRD(current.left);
        traverseLRD(current.right);
        System.out.println(current.value);

    }

    public void traverseDLR(Node current) {
        if (current == null)
            return;

        System.out.println(current.value);
        traverseDLR(current.left);
        traverseDLR(current.right);
    }


}
