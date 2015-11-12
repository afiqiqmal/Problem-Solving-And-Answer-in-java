//http://programmingcode4life.blogspot.my/2015/09/count-posibble-coin-changing-problem.html

import java.util.Scanner;
public class PossibleCoinChange{

    public static void main(String []args){
        int [] sets = new int[]{1,2,5,10,20,50,100};
        int amount = 21;
        System.out.println(findCount(amount,sets,0));
    }

    public static int findCount(int amount, int coins[], int Index) {
        if (amount == 0)
            return 1;
        else if (amount < 0 || coins.length ==Index)
            return 0;
        else {
            int firstCoin = findCount(amount-coins[Index], coins, Index);
            int nextCoin = findCount(amount, coins, Index+1);
            return firstCoin + nextCoin;
        }
    }
}