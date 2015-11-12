//http://programmingcode4life.blogspot.my/2015/09/the-snail-kictm-uitm-jasin-2015.html

import java.util.*;
import java.lang.*;
import java.math.*;

public class Q6{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      String line = System.getProperty("line.separator");
      scan.useDelimiter(line);
      
      int x=0;
      while (true){
         String init = scan.next();
         String [] get = init.split(" ");
         
         if(init.equals("0 0 0 0")){
            break;
         }
         
         int well = Integer.parseInt(get[0]);
         float hei = Integer.parseInt(get[1]);
         float slid = Integer.parseInt(get[2]);
         float perce = Integer.parseInt(get[3]);
         
         float total =0;
         int day= 1;
         float less = hei*(perce/100);
         while(true){
            if(day != 1){
               hei = hei-less;
            }
            total = total+hei; 
            if(total>well){
               System.out.println("success on day "+(day));
               break;
            }
            total =total - slid;
            if(total<0){
               System.out.println("failure on day "+(day));
               break;
            }
            
            day++;
         }
         x++;
      }     
   }
}