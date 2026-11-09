import java.util.Arrays;

public class DSAaa {
    public static void main(String[] args) {
        int[] first = {1, 3, 5, 7};
        int[] second = {2, 4, 6, 8, 10};
        int[] merged = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int write = 0;

        while (i < first.length && j < second.length) {
            if (first[i] <= second[j]) {
                merged[write++] = first[i++];
            } else {
                merged[write++] = second[j++];
            }
        }

        while (i < first.length) {
            merged[write++] = first[i++];
        }

        while (j < second.length) {
            merged[write++] = second[j++];
        }

        System.out.println(Arrays.toString(merged));
    }
}