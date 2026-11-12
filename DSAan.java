public class DSAan {
    static int findSingleNumber(int[] numbers) {
        int result = 0;

        for (int number : numbers) {
            result ^= number;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1, 2};
        System.out.println(findSingleNumber(numbers));
    }
}