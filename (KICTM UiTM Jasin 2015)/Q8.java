//http://programmingcode4life.blogspot.my/2015/09/relational-operator-kictm-uitm-jasin.html

import java.util.*;
import java.lang.*;
import java.math.*;

public class Q8{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      String line = System.getProperty("line.separator");
      scan.useDelimiter(line);
      
      int cases = scan.nextInt();
            
      for(int x=0;x<cases;x++){
         String[] get = scan.next().split(" ");
         
         long val1 = Long.parseLong(get[0]);
         long val2 = Long.parseLong(get[1]);

         if(val1 < val2)
            System.out.println("<");
         else if(val1 > val2)
            System.out.println(">");
         else if(val1 == val2)
            System.out.println("=");
      }
   }
}