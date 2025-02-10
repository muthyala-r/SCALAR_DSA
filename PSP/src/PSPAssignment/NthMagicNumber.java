package PSPAssignment;

public class NthMagicNumber {
    public static void main(String[] args) {
        int A = 10;
      int magicum = getMagicNumber(A);
        System.out.println(magicum);
    }

    public static int getMagicNumber(int A) {
            int ans = 0 , power = 5;
            while(A >0){
                int r = A%2;
                A = A / 2;;
                ans += (r*power);
                power *= 5;
            }
            return ans;
        }
    }
