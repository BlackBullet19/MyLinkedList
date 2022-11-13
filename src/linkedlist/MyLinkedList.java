package linkedlist;

import java.util.NoSuchElementException;

public class MyLinkedList implements MyLinkedListInterface {

    transient int size;
    transient MyNode first;
    transient MyNode last;


    public MyLinkedList() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    @Override
    public void pushToHead(int data) {
        final MyNode head = first;
        final MyNode newNode = new MyNode(data, head);
        first = newNode;
        if (head == null) {
            last = newNode;
        }
        size++;
    }

    @Override
    public void pushToTail(int data) {
        final MyNode tail = last;
        final MyNode newNode = new MyNode(data, null);
        last = newNode;
        if (tail == null) {
            first = newNode;
        } else {
            tail.next = newNode;
        }
        size++;
    }

    @Override
    public void pushToIndex(int index, int data) {
        if (index == size) {
            pushToTail(data);
        }
        if (index == 0) {
            pushToHead(data);
        }
        checkElementIndex(index);
        MyNode previousNode = first;
        for (int i = 0; i < index - 1; i++) {
            previousNode = previousNode.next;
        }
        MyNode nextNode = previousNode.next;
        previousNode.next = new MyNode(data, nextNode);
        size++;
    }

    @Override
    public void removeFirst() {
        if (size > 1) {
            first = first.next;
            size--;
        } else if (size == 1) {
            first = null;
            last = null;
            size--;
        } else {
            throw new NoSuchElementException("Nothing to delete");
        }
    }

    @Override
    public void removeLast() {
        if (size == 0) {
            throw new NoSuchElementException("Nothing to delete");
        } else if (size == 1) {
            first = null;
            last = null;
            size--;
        } else if (size == 2) {
            first.next = null;
            last = first;
            size--;
        } else {
            MyNode temp = first;
            for (int i = 0; i < size - 2; i++) {
                temp = temp.next;
            }
            temp.next = null;
            last = temp;
            size--;
        }
    }

    @Override
    public void remove(int index) {
        checkElementIndex(index);
        if (index == 0) removeFirst();
        else if (index == size - 1) removeLast();
        else if (index < 2) {
            first.next = first.next.next;
            size--;
        } else {
            MyNode previous = first;
            for (int i = 0; i < size - 3; i++) {
                previous = previous.next;
            }
            previous.next = previous.next.next;
            size--;
        }
    }

    @Override
    public int get(int index) {
        checkElementIndex(index);
        MyNode temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.getData();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {
        if (size == 0) {
            System.out.println("List is empty");
        }
        MyNode temp = first;
        System.out.println("Elements from list :");
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("No such index -> " + index);
    }
}
