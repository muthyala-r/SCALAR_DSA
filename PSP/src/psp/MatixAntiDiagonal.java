package psp;

public class MatixAntiDiagonal {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        findAntiDigonalMatrix(matrix);
    }

    private static void findAntiDigonalMatrix(int[][] matrix) {

        int row = 0;
        int col = matrix.length-1;
        while(row < matrix.length && col >=0){
            System.out.println(matrix[row][col]);
            row++;
            col--;
        }
    }
}
