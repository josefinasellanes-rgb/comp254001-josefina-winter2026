package linkedlists;

public class SinglyLinkedList<E> implements Cloneable {

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0)
            tail = head;
        size++;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty())
            return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0)
            tail = null;
        return answer;
    }

    // EXERCISE 2

    public void swapNodes(Node<E> node1, Node<E> node2) {

        if (node1 == node2 || head == null)
            return;

        Node<E> prev1 = null, prev2 = null, walk = head;

        while (walk != null && (prev1 == null || prev2 == null)) {
            if (walk.getNext() == node1)
                prev1 = walk;
            if (walk.getNext() == node2)
                prev2 = walk;
            walk = walk.getNext();
        }

        if (node1 != head && prev1 == null)
            return;
        if (node2 != head && prev2 == null)
            return;

        if (node1 == head)
            head = node2;
        else
            prev1.setNext(node2);

        if (node2 == head)
            head = node1;
        else
            prev2.setNext(node1);

        Node<E> temp = node1.getNext();
        node1.setNext(node2.getNext());
        node2.setNext(temp);

        if (node1 == tail)
            tail = node2;
        else if (node2 == tail)
            tail = node1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = head;
        while (walk != null) {
            sb.append(walk.getElement());
            if (walk != tail)
                sb.append(", ");
            walk = walk.getNext();
        }
        sb.append(")");
        return sb.toString();
    }

    // Test

    public static void main(String[] args) {

        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.addLast("D");

        System.out.println("Before: " + list);

        Node<String> n1 = list.head.getNext();
        Node<String> n2 = list.head.getNext().getNext();

        list.swapNodes(n1, n2);

        System.out.println("After swap: " + list);
    }
}
