import java.util.*;
import java.io.*;
import java.text.*;

/**
 * Created by Hafiq Iqmal on 14/8/2016.
 * PROMED CS 2012
 */

public class LegoLandTicket{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      String line = System.getProperty("line.separator");
      scan.useDelimiter(line);
   
      int cases = scan.nextInt();
      String [] ans = new String[cases];
      
      DecimalFormat df = new DecimalFormat("RM0.00");
      
      for(int x=0;x<ans.length;x++){
         String[] split = scan.next().trim().split(" ");
         int [] org = new int[split.length];
         for(int bil=0;bil<split.length;bil++){
            org[bil] = Integer.parseInt(split[bil]);
         }
         
         float child = 0,adult = 0, senior=0;
         int c=0,a=0,s=0;
         
         for(int y=1;y<=org[0];y++){
            if(org[y]>=3 && org[y]<=11){
               child+= 110;
               c++;
            }
            else if(org[y]>=12 && org[y]<=59){
               adult += 140;
               a++;
            }
            else if(org[y]>=60){
               senior += 110;
               s++;
            }
         }
         
         int voucher = org[org.length-1];
         float pv = 0;
         if(a>=c){
            if(voucher>=c){
               pv = c * 110;
            }
            else{
               pv = voucher * 110;   
            }
         }
         else{
            pv = a * 110;
         }
         
         ans[x] = "Cases #"+(x+1)+": "+df.format((adult+child+senior) - pv);
      }
      
      for(int x=0;x<cases;x++){
         System.out.println(ans[x]);
      }
   }
}