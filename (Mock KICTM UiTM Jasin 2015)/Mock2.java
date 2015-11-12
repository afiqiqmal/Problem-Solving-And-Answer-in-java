import java.util.*;
import java.lang.*;
import java.math.*;

//http://programmingcode4life.blogspot.my/2015/09/no-brainer-mock-kictm-uitm-jasin-2015.html

public class Mock2{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      String line =System.getProperty("line.separator");
      scan.useDelimiter(line);
      
      int cases = scan.nextInt();
      
      for(int x=0;x<cases;x++){
         
         String [] get = scan.next().split(" ");
         
         if(Integer.parseInt(get[0]) < Integer.parseInt(get[1]))
            System.out.println("NO BRAINS");
         else
            System.out.println("MMM BRAINS");
         
      }
   }
}