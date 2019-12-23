    
package socialnetwork;

/**
 * LinkList
 * @param <T>
 */

public class LinkedList<T> implements List<T> {

    private Node<T> head, curr;

    public LinkedList (){
        head = curr = null;
    }

    @Override
    public boolean empty() {
        return head == null;
    }

    @Override
    public boolean full() {
        return false; // beacause it's always full..
    }

    @Override
    public void findFirst() {
        curr = head;
    }

    @Override
    public void findNext() {
        curr = curr.next;
    }

    @Override
    public boolean last() {
        return curr.next == null;
    }

    @Override
    public T retrieve() {
        return curr.data;
    }

    @Override
    public void update(T e) {
        curr.data = e;
    }

    @Override
    public void insert(T e) {
        Node<T> temp = new Node<>(e);

        if (head == null) {
            curr = head = temp;
        } else {
            temp.next = curr.next;
            curr.next = temp;
            curr = temp;
        }

    }

    @Override
    public void remove() {
        if (curr == head) // first
        {
            curr = head = head.next;
        } else {
            Node<T> p = head;
            while (p.next != curr) // middle
            {
                p = p.next;
            }

            p.next = curr.next;
            curr = curr.next;

            if (curr == null) // last
            {
                curr = head;
            }

        }
    }

    @Override
    public int size() {
        return countSize(head);
    }

    private int countSize(Node<T> root) {
        if (root == null) {
            return 0;
        }
        return 1 + countSize(root.next);
    }

    /**
     * Find Data
     * @param e
     * @return 
     */
    @Override
    public boolean exists(T e) {
        if (head == null) {
            return false;
        } else {
            return findData(head, e);
        }
    }

    /**
     * Recursively find the data
     *
     * @param head
     * @param e
     * @return
     */
    private boolean findData(Node<T> head, T e) {
        if (head == null) {
            return false;
        } else {
            if (head.data == e) {
                return true;
            } else {
                return findData(head.next, e);
            }
        }

    }

}
