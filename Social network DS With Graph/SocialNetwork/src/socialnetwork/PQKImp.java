package socialnetwork;

/**
 * Piority Queue Using Array
 *
 * @param <P>
 * @param <T>
 */
public class PQKImp<P extends Comparable<P>, T> implements PQK<P, T> {

    private int maxsize;
    private int front, rear;
    private int size;

    private T[] data;
    private P[] priority;

    public PQKImp(int k) {
        maxsize = k;
        size = 0;
        front = rear = 0;
        data = (T[]) new Object[k];
        priority = (P[]) new Comparable[k];
    }

    /**
     * Return Total number of element from Circular Piority Queue
     *
     * @return
     */
    @Override
    public int length() {
        if (size >= maxsize) {
            return size = maxsize;
        } else {
            return size;
        }
    }

    /**
     * Add Data in Piority Queue We used insertion sort technique for insert
     * data.
     *
     * @param pr
     * @param e
     */
    @Override
    public void enqueue(P pr, T e) {

        //Integer p = (Integer) pr;
        // Code Start from Here 
        if (front == 0 && rear == 0) {
            data[rear] = e;
            priority[rear] = pr;
            rear++;
            size++;
        } else if (front < rear) {

            //If array is full.
            if (isFUll()) {
                int in = maxsize - 1;

                //if (priority[in] < pr) {
                if(pr.compareTo(priority[in]) == 1){    
                    data[in] = e;
                    priority[in] = pr;
                    int in2 = in - 1;
                    P key = pr;

                    while (in2 >= 0 && pr.compareTo(priority[in2]) == 1) {
                        data[in2 + 1] = data[in2];
                        priority[in2 + 1] = priority[in2];
                        in2 = in2 - 1;
                    }

                    data[in2 + 1] = e;
                    priority[in2 + 1] = pr;

                }

            } else {
                // Queue is not full
                data[rear] = e;
                priority[rear] = pr;
                int in = rear - 1;
                P key = priority[rear];

                while (in >= 0 && pr.compareTo(priority[in])==1) {
                    data[in + 1] = data[in];
                    priority[in + 1] = priority[in];
                    in = in - 1;
                }

                data[in + 1] = e;
                priority[in + 1] = pr;

                rear++;
                size++;
            }
        }
    }


    /**
     * Return data with High Piority
     *
     * @return
     */
    @Override
    public Pair<P, T> serve() {
        P p = (P) priority[front];
        Pair<P, T> e = new Pair<>(p, data[front]);
        for (int i = 1; i < maxsize; i++) {
            data[i - 1] = data[i];
            priority[i - 1] = priority[i];
        }
        rear--;
        size--;
        return e;

    }

    /**
     * Is array is full or not!
     *
     * @return
     */
    @Override
    public boolean isFUll() {
        return length() == maxsize;
    }

}
