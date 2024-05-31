public class PriorityQueue<T extends Comparable<T>> {
    
    public class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public Node<T> Front;
    public Node<T> Rear;

    public void enqueue(T obj) {
        Node<T> newNode = new Node<>(obj);

        if (isEmpty()) {
            Front = newNode;
            Rear = Front;
        } else {

            Node<T> temp = Front;

            while (temp != null) {
                // This inserts the node prior to the node of greater value
                if (obj.compareTo(temp.data) < 0) {
                    newNode.next = temp.next;
                    temp.next = newNode;
                    newNode.data = temp.data;
                    temp.data = obj;
                    break;
                }

                //If the node inserted has the greatest, it inserts at the end

                if (temp.next == null) {
                    temp.next = newNode;
                    Rear = newNode;
                    break;
                }

                temp = temp.next;
            }

        }
    }


    // Removes the first node in the linked list.
    // Takes complexity O(1)
    public T dequeue() {
        if (!isEmpty()) {
            Node<T> temp = Front;
            Front = Front.next;
            return temp.data;
        }

        return null;

    }

    // Checks whether the linkedlist is empty
    public boolean isEmpty() {
        return Front == null;
    }

    //Prints the linkedlist
    public String toString() {

        if (Front != null) {
            Node head = Front;
            String list = "{ ";


            while (head != Rear) {
                list += head.data + ", ";
                head = head.next;

            }

            list += head.data + " }";

            return list;
        }

        return "{ }";


    }

}
