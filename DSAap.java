import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DSAap {
    static List<Integer> findCourseOrder(int courseCount, int[][] prerequisites) {
        List<List<Integer>> dependents = new ArrayList<>();
        int[] remainingPrerequisites = new int[courseCount];

        for (int course = 0; course < courseCount; course++) {
            dependents.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int prerequisite = pair[0];
            int course = pair[1];

            dependents.get(prerequisite).add(course);
            remainingPrerequisites[course]++;
        }

        Queue<Integer> ready = new ArrayDeque<>();

        for (int course = 0; course < courseCount; course++) {
            if (remainingPrerequisites[course] == 0) {
                ready.offer(course);
            }
        }

        List<Integer> order = new ArrayList<>();

        while (!ready.isEmpty()) {
            int completed = ready.remove();
            order.add(completed);

            for (int course : dependents.get(completed)) {
                remainingPrerequisites[course]--;

                if (remainingPrerequisites[course] == 0) {
                    ready.offer(course);
                }
            }
        }

        return order;
    }

    public static void main(String[] args) {
        int courseCount = 4;
        int[][] prerequisites = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};

        List<Integer> order = findCourseOrder(courseCount, prerequisites);

        if (order.size() == courseCount) {
            System.out.println(order);
        } else {
            System.out.println("A prerequisite cycle prevents a complete order.");
        }
    }
}