import java.util.HashMap;
import java.util.Map;

public class DSAac {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 1, 3, 2};
        long target = 3;

        Map<Long, Integer> frequency = new HashMap<>();
        frequency.put(0L, 1);

        long prefixSum = 0;
        long count = 0;

        for (int num : arr) {
            prefixSum += num;
            count += frequency.getOrDefault(prefixSum - target, 0);

            int previousCount = frequency.getOrDefault(prefixSum, 0);
            frequency.put(prefixSum, previousCount + 1);
        }

        System.out.println("Matching subarrays: " + count);
    }
}