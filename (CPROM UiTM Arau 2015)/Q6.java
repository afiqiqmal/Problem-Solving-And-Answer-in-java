//http://programmingcode4life.blogspot.my/2015/09/counting-pixels.html
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;

public class Q6{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      String line =System.getProperty("line.separator");
      scan.useDelimiter(line);      
      int cases = scan.nextInt();
            
      for(int x=0;x<cases;x++){
         String [] get = scan.next().split(" ");
         
         int B = Integer.parseInt(get[0]);
         int M = Integer.parseInt(get[1]);
         int N = Integer.parseInt(get[2]);
         
         System.out.println(((B-2)*M*(N+1))+((M+1)*((B*N)-(N-1))));       
      }

   }
}