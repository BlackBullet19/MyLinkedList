package linkedlist;

public interface MyLinkedListInterface {

    void pushToHead(int data);

    void pushToTail(int data);

    void pushToIndex(int index, int data);

    void removeFirst();

    void removeLast();

    void remove(int index);

    int get(int index);

    int size();

    void print();
}
