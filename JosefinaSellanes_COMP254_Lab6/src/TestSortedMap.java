
import maps.SortedTableMap;

public class TestSortedMap {
    public static void main(String[] args) {

        SortedTableMap<Integer, String> map = new SortedTableMap<>();

        map.put(10, "A");
        map.put(20, "B");
        map.put(30, "C");

        System.out.println("Contains 20? " + map.containKey(20));
        System.out.println("Contains 25? " + map.containKey(25));

        System.out.println("Get 20: " + map.get(20));
        System.out.println("Get 25: " + map.get(25));
    }
}