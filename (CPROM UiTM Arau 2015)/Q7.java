//http://programmingcode4life.blogspot.my/2015/09/analogous-issues-cprom-uitm-arau.html

import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;

public class Q7{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      String line =System.getProperty("line.separator");
      scan.useDelimiter(line);      
      
      String[] samples = scan.next().split("::");
      String str = scan.next();
      
      int[] arrange = new int[str.length()];
      
      String fstpermu = samples[0];
      String secpermu = samples[1];
      for(int x=0;x<fstpermu.length();x++){
         arrange[x] = secpermu.indexOf(fstpermu.charAt(x));
      }            
      
      String rearrange = "";
      for(int x=0;x<arrange.length;x++){
         for(int y=0;y<arrange.length;y++){
            if(x == arrange[y])
               rearrange = rearrange + str.charAt(y);
         }
      }
      
      System.out.println(rearrange);

   }
}