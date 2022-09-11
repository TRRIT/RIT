package quest1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyListTest {


    @Test
    void addMustIncreaseSize1() {
        MyList<Integer> test = new MyList<>();
        int sizeOld = test.size();
        test.add(1);
        int sizeNew = test.size();

        Assertions.assertEquals(sizeOld + 1, sizeNew, " 1 должно быть равно 1");
    }

    @Test
    void addMustIncreaseSize2() {
        MyList<Integer> test = new MyList<>();
        int sizeOld = test.size();
        test.add(null);
        test.add(1);
        int sizeNew = test.size();

        Assertions.assertEquals(sizeOld + 2, sizeNew, "не может добавить null");
        Assertions.assertEquals(test.data[1], 1, "не добавил элемент");
    }

    @Test
    void addMustIncreaseSize3() {
        MyList<Integer> test = new MyList<>();
        test.add(null);
        test.add(null);
        int sizeOld = test.size();
        test.add(0, 1);
        int sizeNew = test.size();
        Assertions.assertEquals(sizeOld + 1, sizeNew, "не сдвинул элементы массива");
        Assertions.assertEquals(test.data[0], 1, "не добавил элемент");
        assertNull(test.data[2], "не добавил элемент");
    }

    @Test
    void shouldReplaceTheElement() {
        MyList<Integer> test = new MyList<>();
        test.add(null);
        test.replace(1, 0);
        Assertions.assertEquals(test.data[0], 1, "не заменил значение");
    }

    @Test
    void mustDeleteByElement1() {
        MyList<Object> test = new MyList<>();
        test.add("0");
        test.add("1");
        test.add("0");
        int oldSize = test.size();
        test.remove("0");
        int newSize = test.size();
        MyList<String> test2 = new MyList<>();
        test2.add("1");
        test2.add("0");

        Assertions.assertEquals("1", test.data[0], "элементы после удаления должны сдвинуться влево, замещая удаленный эелемент ");
        Assertions.assertEquals("0", test.data[1], "удалил лишний элемент ");
        Assertions.assertEquals(oldSize - 1, newSize, "размер массива не уменьшился");
        Assertions.assertArrayEquals(test2.data, test.data, "не верные элементы в массиве");
    }

    @Test
    void mustDeleteByIndex() {
        MyList<String> test = new MyList<>();
        test.add("0");
        test.add("1");
        test.add("0");
        int oldSize = test.size();
        test.remove(0);
        int newSize = test.size();
        Assertions.assertEquals("1", test.data[0], "не удалил элемент ");
        Assertions.assertEquals(oldSize - 1, newSize, "не сдвинул массив после удаления");
    }

    @Test
    void checkSize() {
        MyList<String> test = new MyList<>();
        Assertions.assertEquals(0, test.size(), "размер листа должен равен 0");

        test.add("0");
        test.add("1");
        test.add("0");
        Assertions.assertEquals(3, test.size(), "размер листа должен равен 3");
    }

    @Test
    void deleteNull() {
        MyList<String> test = new MyList<>();
        test.add(null);
        test.add(null);
        test.add(null);
      //  test.add("1");
        int oldSize = test.size();
        test.reduce();
        Assertions.assertEquals(oldSize - 3, test.size(), "не удалил null");
    }

    @Test
    void ReturnsNewArrayOfTheElementOfThisList() {
        String[] strings = new String[3];
        MyList<String> test = new MyList<>();
        strings = test.toArray(strings);
        Assertions.assertArrayEquals(test.data, strings,"массивы отличаются");
    }
}