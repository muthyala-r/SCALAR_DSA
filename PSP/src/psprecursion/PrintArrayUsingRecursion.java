package psprecursion;

import java.util.ArrayList;

public class PrintArrayUsingRecursion {

    public static void main(String[] args) {
       // A = [6, -2, 5, 3]  output : 6,-2,5,3

    }

    public void PrintArray(ArrayList<Integer> A) {

        print(A , 0);
        System.out.println();

    }

    public void print(ArrayList<Integer> A, int index) {

        if(index == A.size()){
            return;
        }

        System.out.print(A.get(index)+" ");
        print(A,index+1);

    }
}
