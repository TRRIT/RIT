package quest1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyListTest {

    @Test
    void add() {
       MyList<Integer> test = new MyList<>();
       int sizeOld = test.size();
       test.add(1);
       int sizeNew = test.size();


        Assertions.assertEquals(sizeOld + 1 , sizeNew, " 1 должно быть равно 1");
    }

    @Test
    void testAdd() {
        MyList<Integer> test = new MyList<>();
        int sizeOld = test.size();
        test.add(null);
        test.add(1);
        int sizeNew = test.size();

        Assertions.assertEquals(sizeOld + 2 , sizeNew, "не может добавить null");
        Assertions.assertEquals(test.data[1],1,"не добавил элемент");
    }

    @Test
    void test2Add(){
        MyList<Integer> test = new MyList<>();
        test.add(null);
        test.add(null);
        int sizeOld = test.size();
        test.add(0,1);
        int sizeNew = test.size();
        Assertions.assertEquals(sizeOld + 1, sizeNew, "не сдвинул элементы массива");
        Assertions.assertEquals(test.data[0],1,"не добавил элемент");
        assertNull(test.data[2], "не добавил элемент");
    }

    @Test
    void replace() {
        MyList<Integer> test = new MyList<>();
        test.add(null);
        test.replace(1,0);
        Assertions.assertEquals(test.data[0],1,"не заменил значение");
    }

    @Test
    void remove() {
        MyList<String> test = new MyList<>();
        test.add("0");
        test.add("1");
        test.add("0");
        int oldSize = test.size();
        test.remove("0");
        int newSize = test.size();
        Assertions.assertEquals("1",test.data[0],"не удалил элемент ");
        Assertions.assertEquals("0",test.data[1], "удалил лишний элемент ");
        Assertions.assertEquals(oldSize - 1,newSize, "не сдвинул массив после удаления ");
    }

    @Test
    void testRemove() {
        MyList<String> test = new MyList<>();
        test.add("0");
        test.add("1");
        test.add("0");
        int oldSize = test.size();
        test.remove(0);
        int newSize = test.size();
        Assertions.assertEquals("1",test.data[0],"не удалил элемент ");
        Assertions.assertEquals(oldSize - 1,newSize, "не сдвинул массив после удаления");
    }

    @Test
    void size() {
        MyList<String> test = new MyList<>();
        Assertions.assertEquals(0,test.size(),"не соответствует размеру");

        test.add("0");
        test.add("1");
        test.add("0");
        Assertions.assertEquals(3,test.size(),"не соответствует размеру");
    }

    @Test
    void reduce() {
        MyList<String> test = new MyList<>();
        test.add(null);
        test.add(null);
        test.add(null);
        int oldSize = test.size();
        test.reduce();
        Assertions.assertEquals(oldSize - 3, test.size(),"не удалил null");
    }

    @Test
    void todata() {
        var listTest = new MyList<String>();
        listTest.add("HO HO HO");
        String[] strings = listTest.toArray(new String[0]);
        String[] strings1 = listTest.toArray(new String[10]);
    }
}