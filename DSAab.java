public class DSAab {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        if (k <= 0 || k > arr.length) {
            System.out.println("Invalid window size");
            return;
        }

        long windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        long maxSum = windowSum;

        for (int right = k; right < arr.length; right++) {
            windowSum += arr[right];
            windowSum -= arr[right - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        System.out.println("Maximum window sum: " + maxSum);
    }
}