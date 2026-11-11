import java.util.Arrays;
import java.util.Comparator;

public class DSAal {
    static int maxMeetings(int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(meeting -> meeting[1]));

        int count = 0;
        int lastEnd = Integer.MIN_VALUE;

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            if (start >= lastEnd) {
                count++;
                lastEnd = end;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] meetings = {
            {1, 4}, {3, 5}, {0, 6}, {5, 7}, {8, 9}, {5, 9}
        };

        System.out.println(maxMeetings(meetings));
    }
}