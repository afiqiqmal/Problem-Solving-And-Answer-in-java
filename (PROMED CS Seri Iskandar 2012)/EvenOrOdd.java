import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Created by Hafiq Iqmal on 14/8/2016.
 * PROMED CS 2012
 */

public class EvenOrOdd{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      String line = System.getProperty("line.separator");
      scan.useDelimiter(line);
      
      int cases = scan.nextInt();
      String [] ans = new String[cases];
      
      for(int x=0;x<cases;x++){
         int num = scan.nextInt();
         
         int cube = num * num * num;
         boolean even = false;
         boolean odd = false;
         
         while(cube > 0){
            if(((cube % 10) % 2 == 0)){
               even = true;
            }
            else{
               odd = true;
            }
            
            cube /= 10;            
         }
         
                  
         if(even && !odd){
            ans[x] = "Case #"+(x+1)+": EVEN";
         }
         else if(!even && odd){
            ans[x] = "Case #"+(x+1)+": ODD";
         }
         else{
            ans[x] = "Case #"+(x+1)+": MIXED";
         }
      }
      
      for(int x=0;x<cases;x++){
         System.out.println(ans[x]);
      }
   }
}