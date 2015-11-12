//http://programmingcode4life.blogspot.my/2015/09/automatic-answer-kictm-uitm-jasin-2015.html

import java.util.*;

public class Q9{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      String line = System.getProperty("line.separator");
      scan.useDelimiter(line);
      
      int cases = scan.nextInt();                
      for(int x=0;x<cases;x++){
         int no = scan.nextInt();
         int total = ((((((no * 567)/9)+7492) * 235)/47)-498);
         String str = ""+total;
              
         int len= str.length();
         System.out.println(str.charAt(len-2));           
      }
   }
}