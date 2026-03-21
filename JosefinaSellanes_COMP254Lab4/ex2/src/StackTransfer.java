import java.util.Stack;

public class StackTransfer {

    public static <E> void transfer(Stack<E> S, Stack<E> T) {

        while (!S.isEmpty()) {
            T.push(S.pop());
        }
    }
}
