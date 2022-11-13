package linkedlist;


public class LinkedListMainApp {

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();

        list.pushToTail(0);
        list.pushToTail(1);
        list.pushToTail(2);
        list.pushToTail(3);
        list.print();
    }
}
