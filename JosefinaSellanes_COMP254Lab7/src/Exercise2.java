import java.util.LinkedList;
import java.util.Queue;

public class Exercise2 {

    public static Queue<Integer> merge(Queue<Integer> q1, Queue<Integer> q2) {
        Queue<Integer> result = new LinkedList<>();

        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.peek() < q2.peek()) {
                result.add(q1.poll());
            } else {
                result.add(q2.poll());
            }
        }

        while (!q1.isEmpty()) {
            result.add(q1.poll());
        }

        while (!q2.isEmpty()) {
            result.add(q2.poll());
        }

        return result;
    }

    public static Queue<Integer> mergeSort(Queue<Integer> input) {
        Queue<Queue<Integer>> queueOfQueues = new LinkedList<>();

        while (!input.isEmpty()) {
            Queue<Integer> single = new LinkedList<>();
            single.add(input.poll());
            queueOfQueues.add(single);
        }

        while (queueOfQueues.size() > 1) {
            Queue<Integer> q1 = queueOfQueues.poll();
            Queue<Integer> q2 = queueOfQueues.poll();

            Queue<Integer> merged = merge(q1, q2);
            queueOfQueues.add(merged);
        }

        return queueOfQueues.poll();
    }

    public static void main(String[] args) {
        Queue<Integer> data = new LinkedList<>();

        data.add(5);
        data.add(2);
        data.add(9);
        data.add(1);
        data.add(6);

        System.out.println("Original: " + data);

        Queue<Integer> sorted = mergeSort(data);

        System.out.println("Sorted: " + sorted);
    }
}