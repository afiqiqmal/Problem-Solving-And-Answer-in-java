import java.util.*;

public class CountOne{
   public static void main(String[] args){  
      int n=20;
      long i = 0, j = 1;
      long count = 0;
      for (i = 1; i <= n; i ++)
      {
          j = i;
          while (j != 0)
          {
              if (j % 10 == 1)
                  count ++;
              j /= 10;
          }
      }
      System.out.print(count); 
   }
}