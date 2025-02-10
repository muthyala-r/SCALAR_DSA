package psprecursion;

public class Print1toANumbersDecreaseOrder {

    public static void main(String[] args) {
        int A= 10;
        solve(A);
    }
    public static void print1toA(int A){
        if(A == 0){
            return;
        }
        System.out.print(A + " ");
        print1toA(A - 1);

    }
    public static void solve(int A) {
        print1toA(A);
        System.out.print("\n");
    }
}
