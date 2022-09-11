package quest1;

import java.util.ArrayList;
import java.util.Arrays;

public class MyList<E> implements List<E> {
    Object[] data;
    private int size = 0;

    public MyList() {

        this.data = new Object[10];
    }

    private void grow() {
        Object[] copyData = data;
        data = new Object[copyData.length * 2];
        System.arraycopy(copyData, 0, data, 0, copyData.length);
    }

    private void shiftPlus(int index) {
        if (size - 1 - index >= 0) {
            System.arraycopy(data, index, data, index + 1, size - 1 - index);
        }
        size++;
    }

    private void shiftMinus(int index) {
        if (size - 1 - index >= 0) {
            System.arraycopy(data, index + 1, data, index, size - 1 - index);
        }
        data[size - 1] = null;
        size--;
    }

    @Override
    public E add(E element) {
        if (this.size == data.length) {
            grow();
        }
        data[size++] = element;
        return element;
    }

    @Override
    public E add(int index, E element) {
        E elementReplaced = (E) data[index];
        if (this.size == data.length) {
            grow();
        }
        shiftPlus(index);
        data[index] = element;
        return elementReplaced;
    }

    @Override
    public E get(int index) {
        return (E) data[index];
    }

    @Override
    public E replace(E element, int index) {
        E elementReplaced = (E) data[index];
        data[index] = element;
        return elementReplaced;
    }

    @Override
    public E remove(E element) {
        for (int i = 0; i < size - 1; i++) {
            if (data[i].equals(element)) {
                return remove(i);
            }
        }
        return null;
    }

    @Override
    public E remove(int index) {
        Object[] copyArrayData = data;
        shiftMinus(index);
        return (E) copyArrayData[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void reduce() {
        for (int i = 0; i < this.size; i++) {
            if (data[i] == null) {
                shiftMinus(i);
                i--;
            }
        }
        Object[] copyData = data;
        data = new Object[this.size];
        System.arraycopy(copyData, 0, data, 0, data.length);
    }

    @Override
    public E[] toArray(E[] array) {
        if (array.length < data.length) {
            return (E[]) Arrays.copyOf(data, data.length, array.getClass());
        } else {
            System.arraycopy(this.data, 0, array, 0, data.length);
            return array;
        }
    }
}
