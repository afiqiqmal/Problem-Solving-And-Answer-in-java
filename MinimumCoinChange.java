/*
possible sum:
1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1
2+2+2+2+2+2+2+2+2+2+1
2+2+2+2+2+5+5+1
10+5+2+2+1+1
5+5+5+5+1
10+5+5+1
10+10+1
20+1 <--- minimum coins
*/
public class MinimumCoinChange {
    public static void main(String[] args) {
        int n = 21;
        int[] sets = new int[] {
            1, 2, 5, 10, 20, 50, 100
        };
        int sum = 0;

        while (n > 0) {
            int max = sets[0];

            //find list of minumum coin change (unsort coins list)
            //for (int x = 0; x < sets.length; x++) {
            //    if (sets[x] >= max && sets[x] <= n)
            //        max = sets[x];
            //}

            //find list of minumum coin change (sorted coins list)
            for (int x = sets.length - 1; x >= 0; x--) {
                if (sets[x] <= n) {
                    max = sets[x];
                    break;
                }
            }

            System.out.println(max);
            n = n - max;
        }
    }
}