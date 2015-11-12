import java.util.*;
import java.lang.*;
import java.math.*;

//http://programmingcode4life.blogspot.my/2015/09/the-block-game-mock-kictm-uitm-jasin.html

public class Mock4{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      String line =System.getProperty("line.separator");
      scan.useDelimiter(line);
      
      int cases = scan.nextInt();
      
      for(int x=0;x<cases;x++){
         
         String get = scan.next();

         StringBuilder str = new StringBuilder(get);
         
         if(get.equals(str.reverse().toString()))
            System.out.println("wins");
         else
            System.out.println("loses"); 
         
      }
   }
}