package quest1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;

public class MyList<E> implements List<E> {
      java.util.List<E> list = new ArrayList<>();
      Object[] data;

    public MyList() {
        this.data = new Object[0];
    }


    @Override

    public E add(E element) {

        list.add(element);
        Object[] array2 = data;
        data = new Object[data.length + 1];
        System.arraycopy(array2, 0, data, 0, array2.length);
        data[data.length - 1] = element;
        return element;
    }

    @Override
    public E add(int index, E element) {
        Object[] array2 = data;
        data = new Object[data.length + 1];
        System.arraycopy(array2, 0, data, 0, array2.length);
        data[index] = element;
        for (int i = index; i < array2.length; i++) {
            data[i + 1] = array2[i];
        }
        list.add(index, element);
        return element;
    }

    @Override
    public E replace(E element, int index) {

        data[index] = element;

        list.set(index, element);
        return element;
    }

    @Override
    public E remove(E element) {
        Object[] array2 = data;
        int k = 0;
        boolean e = true;
        data = new Object[data.length - 1];
        for (int i = 0; i < data.length ; i++) {
            if (array2[i].equals(element)) {
                if (e) {
                    e = false;
                    k++;
                }
            }
            data[i] = array2[k];
            k++;
        }

        list.remove(element);
        return element;
    }

    @Override
    public E remove(int index) {
        Object[] array2 = data;
        int k = 0;
        data = new String[data.length - 1];
        for (int i = 0; i < data.length; i++) {
            if (i == index) {
                k++;
            }
            data[i] = array2[k];
            k++;
        }
        return list.remove(index);

    }

    @Override
    public int size() {
        return data.length;
    }


    @Override
    public void reduce() {

        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                for (int r = i; r < data.length - 1; r++) {
                    data[r] = data[r + 1];
                }
                Object[] array2 = data;
                data = new Object[data.length - 1];
                System.arraycopy(array2, 0, data, 0, data.length);
                i--;
            }
        }
    }

    @Override
    public E[] toArray(E[] array) {
        if (array.length < data.length) {
            return (E[]) Arrays.copyOf(data, data.length, array.getClass());
        } else {
            System.arraycopy(this.data, 0, array, 0, this.data.length);
            return array;
        }
    }
}
