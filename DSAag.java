import java.util.PriorityQueue;

public class DSAag {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;

        if (k < 1 || k > arr.length) {
            System.out.println("Invalid k");
            return;
        }

        PriorityQueue<Integer> largest = new PriorityQueue<>();

        for (int num : arr) {
            largest.offer(num);

            if (largest.size() > k) {
                largest.poll();
            }
        }

        System.out.println("Kth largest element: " + largest.peek());
    }
}