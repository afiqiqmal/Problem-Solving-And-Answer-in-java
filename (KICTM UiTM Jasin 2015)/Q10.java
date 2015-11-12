//http://programmingcode4life.blogspot.my/2015/09/jumping-mario-kictm-uitm-jasin-2015.html

import java.util.*;
import java.lang.*;
import java.math.*;

public class Q10{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      String line = System.getProperty("line.separator");
      scan.useDelimiter(line);
      
      int cases = scan.nextInt();
            
      for(int x=0;x<cases;x++){
         int getj = scan.nextInt();
         String[] get = scan.next().split(" ");
         int counth=0,countl=0;
         
         for(int y=0;y<getj-1;y++){
            if(Integer.parseInt(get[y])<Integer.parseInt(get[y+1]))
               counth++;
            else if(Integer.parseInt(get[y])>Integer.parseInt(get[y+1]))
               countl++;
         }
          System.out.println("Case "+(x+1)+": "+counth+" "+countl);
      }
   } 
}