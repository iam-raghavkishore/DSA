import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DSAaf {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25, 7};
        int[] result = new int[arr.length];
        Arrays.fill(result, -1);

        Deque<Integer> pending = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            while (!pending.isEmpty() && arr[i] > arr[pending.peek()]) {
                int previousIndex = pending.pop();
                result[previousIndex] = arr[i];
            }

            pending.push(i);
        }

        System.out.println(Arrays.toString(result));
    }
}