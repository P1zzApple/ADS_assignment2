package assignment2;

import assignment1.*;
import java.util.ArrayList;
// using java.util.ArrayList because no "set"
// method in MyArrayList file

public class MyHeap<T extends MyArrayList & Comparable<T>> {
    private ArrayList<T> heap;

    public MyHeap() {
        heap = new ArrayList<T>();
    }

    void add(T item) {
        heap.add(item);
        heapify(true,size() - 1);
    }

    private T remove(int x) {
        T item = get(x);
        swap(x, size() - 1);
        heap.remove(size() - 1);
        heapify(false, x);
        return item;
    }

    public int size() {
        return heap.size();
    }

    private void swap(int i, int j) {
        T t = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, t);
    }

    private T get(int x) {
        return heap.get(x);
    }

    private int getParentIndex(int i) {
        return i / 2;
    }

    private T getParent(int i) {
        return heap.get(getParentIndex(i));
    }

    private int getLeftIndex(int i) {
        return i * 2;
    }

    private T getLeft(int i) {
        return heap.get(getLeftIndex(i));
    }

    private int getRightIndex(int i) {
        return i * 2 + 1;
    }

    private T getRight(int i) {
        return heap.get(getRightIndex(i));
    }

    private void heapify(boolean updown, int x) {
        if (updown) {
            heapifyUp(x);
        }
        else {
            heapifyDown(x);
        }
    }

    private void heapifyUp(int i) {
        while (i > 0 && getParent(i).compareTo(get(i)) < 0) {
            swap(getParentIndex(i), i);
            i = getParentIndex(i);
        }
    }

    private void heapifyDown(int i) {

        while (i < size()) {
            T max = get(i);
            int max_i = i;

            if (getLeftIndex(i) < size() && max.compareTo(getLeft(i))<0) {
                max = getLeft(i);
                max_i = getLeftIndex(i);
            }

            if (getRightIndex(i)<size() && max.compareTo(getRight(i))<0) {
                max = getRight(i);
                max_i = getRightIndex(i);
            }

            if (max_i != i) {
                swap(i, max_i);
                i = max_i;
            }
            else {
                break;
            }
        }
    }
}
