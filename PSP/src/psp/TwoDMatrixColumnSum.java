package psp;

public class TwoDMatrixColumnSum {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        findColSumMatrix(matrix);
    }

    private static void findColSumMatrix(int[][] matrix) {

        for (int col = 0;  col<matrix[0].length ; col++) {
            int sum = 0;
            for (int row = 0; row < matrix.length; row++) {
                sum += matrix[row][col];
            }
            System.out.println(sum);
        }
    }
}
