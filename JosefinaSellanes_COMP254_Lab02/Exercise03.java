package JosefinaSellanes_COMP254_Lab02;

import java.util.*;

public class Exercise03 {

    public static boolean unique1(int[] data) {
        int n = data.length;
        for (int j = 0; j < n - 1; j++)
            for (int k = j + 1; k < n; k++)
                if (data[j] == data[k])
                    return false;
        return true;
    }

    public static boolean unique2(int[] data) {
        int[] temp = Arrays.copyOf(data, data.length);
        Arrays.sort(temp);
        for (int j = 0; j < temp.length - 1; j++)
            if (temp[j] == temp[j + 1])
                return false;
        return true;
    }

    private static int[] randomArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = rand.nextInt();
        return arr;
    }

    public static void main(String[] args) {

        int n = 1_000;

        System.out.println("Testing unique1 (O(n^2))");
        while (n <= 5_000_000) {
            int[] data = randomArray(n);
            long start = System.currentTimeMillis();
            unique1(data);
            long time = System.currentTimeMillis() - start;

            System.out.println("n=" + n + " time=" + time + " ms");

            if (time > 60_000)
                break;
            n *= 2;
        }

        n = 1_000;
        System.out.println("\nTesting unique2 (O(n log n))");
        while (n <= 5_000_000) {
            int[] data = randomArray(n);
            long start = System.currentTimeMillis();
            unique2(data);
            long time = System.currentTimeMillis() - start;

            System.out.println("n=" + n + " time=" + time + " ms");

            if (time > 60_000)
                break;
            n *= 2;
        }
    }
}
