package JosefinaSellanes_COMP254_Lab02;

public class Exercise01 {

    // example1
    // Time Complexity: O(n)
    // Explanation: Single loop iterates n times.

    public static int example1(int[] arr) {
        int n = arr.length, total = 0;
        for (int j = 0; j < n; j++)
            total += arr[j];
        return total;
    }

    // example2
    // Time Complexity: O(n)
    // Explanation: Loop increments by 2, but still proportional to n.

    public static int example2(int[] arr) {
        int n = arr.length, total = 0;
        for (int j = 0; j < n; j += 2)
            total += arr[j];
        return total;
    }

    // example3
    // Time Complexity: O(n²)
    // Explanation: Nested loops where inner loop runs j times.
    // Total operations = n(n+1)/2.

    public static int example3(int[] arr) {
        int n = arr.length, total = 0;
        for (int j = 0; j < n; j++)
            for (int k = 0; k <= j; k++)
                total += arr[j];
        return total;
    }

    // example4
    // Time Complexity: O(n)
    // Explanation: Single loop, prefix sum updated in constant time.

    public static int example4(int[] arr) {
        int n = arr.length, prefix = 0, total = 0;
        for (int j = 0; j < n; j++) {
            prefix += arr[j];
            total += prefix;
        }
        return total;
    }

    // example5
    // Time Complexity: O(n³)
    // Explanation: Three nested loops each dependent on n.

    public static int example5(int[] first, int[] second) {
        int n = first.length, count = 0;
        for (int i = 0; i < n; i++) {
            int total = 0;
            for (int j = 0; j < n; j++)
                for (int k = 0; k <= j; k++)
                    total += first[k];
            if (second[i] == total)
                count++;
        }
        return count;
    }
}
