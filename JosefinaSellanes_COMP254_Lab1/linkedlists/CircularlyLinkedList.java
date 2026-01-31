package linkedlists;

public class CircularlyLinkedList<E> {

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

    private Node<E> tail = null;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail);
        } else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }

    public E removeFirst() {
        if (isEmpty())
            return null;
        Node<E> head = tail.getNext();
        if (head == tail)
            tail = null;
        else
            tail.setNext(head.getNext());
        size--;
        return head.getElement();
    }

    public void rotate() {
        if (tail != null)
            tail = tail.getNext();
    }

    // EXERCISE 3

    public CircularlyLinkedList<E> clone() {
        CircularlyLinkedList<E> other = new CircularlyLinkedList<>();
        if (isEmpty())
            return other;

        Node<E> walk = tail.getNext();

        do {
            other.addLast(walk.getElement());
            walk = walk.getNext();
        } while (walk != tail.getNext());

        return other;
    }

    public String toString() {
        if (tail == null)
            return "()";
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = tail;
        do {
            walk = walk.getNext();
            sb.append(walk.getElement());
            if (walk != tail)
                sb.append(", ");
        } while (walk != tail);
        sb.append(")");
        return sb.toString();
    }

    // Test
    public static void main(String[] args) {

        CircularlyLinkedList<String> list = new CircularlyLinkedList<>();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");

        System.out.println("Original: " + list);

        CircularlyLinkedList<String> copy = list.clone();

        System.out.println("Clone: " + copy);
    }
}
