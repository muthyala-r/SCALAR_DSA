package psp;

import java.util.ArrayList;

public class SubArrayFromStartToEndIndex {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(1);
        list.add(4);
        ArrayList<Integer> result = solve(list, 2, 4);
        System.out.println(result);
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B, int C) {
        ArrayList<Integer> list = new ArrayList();

        for(int i = B;i<=C; i++){

            list.add(A.get(i));
        }
        return list;
    }
}
