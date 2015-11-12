import java.util.*;
public class CountCircle
{
   public static void main(String args[])
   {
      int n =900082;
      int count = 0;
      //0,1,2,3,4,5,6,7,8,9
      int x[] = {1, 0, 0, 0, 0, 0, 1, 0, 2, 1};
      while (n > 0) {
          count += x[n % 10];
          n /= 10;
      }
      System.out.print(count);
   }
}