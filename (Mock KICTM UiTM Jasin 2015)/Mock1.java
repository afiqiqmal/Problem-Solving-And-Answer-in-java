import java.util.*;
import java.lang.*;
import java.math.*;

//http://programmingcode4life.blogspot.my/2015/09/sum-it-up-mock-kictm-uitm-jasin-2015.html

public class Mock1{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      String line =System.getProperty("line.separator");
      scan.useDelimiter(line);
      
      int cases = scan.nextInt();
      
      for(int x=0;x<cases;x++){
         
         String [] get = scan.next().split(" ");
         
         int total=0;
         for(int y=1;y<get.length;y++){
            total = total + Integer.parseInt(get[y]);
         }
         
         System.out.println(total);
         
      }
   }
}