import java.util.Scanner;

public class JosefinaSellanes_COMP254Lab03_Ex1 {

    public static int product(int m, int n) {
        if (m == 0) {
            return 0;
        } else {
            return n + product(m - 1, n);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first positive integer (m): ");
        int m = input.nextInt();

        System.out.print("Enter second positive integer (n): ");
        int n = input.nextInt();

        int result = product(m, n);
        System.out.println("Product = " + result);

        input.close();
    }
}