// MyLinkedList.java
// by Aydar Amangeldy CS-2129N
package assignment1;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {

    private static class MyNode<T>{
        T data;
        MyNode<T> next, prev;
        MyNode(T data) {
            this.data = data;
        }
    }

    private int length = 0;
    private MyNode<T> head, tail;
    // index out of bounds message
    public String oob_msg = "Index should be positive and less than size";

    public MyLinkedList() {}

    @Override
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) head = tail = newNode;
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    @Override
    public void add(T item, int index) {
        MyNode<T> newNode = new MyNode<>(item);
        MyNode<T> c = head;
        if (index >= length || index < 0) throw new IndexOutOfBoundsException(oob_msg);

        for (int i = 0; i < index; i++) c = c.next;
        c.prev.next = newNode;
        newNode.next = c;
        length++;
    }

    @Override
    public boolean remove(T item) {
        MyNode<T> c = head;
        if (length == 0) throw new IndexOutOfBoundsException(oob_msg);

         while (c != null) {
            if (c.data.equals(item)) {
                MyNode<T> next_n = c.next;
                MyNode<T> prev_n = c.prev;
                if (prev_n == null) {
                    head = next_n;
                    tail = next_n;
                }
                else if (next_n == null) tail = c.prev;
                else {
                    prev_n.next = next_n;
                    next_n.prev = prev_n;
                }
                length--;
                return true;
            }
            c = c.next;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        MyNode<T> newNode = head;
        MyNode<T> next_n = newNode.next;
        MyNode<T> prev_n = newNode.prev;
        if (index >= length || index < 0) throw new IndexOutOfBoundsException(oob_msg);

        for (int i = 0; i < index; i++){
            newNode = newNode.next;
        }

        if (prev_n == null) {
            head = next_n;
            tail = next_n;
        }
        else if (next_n == null) tail = newNode.prev;
        else {
            prev_n.next = next_n;
            next_n.prev = prev_n;
        }
        length--;
        return newNode.data;
    }

    @Override
    public void clear() {
        length = 0;
        head = null;
    }

    public T get(int index) {
        MyNode<T> t = head;
        if (index >= length || index < 0) throw new IndexOutOfBoundsException(oob_msg);

        while (index != 0) {
            t = t.next;
            index--;
        }
        return t.data;
    }

    @Override
    public int indexOf(Object o) {
        MyNode<T> t = head;
        int index = 0;

        while (index != length - 1) {
            if (t.data == o) return index;
            t = t.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        MyNode<T> t = head;
        int index = length - 1;

        while (index != 0) {
            if (t.data == o) return index;
            t = t.next;
            index--;
        }
        return 0;
    }

    // linked list specific method
    private MyNode<T> get_t(int index) {
        MyNode<T> t = head;
        if (index >= length || index < 0) throw new IndexOutOfBoundsException(oob_msg);

        while (index != 0) {
            t = t.next;
            index--;
        }
        return t;
    }

    @Override
    public void sort() {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (get(j).compareTo(get(j + 1)) > 0) {
                    T t = get_t(j).data;
                    get_t(j).data = get_t(j + 1).data;
                    get_t(j + 1).data = t;
                }
            }
        }
    }

    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        MyNode<T> t = head;
        int index = length - 1;

        while (index > 0) {
            if (t.data == o) return true;
            t = t.next;
            index--;
        }
        return false;
    }

}
