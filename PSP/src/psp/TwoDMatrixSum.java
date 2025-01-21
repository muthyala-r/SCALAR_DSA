package psp;

public class TwoDMatrixSum {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        findSumMatrix(matrix);
    }

    private static void findSumMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];

            }
            System.out.println(sum);
        }
    }
}
