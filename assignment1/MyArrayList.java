// MyArrayList.java
// by Aydar Amangeldy CS-2129N
package assignment1;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {

    private Object[] array;
    private int length = 0;
    private int capacity = 3;

    public MyArrayList(int length) {
        array = new Object[capacity];
    }

    @Override
    public void add(T item) {
        if (length == capacity)
            increaseCapacity();

        array[length++] = item;
    }

    @Override
    public void add(T item, int index) {
        //  for (int i = index; i <= array.length; i++) { array[i + 1]=array[i]; }
        if (array.length + 1 - index >= 0) System.arraycopy(array, index, array, index + 1, array.length + 1 - index);
        array[index] = item;
    }

    // array list specific method
    private void laid(int i) { // laid - Location After Item Deletion
        // for (int j = i; j < array.length; j++) { array[j] = array[j + 1]; }
        if (array.length - i >= 0) System.arraycopy(array, i + 1, array, i, array.length - i);
    }

    @Override
    public boolean remove(T item) {
        for (int i = 0; i < array.length; i++){
            if (array[i] == item){
                laid(i);
                return true;
            }
        }
        return false;
    }

    // array list specific method
    private void re_laid(int index) { // re_laid - RElocation After Item Deletion
        // for (int i = index; i < array.length; i++) { array[i] = array[i + 1]; }
        if (array.length - index >= 0) System.arraycopy(array, index + 1, array, index, array.length - index);
    }

    @Override
    public T remove(int index) {
        T removalItem = (T)array[index];
        re_laid(index);
        return removalItem;

    }

    @Override
    public void clear() {
        for (int i = 0; i < length; i++) { array[i] = null; }
        length = 0;
    }

    private void increaseCapacity() {
        capacity = 2 * capacity;
        Object[] old = array;
        array = new Object[capacity];

        /*
        for (int i = 0; i < old.length; i++)
            array[i] = old[i];
         */
        System.arraycopy(old, 0, array, 0, old.length);
    }

    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] == o){
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] == o){
                index = i;
            }
        }
        return index;
    }

    @Override
    public void sort() {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                Comparable<T> a = (T) array[j];
                if (a.compareTo((T) array[j + 1]) > 0) {
                    Object t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
        }
    }

    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        /*
         for (int i = 0; i < array.length; i++){
            if (array[i] == o){
                return true;
            }
        }
         */
        for (Object value : array) {
            if (value == o) {
                return true;
            }
        }
        return false;
    }
}
