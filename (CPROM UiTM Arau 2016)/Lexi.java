import java.util.*;


/**
   Author : Hafiq
   Date :
**/

public class Lexi{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      String line = System.getProperty("line.separator");
      scan.useDelimiter(line);
      
      int cases = scan.nextInt();
      String[] list = new String[cases];
      for(int x=0;x<cases;x++){
         list[x] = scan.next();
      }
      
      Arrays.sort(list);
      
      for(String ls:list)
         System.out.println(ls);
  }
  
}