package PSPAssignment;

public class LengthOfLongestConsecutives {

    public static void main(String[] args) {
       String A = "111000";
       int count =solve(A);
        System.out.println(count);


    }

        public static int solve(String A) {

            int ones = 0;
            char[] ch = A.toCharArray();
            int n = A.length();

            for(int i =0; i<n;i++){
                if(ch[i]=='1'){
                    ones++;
                }
            }
            if(ones == n){
                return n;
            }
            int maxones = 0;
            for(int i =0; i<n;i++){

                if(ch[i]== '0'){
                    int l =0, j=i-1;

                    while(j>=0 && ch[j] == '1'){
                        l++;
                        j--;
                    }
                    int r =0;
                    j = i+1;

                    while(j<n && ch[j]== '1'){
                        r++;
                        j++;
                    }

                    if(l+r < ones){
                        maxones = Math.max(maxones, l+r+1);
                    }else{
                        maxones = Math.max(maxones, l+r);
                    }


                }

            }
            return maxones;


        }


}
