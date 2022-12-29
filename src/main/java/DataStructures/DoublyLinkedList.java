package DataStructures;

public class DoublyLinkedList<T> {
    public Node head;
    Node tail;
    int size;

    public DoublyLinkedList() {
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public class Node {
        public Node prevNode;
        public Node nextNode;
        T data;

        Node(T data) {
            this.data = data;
        }
    }

    public boolean insertFront(T data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.nextNode = head;
            newNode.prevNode = null;
            head.prevNode = newNode;
            head = newNode;
        }

        size++;
        return true;

    }

    public boolean insertEnd(T data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            size++;
            System.out.println("Root node created: " + data);
        } else {
            Node iterator = tail;

            while (iterator.nextNode != null) {
                iterator = iterator.nextNode;
            }

            iterator.nextNode = newNode;
            newNode.prevNode = iterator;
            tail = newNode;
            size++;
            System.out.println("New node added to end of the list: " + data);
        }

        return true;

    }

    public boolean insertAfter(Node prevNode, T data) {

        if (prevNode == null) {
            System.out.println("You cannot add after a null node");
            return false;
        }

        Node newNode = new Node(data);

        newNode.nextNode = prevNode.nextNode;

        prevNode.nextNode = newNode;

        newNode.prevNode = prevNode;

        size++;

        if (newNode.nextNode != null)
            newNode.nextNode.prevNode = newNode;
        else
            tail = newNode;

        return true;

    }

    public void traverseForward() {
        Node iterator = head;

        System.out.println("---Traversing forward---");

        while (iterator != null) {
            System.out.println(iterator.data);
            iterator = iterator.nextNode;
        }
    }

    public void traverseBackward() {
        Node iterator = tail;

        System.out.println("---Traversing backward---");

        while (iterator != null) {
            System.out.println(iterator.data);
            iterator = iterator.prevNode;
        }
    }

    public boolean deleteByData(T data) {

        if (head == null) {
            System.out.println("List is empty.");
            return false;
        } else {

            if (data == head.data) {
                if (head == tail) {
                    head = tail = head.nextNode;
                    size--;
                    System.out.println("Head node deleted: " + tail.data);
                    return true;

                } else {
                    head.nextNode.prevNode = null;
                    head = head.nextNode;
                    size--;
                    return true;
                }

            } else if (data == tail.data) {
                tail.prevNode.nextNode = null;
                tail = tail.prevNode;
                size--;
                System.out.println("Tail node deleted: " + data);
                return true;
            } else {
                Node currNode = tail;
                Node prevNode = null;

                while (currNode != null) {
                    if (data == currNode.data) {
                        prevNode.nextNode = currNode.nextNode;
                        currNode.nextNode.prevNode = prevNode;
                        System.out.println("Node deleted: " + data);
                        size--;
                        return true;
                    }
                    prevNode = currNode;
                    currNode = currNode.nextNode;
                }

                System.out.println("Data not found in a node");
                return false;
            }
        }

    }

    public boolean deleteByIndex(int index) {

        if (index < 0 || index > size) {
            System.out.println("Index out of range.");
            return false;
        }

        if (head == null) {
            System.out.println("The list is empty");
            return false;
        } else {
            Node iterator = head;

            if (index == 0) {
                head = iterator.nextNode;
                iterator.nextNode.prevNode = null;
                System.out.println("Root node deleted.");
                size--;
                return true;
            }

            if (index == size - 1) {
                tail.prevNode.nextNode = null;
                tail = tail.prevNode;
                System.out.println("Tail node deleted.");
                size--;
                return true;
            }

            for (int i = 0; iterator != null; i++) {
                if (i == index) {
                    iterator.prevNode.nextNode = iterator.nextNode;
                    iterator.nextNode.prevNode = iterator.prevNode;
                    System.out.println("Deleted node at position:  " + index);
                    size--;
                    return false;
                } else {
                    iterator = iterator.nextNode;
                }
            }

            return false;
        }


    }

    /*private void deleteNode(Node nodeToDelete) {

        if (nodeToDelete == null) {
            System.out.println("Cannot delete a null node.");
            return;
        }

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head == nodeToDelete)
            head = nodeToDelete.nextNode;

        if (nodeToDelete.nextNode != null)
            nodeToDelete.nextNode.prevNode = nodeToDelete.prevNode;

        if (nodeToDelete.prevNode != null)
            nodeToDelete.prevNode.nextNode = nodeToDelete.nextNode;

        nodeToDelete = null;

        System.out.println("Node is deleted");

    }*/

}
