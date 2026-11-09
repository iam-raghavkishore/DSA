import java.util.ArrayDeque;
import java.util.Deque;

public class DSAad {
    static boolean isBalanced(String text) {
        Deque<Character> expected = new ArrayDeque<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            switch (ch) {
                case '(' -> expected.push(')');
                case '[' -> expected.push(']');
                case '{' -> expected.push('}');
                case ')', ']', '}' -> {
                    if (expected.isEmpty() || expected.pop() != ch) {
                        return false;
                    }
                }
                default -> {
                    return false;
                }
            }
        }

        return expected.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced("([)]"));
    }
}