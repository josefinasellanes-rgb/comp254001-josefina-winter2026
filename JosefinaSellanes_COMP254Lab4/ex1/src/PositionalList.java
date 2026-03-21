public interface PositionalList<E> {

    int size();

    boolean isEmpty();

    Position<E> first();

    Position<E> last();

    Position<E> before(Position<E> p);

    Position<E> after(Position<E> p);

    Position<E> addFirst(E e);

    Position<E> addLast(E e);

    E remove(Position<E> p);

    int indexOf(Position<E> p);
}