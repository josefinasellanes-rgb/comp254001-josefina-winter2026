public class Exercise1 {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(10, "A");
        map.put(5, "B");
        map.put(15, "C");
        map.put(3, "D");
        map.put(7, "E");

        System.out.println("Search 7: " + map.get(7));
        System.out.println("Search 20: " + map.get(20));
    }
}