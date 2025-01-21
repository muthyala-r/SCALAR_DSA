package psp;

import java.util.ArrayList;
import java.util.List;

public class BestTimeToBuyStock {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(2);
        list.add(4);

        int result = maxProfit(list);
        System.out.println(result);

    }
    public static int maxProfit(final List<Integer> A) {

        int minPrice= Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price : A){

            minPrice = Math.min(minPrice ,price);


            int profit = price - minPrice;

            maxProfit = Math.max(maxProfit,profit);
        }
        return maxProfit;
    }

}
