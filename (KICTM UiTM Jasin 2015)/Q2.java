//http://programmingcode4life.blogspot.my/2015/09/binary-addition-kictm-uitm-jasin-2015.html

import java.util.*;
import java.lang.*;
import java.math.*;

public class Q2{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      String line = System.getProperty("line.separator");
      scan.useDelimiter(line);
      
      int cases = scan.nextInt();
      
      String [] ans = new String[cases];
      
      for(int x=0;x<cases;x++){
         String[] get = scan.next().split(" ");
         
         long val1 = Long.parseLong(get[0],2);
         long val2 = Long.parseLong(get[1],2);
         
         long sum = val1+val2;
         
         ans[x] = ""+Long.toBinaryString(sum);
      }
      
      for(int x=0;x<cases;x++){
         System.out.println((x+1)+" "+ans[x]);
      }
   }
}