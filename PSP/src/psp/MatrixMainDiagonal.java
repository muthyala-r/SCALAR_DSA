package psp;

public class MatrixMainDiagonal {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        findDigonalMatrix(matrix);
    }

    private static void findDigonalMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[i][i]);
        }
    }
}
