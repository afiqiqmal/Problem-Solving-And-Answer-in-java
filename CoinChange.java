//http://programmingcode4life.blogspot.my/2015/09/count-posibble-coin-changing-problem_7.html

public class CoinChange {

 public static void main(String[] args) {
   int[] arr = {5,37,8,39,33,17,22,32,13,7,10,35,40,2,43,49,46,19,41,1,12,11,28};
   int m = (int)arr.length;
   int n = 166;
   System.out.print(" " + count(arr, m, n) + " ");
 }

public static int count(int[] s, int m, int n) {
   long x, y;

   // We need n+1 rows as the table is constructed in bottom up manner using 
   // the base case 0 value case (n = 0)
   long[][] coins = new int[n + 1][m];

   // Fill the entries for 0 value case (n = 0)
   for(int i = 0; i < m; i++) {
     coins[0][i] = 1;
   }

   // Fill rest of the table entries in bottom up manner  
   for(int i = 1; i < n + 1; i++) {
     for(int j = 0; j < m; j++) {
      // Count of solutions including S[j]
      x = i - s[j] >= 0 ? coins[i - s[j]][j] : 0;

      // Count of solutions excluding S[j]
      y = j >= 1 ? coins[i][j - 1] : 0;

      // total count
      coins[i][j] = x + y;
     }
   }
   return coins[n][m - 1];
 }
}