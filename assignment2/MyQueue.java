package assignment2;

import assignment1.*;

public class MyQueue<T extends MyLinkedList<T> & Comparable<T>> {
    int front, rear, size;
    int capacity;
    int[] array;
    public MyQueue(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];
    }
    boolean empty(MyQueue q) {
        return q.size() == q.capacity;
    }

    int size() {
        return size;
    }

    public int peek() {
        return array[size % array.length];
    }

    public void enqueue(int newItem) {
        if (empty(this))
            return;
        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = newItem;
        this.size = this.size + 1;
        System.out.println("enqueued");

    }

    public int dequeue() {
        if (empty(this))
            return Integer.MIN_VALUE;
        int item = this.array[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size = this.size - 1;
        System.out.println("dequeued");
        return item;
    }
}
