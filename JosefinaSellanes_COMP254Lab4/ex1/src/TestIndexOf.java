public class TestIndexOf {

    public static void main(String[] args) {

        LinkedPositionalList<Integer> list = new LinkedPositionalList<>();

        Position<Integer> p1 = list.addLast(10);
        Position<Integer> p2 = list.addLast(20);
        Position<Integer> p3 = list.addLast(30);

        System.out.println("Index of 10: " + list.indexOf(p1));
        System.out.println("Index of 20: " + list.indexOf(p2));
        System.out.println("Index of 30: " + list.indexOf(p3));
    }
}