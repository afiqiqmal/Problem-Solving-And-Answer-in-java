import java.util.*;

/**
   Author : Hafiq
   Date :
**/

public class HexaDec{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      String line = System.getProperty("line.separator");
      scan.useDelimiter(line);
      
      int cases = scan.nextInt();
      
      for(int x=0;x<cases;x++){
         String[] split = scan.next().split(" ");
         
         int one = Integer.parseInt(split[0],16);
         int two = Integer.parseInt(split[1],16);
         
         System.out.println(Integer.toHexString(one+two).toUpperCase());
  
      }
      
   }
}