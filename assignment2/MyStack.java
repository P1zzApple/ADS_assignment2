package assignment2;

import assignment1.*;

public class MyStack<T extends MyArrayList<T> & Comparable<T>> {
    MyArrayList<T> mal;
    private int length;
    int top = 1;

    MyStack(int length) {
        this.length = length;
        Object MyArrayList = null;
        this.mal = new MyArrayList<T>(length);
    }

    boolean empty() {
        return length == 0;
    }

    int size() {
        return length;
    }

    public T peek() {
        if (top == -1) {
            System.out.println("Stack underflow");
            return null;
        }
        else {
            return mal.get(top);
        }
    }

     void push(T newItem) {
        int top1 = top + 1;
        if (top1 == length) {
            System.out.println("Stack Overflow");
        }
        else {
            top = top + 1;
            mal.add(newItem);
        }
    }

    public void pop() {
      if (top == 1) {
          System.out.println("\nStack Underflow");
      }
      else {
          top--;
      }
    }
}
