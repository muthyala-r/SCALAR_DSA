package psprecursion;

public class Pring1toNDecAndIncOrder {

    public static void main(String[] args) {
        int A= 10;
        DecThenInc(A);
    }
    public static void DecThenInc(int A) {
        print1toADec(A);
        print1toAInc(A);
        System.out.print("\n");
    }

    public static  void print1toAInc(int A){
        if(A == 0){
            return;
        }
        print1toAInc(A - 1);
        System.out.print(A + " ");
    }

    public static void print1toADec(int A){
        if(A == 0){
            return;
        }
        System.out.print(A + " ");
        print1toADec(A - 1);

    }
}
