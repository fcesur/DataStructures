package DataStructures;

public class LinkedList<T> {

    Node head;
    int size;

    public LinkedList() {
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    class Node {
        Node next;
        T data;

        Node(T data) {
            this.data = data;
        }
    }

    public boolean insert(T data) {

        Node newData = new Node(data);

        if (head == null) {
            head = newData;
            size++;
            System.out.println("First node added : " + data);
            return true;
        } else {

            Node iterator = head;

            while (iterator.next != null) {
                iterator = iterator.next;
            }

            iterator.next = newData;
            System.out.println("New node added : " + data);

            return true;
        }
    }

    public boolean deleteByData(T data) {

        if (data == null) {
            System.out.println("Null data cannot be added.");
            return false;
        }

        if (head != null) {

            Node currNode = head;
            Node prevNode = null;

            if (currNode.data == data) {
                head = currNode.next;
                System.out.println("Successfully deleted root data: " + data);
                size--;
                return true;

            } else {
                while (currNode.next != null) {
                    prevNode = currNode;
                    currNode = currNode.next;

                    if (currNode.data == data) {
                        prevNode.next = currNode.next;

                        System.out.println("Successfully deleted data: " + data);
                        size--;
                        return true;
                    }
                }

                System.out.println("Data not exists");
                return false;

            }
        } else {
            System.out.println("Linked list is empty");
            return false;
        }

    }

    public boolean deleteByIndex(int index) {

        if (index < 0 || index > size) {
            System.out.println("Index out of range.");
            return false;
        }

        if (head == null) {
            System.out.println("Empty list");
            return false;
        } else {
            Node currNode = head;
            Node prevNode = null;
            if (currNode != null && index == 0) {
                head = currNode.next;
                System.out.println("Deleted root node at position : " + index);
                size--;
                return true;
            }


            for (int i = 0; currNode != null; i++) {
                if (i == index) {
                    prevNode.next = currNode.next;
                    System.out.println("Deleted node at position:  " + index);
                    size--;
                    return true;
                } else {
                    prevNode = currNode;
                    currNode = currNode.next;
                }
            }

            System.out.println("Index not found");
            return false;

        }
    }

    public void traverse() {

        if (head == null) {
            System.out.println("Empty list.");
            return;
        }

        Node iterator = head;

        while (iterator != null) {
            System.out.println(iterator.data);
            iterator = iterator.next;
        }
    }

}
