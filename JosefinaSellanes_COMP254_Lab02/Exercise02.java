package JosefinaSellanes_COMP254_Lab02;

public class Exercise02 {

    public static double[] prefixAverage1(double[] x) {
        int n = x.length;
        double[] a = new double[n];
        for (int j = 0; j < n; j++) {
            double total = 0;
            for (int i = 0; i <= j; i++)
                total += x[i];
            a[j] = total / (j + 1);
        }
        return a;
    }

    public static double[] prefixAverage2(double[] x) {
        int n = x.length;
        double[] a = new double[n];
        double total = 0;
        for (int j = 0; j < n; j++) {
            total += x[j];
            a[j] = total / (j + 1);
        }
        return a;
    }

    public static void main(String[] args) {
        int n = 1_000;
        int trials = 10;

        System.out.println("PrefixAverage2 (O(n))");
        for (int t = 0; t < trials; t++) {
            double[] data = new double[n];
            long start = System.currentTimeMillis();
            prefixAverage2(data);
            long end = System.currentTimeMillis();
            System.out.println("n=" + n + " time=" + (end - start) + " ms");
            n *= 2;
        }

        n = 1_000;
        System.out.println("\nPrefixAverage1 (O(n²))");
        for (int t = 0; t < trials; t++) {
            double[] data = new double[n];
            long start = System.currentTimeMillis();
            prefixAverage1(data);
            long end = System.currentTimeMillis();
            System.out.println("n=" + n + " time=" + (end - start) + " ms");
            n *= 2;
        }
    }
}
