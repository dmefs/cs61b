import java.util.LinkedList;

public class LinkedListDeque<T> extends LinkedList<T> implements Deque<T> {
    private LinkedList<T> ll;

    public LinkedListDeque() {
        ll = new LinkedList<>();
    }

    @Override
    public void addFirst(T item) {
        ll.addFirst(item);
    }

    @Override
    public void addLast(T item) {
        ll.addLast(item);
    }

    @Override
    public boolean isEmpty() {
        return ll.size() == 0;
    }

    @Override
    public int size() {
        return ll.size();
    }

    public void printDeque() {
        int num = ll.size();
        for (int i = 0; i < num; i++) {
            System.out.print(ll.get(i) + " ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        return ll.removeFirst();
    }

    @Override
    public T removeLast() {
        return ll.removeLast();
    }

    @Override
    public T get(int index) {
        return ll.get(index);
    }
}
