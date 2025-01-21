package psp;

public class Matrixtranspose {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        findTransposeMatrix(matrix);

        for (int i = 0; i <matrix.length ; i++) {
            for (int j: matrix[i]) {
                System.out.print(j+" ");
            }
            System.out.println();

        }
    }

    private static void findTransposeMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {

            for (int col = row+1; col < matrix[row].length; col++) {
                 int temp = matrix[row][col];
                 matrix[row][col] = matrix[col][row];
                 matrix[col][row] = temp;
            }


        }
    }

    private static void swap(int[][] matrix,int element1, int element2) {

        int temp = matrix[element1][element2];;
        matrix[element1][element2] = matrix[element2][element1];
        matrix[element2][element1] = temp;
    }
}
