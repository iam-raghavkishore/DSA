public class DSAae {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,  4,  7, 11},
            {2,  5,  8, 12},
            {3,  6,  9, 16},
            {10, 13, 14, 17}
        };
        int target = 9;

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            int value = matrix[row][col];

            if (value == target) {
                System.out.println("Found at row " + row + ", column " + col);
                return;
            }

            if (value > target) {
                col--;
            } else {
                row++;
            }
        }

        System.out.println("Target not found");
    }
}