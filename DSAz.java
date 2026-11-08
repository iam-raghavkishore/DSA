// Find the longest consecutive sequence
import java.util.HashSet;
import java.util.Set;

public class DSAz {
    public static void main(String[] args) {

        int[] arr = {100, 4, 200, 1, 3, 2};

        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {

            if (!set.contains(num - 1)) {

                int current = num;
                int count = 1;

                while (set.contains(current + 1)) {

                    current++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        System.out.println("Longest consecutive sequence: "
                           + longest);
    }
}