public class TestConcatenate {

    public static void main(String[] args) {

        LinkedQueue<Integer> Q1 = new LinkedQueue<>();
        LinkedQueue<Integer> Q2 = new LinkedQueue<>();

        Q1.enqueue(1);
        Q1.enqueue(2);
        Q1.enqueue(3);

        Q2.enqueue(4);
        Q2.enqueue(5);

        Q1.concatenate(Q2);

        System.out.println(Q1);
        System.out.println(Q2);
    }
}