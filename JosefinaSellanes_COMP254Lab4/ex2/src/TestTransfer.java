import java.util.Stack;

public class TestTransfer {

    public static void main(String[] args) {

        Stack<Integer> S = new Stack<>();
        Stack<Integer> T = new Stack<>();

        S.push(1);
        S.push(2);
        S.push(3);
        S.push(4);

        StackTransfer.transfer(S, T);

        System.out.println("Stack T after transfer:");

        while (!T.isEmpty()) {
            System.out.println(T.pop());
        }
    }
}