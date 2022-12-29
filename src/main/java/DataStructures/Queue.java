package DataStructures;

public class Queue<T extends Object> {
    int queueCapacity;
    T queue[];
    int front, rear, currentSize;

    public Queue(int queueCapacity) {
        this.queueCapacity = queueCapacity;
        this.queue = (T[]) new Object[queueCapacity];
        front = rear = currentSize = 0;
    }

    public boolean enqeue(T data) {

        if (this.isFull()) {
            System.out.println("Queue is full");
            return false;
        }

        rear = (rear + 1) % queueCapacity;

        queue[rear] = data;

        currentSize++;

        return true;

    }

    public T dequeue() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("Queue is empty");
        }

        front = (front + 1) % queueCapacity;

        currentSize--;

        return queue[front];

    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == queueCapacity;
    }

}
