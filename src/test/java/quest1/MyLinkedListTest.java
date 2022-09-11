package quest1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;


class MyLinkedListTest {

    @Test
    void addMustIncreaseSize1() {
        MyLinkedList<Integer> test = new MyLinkedList<>();
        int sizeOld = test.size();
        test.add(1);
        int sizeNew = test.size();
        Assertions.assertEquals(sizeOld+1,sizeNew,"не добавился элемент");
    }

    @Test
    void add1() {
        MyLinkedList<Integer> test = new MyLinkedList<>();
        test.add(2);
        test.add(2);
        test.add(1,3);
        Assertions.assertEquals(3,test.getValue(1),"не добавился элемент");
    }
}