package linkedlist;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MyLinkedListTest {

    private MyLinkedList list;

    @BeforeEach
    void setList() {
        list = new MyLinkedList();
        list.pushToTail(1);
        list.pushToTail(2);
        list.pushToTail(3);
    }

    @org.junit.jupiter.api.Test
    void pushToHead() {
        list.pushToHead(0);
        int result = list.get(0);
        assertEquals(0, result);
    }

    @org.junit.jupiter.api.Test
    void pushToTail() {
        list.pushToTail(4);
        int result = list.get(3);
        assertEquals(4, result);
    }

    @org.junit.jupiter.api.Test
    void pushToIndex() {
        list.pushToIndex(1, 5);
        int result = list.get(1);
        assertEquals(5, result);
    }

    @org.junit.jupiter.api.Test
    void removeFirst() {
        list.removeFirst();
        int result = list.get(0);
        assertEquals(2, result);
    }

    @org.junit.jupiter.api.Test
    void removeLast() {
        list.removeLast();
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> list.get(2));
        assertEquals("No such index -> 2", exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void remove() {
        list.remove(1);
        int result = list.get(1);
        assertEquals(3, result);
    }

    @org.junit.jupiter.api.Test
    void get() {
        int result = list.get(1);
        assertEquals(2, result);
    }

    @org.junit.jupiter.api.Test
    void size() {
        int listSize = list.size();
        assertEquals(3, listSize);
    }
}