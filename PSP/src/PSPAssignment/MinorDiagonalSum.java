package PSPAssignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinorDiagonalSum {

    public static void main(String[] args) {
      /*  A = [[1, -2, -3],
      [-4, 5, -6],
      [-7, -8, 9]]
       output: -5
       */

        Scanner scanner = new Scanner(System.in);

        // Input matrix size (square matrix)
        System.out.print("Enter the size of the square matrix: ");
        int n = scanner.nextInt();

        // Creating the matrix using ArrayList
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(scanner.nextInt());
            }
            matrix.add(row);
        }
        scanner.close();
         int sum = solve(matrix);
        System.out.println("sum = " + sum);

    }

    public static int solve(final List<ArrayList<Integer>> A) {
        int n = A.size();
        int sum = 0;

        for(int i = 0; i<n;i++){
            sum += A.get(i).get(n-1-i);
        }
        return sum;
    }
}
