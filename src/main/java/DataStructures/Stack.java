package DataStructures;

public class Stack<T extends Object> {
    private int stackCapacity;
    private int top;
    private T[] stack;

    public Stack(int stackCapacity) {
        this.stackCapacity = stackCapacity;
        this.stack = (T[]) new Object[stackCapacity];
        this.top = -1;
    }

    public boolean push(T data) {
        if (isFull()) {
            System.out.println("Stack is full.");
            return false;
        } else {
            stack[++top] = data;
            System.out.println("Succesfully added to stack: " + data);
            return true;
        }
    }

    public T pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty.");
        } else {
            return stack[top--];
        }
    }

    public T peek() throws Exception {
        if (isEmpty())
            throw new Exception("Stack is empty.");

        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stackCapacity - 1;
    }

    public int size() {
        return stack.length;
    }
}
