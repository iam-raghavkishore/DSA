import java.util.ArrayList;
import java.util.List;

public class DSAaj {
    static void printSubsets(int[] numbers, int index, List<Integer> subset) {
        if (index == numbers.length) {
            System.out.println(subset);
            return;
        }

        // Include the current element.
        subset.add(numbers[index]);
        printSubsets(numbers, index + 1, subset);

        // Undo the choice, then explore skipping the element.
        subset.remove(subset.size() - 1);
        printSubsets(numbers, index + 1, subset);
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        printSubsets(numbers, 0, new ArrayList<>());
    }
}