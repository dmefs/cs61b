public class ArrayDeque<T> {
    private T []items;
    private int front, rear;
    private int size, capacity;
    private final int USAGE_FACTOR = 4;

    public ArrayDeque() {
        size = front = rear = 0;
        capacity = 8;
        items = (T[]) new Object[capacity];
    }

    private boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    private void resize() {
        if (isFull()) {
            capacity *= 2;
        } else {
            capacity /= USAGE_FACTOR;
        }
        T[] newArray = (T[]) new Object[capacity];
        if (front < rear) {
            System.arraycopy(items, front, newArray, 0, size);
        } else {
            System.arraycopy(items, front, newArray, 0, capacity - front);
            System.arraycopy(items, 0, newArray, capacity - front, rear);
        }
        items = newArray;
    }

    public void addFirst(T item) {
        if (isFull()) {
            resize();
        }
        front = ((front - 1) + capacity) % capacity;
        items[front] = item;
        size += 1;
    }

    public void addLast(T item) {
        if (isFull()) {
            resize();
        }
        items[rear] = item;
        rear = (rear + 1) % capacity;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        for (int i = front; i != rear; i = (i + 1) % capacity) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T item = items[front];
        front = (front + 1) % capacity;
        size -= 1;
        if (size < (capacity / USAGE_FACTOR)) {
            resize();
        }
        return item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        rear = ((rear - 1) + capacity) % capacity;
        size -= 1;
        if (size < (capacity / USAGE_FACTOR)) {
            resize();
        }
        return items[rear];
    }

    public T get(int index) {
        int position = (index + front) % capacity;
        return items[position];
    }

    public int size() {
        return size;
    }
}
