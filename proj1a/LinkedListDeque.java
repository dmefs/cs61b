public class LinkedListDeque<T> {
    private StuffNode sentinel;
    private int size;

    private class StuffNode {
        private StuffNode prev;
        private StuffNode next;
        private T item;

        StuffNode(StuffNode next, StuffNode prev, T item) {
            this.prev = prev;
            this.next = next;
            this.item = item;
        }
    }

    public LinkedListDeque() {
        sentinel = new StuffNode(null, null, null);
        sentinel.next = sentinel.prev = sentinel;
        size = 0;
    }

    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new StuffNode(null, null, null);
        sentinel.next = sentinel.prev = sentinel;
        size = 0;
        for (int i = 0; i < other.size(); i += 1) {
            addFirst((T) other.get(i));
        }
    }

    public void addFirst(T item) {
        StuffNode p = new StuffNode(sentinel.next, sentinel, item);
        sentinel.next.prev = p;
        sentinel.next = p;
        size += 1;
    }

    public void addLast(T item) {
        StuffNode p = new StuffNode(sentinel, sentinel.prev, item);
        sentinel.prev.next = p;
        sentinel.prev = p;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (StuffNode p = sentinel.next; p != sentinel.prev; p = p.next) {
            System.out.print(p.item + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T data = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return data;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T data = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return data;
    }

    public T get(int index) {
        if ((index < 0) || (index > size)) {
            return null;
        }
        StuffNode p = sentinel;
        while (index > 0) {
            p = p.next;
            index -= 1;
        }
        return p.item;
    }

    public T getRecursive(StuffNode p, int index) {
        if (index == 0) {
            return p.item;
        }
        return getRecursive(p.next, index - 1);

    }
    public T getRecursive(int index) {
        if ((index < 0) || (index > size)) {
            return null;
        }
        return getRecursive(sentinel.next, index - 1);
    }
}
