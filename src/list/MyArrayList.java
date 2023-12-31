package list;

public class MyArrayList<E> {
    private int size;
    private int capacity = 16;

    private Object[] arrays;

    public MyArrayList() {
        this.size = 0;
        this.arrays = new Object[capacity];
    }

    public void add(E value) {
        if (value != null) {
            arrays[size] = value;

            size++;

            if (size == capacity) {
                capacity = capacity + 20;

                Object[] newArrays = new Object[capacity];
                for (int i = 0; i < size; i++) {
                    newArrays[i] = arrays[i];
                }
                arrays = newArrays;
            }
        }
    }

    public boolean remove(int index) {
        if (index < 0 || index > size) {
            return false;
        }

        if (size > 0) {
            Object[] newArrays = new Object[arrays.length];
            for (int i = 0; i < index; i++) {
                newArrays[i] = arrays[i];
            }
            for (int i = index + 1; i < size; i++) {
                newArrays[i - 1] = arrays[i];
            }
            arrays = newArrays;
            size--;
        }

        return true;
    }

    public void set(int index, E value) {
        if (index > 0 && index < size && value != null) {
            arrays[index] = value;
        }
    }

    public boolean removeByValue(E value) {
        if (value == null) {
            return false;
        }
        boolean exist = this.contains(value);
        if (exist == false) {
            return false;
        }

        int index = this.findByValue(value);

        this.remove(index);

        return true;
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            return null;
        }

        E value = (E) arrays[index];
        return value;
    }

    public int findByValue(E value) {
        boolean exist = this.contains(value);
        if (exist == false) {
            return -1;
        }

        E temp;
        for (int i = 0; i < size; i++) {
            temp = (E) arrays[i];
            if (temp.equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(E value) {
        if (value == null) {
            return false;
        }

        E temp;
        for (int i = 0; i < size; i++) {
            temp = (E) arrays[i];
            if (temp.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    public void printList() {
        System.out.print("[");

        int lastIndex = size - 1;
        Object temp;
        for (int i = 0; i < size; i++) {
            temp = arrays[i];

            System.out.print(temp);
            if (i != lastIndex) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

}
