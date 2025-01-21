package PSPAssignment;

import java.util.ArrayList;

public class Isalnum {

    public static void main(String[] args) {

       // A = ['S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0'] output; 1
        //A = ['S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0'] : output : 0
    }

    public static int solve(ArrayList<Character> A) {


        int n = A.size();
        for(int i = 0; i < n; i++) {
            char c = A.get(i);
            if((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                continue;
            }
            return 0;
        }
        return 1;
    }
}
