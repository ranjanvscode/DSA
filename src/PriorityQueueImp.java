import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueImp {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(1);
        pq.add(3);
        pq.add(10);
        pq.add(2);
        pq.add(5);
        pq.add(9);
        pq.add(7);
        pq.add(6);

        pq.add(4);
        pq.add(8);

        System.out.println(pq);

    }
}
