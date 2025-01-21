package psp;

public class PrefixSum {
    public static void main(String[] args) {
        int[] arr ={2,8,14,29,31,49,65,79,88,97};
       int[] sum = findSum(arr);
       for(int i: sum){
           System.out.print(i+" ");
       }
        System.out.println();
    }

    private static int[] findSum(int[] arr) {

        int[] ps = new int[arr.length];
         ps[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
           ps[i] = ps[i-1]+arr[i];
        }

        for (int i = 0; i < arr.length ; i++) {
            int L = 0;

            int sum = 0;
            if(L == 0) {
                sum = ps[i];
            }else {
                sum = ps[i] - ps[L];
            }
            System.out.print(sum+" ");
        }
        System.out.println();
        return ps;
    }
}
