package psp;

public class CarryForwardTechnique {

    public static void main(String[] args) {
        String str = "ABCGAG";
        Long l = solve(str);
        System.out.println(l);
    }

    public static Long solve(String A) {

        char[] ch =  A.toCharArray();
        long carryforwardcount = 0;
        long count = 0;

        for(int i = 0; i < ch.length;i++){

            if(ch[i] == 'A'){
                carryforwardcount++;
            }
            if(ch[i] == 'G'){
                count += carryforwardcount;
            }

        }
        return Long.valueOf(count);
    }

}
