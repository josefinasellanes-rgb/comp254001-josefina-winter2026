import java.util.Random;

import maps.ChainHashMap;

public class TestHashMap {
    public static void main(String[] args) {

        int n = 10000;
        double[] loadFactors = { 0.25, 0.5, 0.75, 0.9 };

        for (double lf : loadFactors) {

            ChainHashMap<Integer, Integer> map = new ChainHashMap<>(17, 109345121, lf);

            Random rand = new Random();

            long startPut = System.nanoTime();

            for (int i = 0; i < n; i++) {
                map.put(rand.nextInt(100000), i);
            }

            long endPut = System.nanoTime();

            long startGet = System.nanoTime();

            for (int i = 0; i < n; i++) {
                map.get(rand.nextInt(100000));
            }

            long endGet = System.nanoTime();

            System.out.println("Load Factor: " + lf);
            System.out.println("Put Time: " + (endPut - startPut) / 1e6 + " ms");
            System.out.println("Get Time: " + (endGet - startGet) / 1e6 + " ms");
            System.out.println("---------------------------");
        }
    }
}