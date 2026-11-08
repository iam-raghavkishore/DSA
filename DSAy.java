//Find the product of array except self
public class DSAy {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};

        int n = arr.length;

        int[] result = new int[n];

        int prefix = 1;

        for (int i = 0; i < n; i++) {

            result[i] = prefix;

            prefix *= arr[i];
        }

        int suffix = 1;

        for (int i = n - 1; i >= 0; i--) {

            result[i] *= suffix;

            suffix *= arr[i];
        }

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}