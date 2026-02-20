import java.io.File;
import java.util.Scanner;

public class JosefinaSellanes_COMP254Lab03_Ex3 {

    public static void find(File path, String filename) {
        if (path == null || !path.exists()) {
            return;
        }

        if (path.getName().equals(filename)) {
            System.out.println(path.getAbsolutePath());
        }

        if (path.isDirectory()) {
            File[] children = path.listFiles();
            if (children != null) {
                for (File child : children) {
                    find(child, filename);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter starting path: ");
        String startPath = input.nextLine();

        System.out.print("Enter filename to search for: ");
        String filename = input.nextLine();

        find(new File(startPath), filename);

        input.close();
    }
}
