//http://programmingcode4life.blogspot.my/2015/09/the-block-game-mock-kictm-uitm-jasin.html

import java.util.*;
import java.lang.*;
import java.math.*;

public class Mock5{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      String line =System.getProperty("line.separator");
      scan.useDelimiter(line);
      
      int cases = scan.nextInt();
      
      for(int x=0;x<cases;x++){
         
         String [] get = scan.next().split(" ");

         System.out.println(Integer.parseInt(get[0]) % Integer.parseInt(get[1]));
         
      }
   }
}