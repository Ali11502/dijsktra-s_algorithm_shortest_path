public class LinkedQueue<E> {

    private class Node<E> {
        E value;
        Node<E> next;

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private int count;
    private Node<E> front;
    private Node<E> rear;

    public LinkedQueue() {
        front = rear = null;
        count = 0;
    }

    public void enqueue(E value) {
        if (rear != null) {
            rear.next = new Node(value, null);
            rear = rear.next;
        } else {
            rear = new Node(value, null);
            front = rear;
        }
        count++;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot dequeue - Queue is empty");
        }

        E value = front.value;
        front = front.next;
        count--;

        if (front == null) {
            rear = null;
        }

        return value;
    }


    public boolean isEmpty() {
        return front == null;
    }

    public E peek() {
        return front.value;
    }

    public int size() {
        return count;
    }

}
