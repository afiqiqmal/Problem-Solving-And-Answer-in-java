//http://programmingcode4life.blogspot.my/2015/09/comparing-currency-exchanges-cprom-uitm.html

import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;

public class Q1{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      String line =System.getProperty("line.separator");
      scan.useDelimiter(line);
            
      int cases = scan.nextInt();
      
      String [] ans = new String[cases];
      
      DecimalFormat df = new DecimalFormat("0.00");
      
      for(int x=0;x<cases;x++){
         String[] get = scan.next().split(" ");
         
         double amount = Integer.parseInt(get[0]);
         double cr1 = Double.parseDouble(get[1]);
         double cr1p = Double.parseDouble(get[2]);
         double cr2 = Double.parseDouble(get[3]);
         double cr2p = Double.parseDouble(get[4]);
         
         double totalc1 = (amount*cr1) - ((amount*cr1)*(cr1p/100));
         double totalc2 = (amount*cr2) - ((amount*cr2)*(cr2p/100));
                  
         double diff = Math.abs(totalc1-totalc2); 
         
         int best=0;double bestc=0;
         if(totalc1<totalc2){
            best=2;
            bestc = totalc2;
         }
         else{
            best=1;
            bestc = totalc1;
         }
         
         ans[x] = best+" is the best;"+df.format(bestc)+" dollars;difference is "+df.format(diff);
         
      }
      
      for(int x=0;x<cases;x++){
         System.out.println(ans[x]);
      }
   }
}