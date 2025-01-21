package psp;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        reverseArray(arr);
        for (int i: arr) {
            System.out.print(i+" ");
        }
        int l = 3;
        int r = 8;
        reverseSubArray(arr, l, r);
        System.out.println();
        //Arrays.stream(arr).forEach(System.out::println);
        for (int i: arr) {
            System.out.print(i+" ");
        }
        int[] arr1 = {1,2,3,4,5,6,7,8,9};
        int k = 2;
        rotateKtimes(arr1,0,k);

    }

    private static void rotateKtimes(int[] arr, int i, int k) {
        
    }

    private static void reverseSubArray(int[] arr, int l, int r) {

        while(l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    private static void reverseArray(int[] arr) {
        int l = 0;
        int r = arr.length-1;
        while(l < r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
