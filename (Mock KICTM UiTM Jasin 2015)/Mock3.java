import java.util.*;
import java.lang.*;
import java.math.*;

//http://programmingcode4life.blogspot.my/2015/09/typo-mock-kictm-uitm-jasin-2015.html

public class Mock3{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      String line =System.getProperty("line.separator");
      scan.useDelimiter(line);
      
      String get = scan.next();
      
      String str = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
      
      String ans="";
      for(int x=0;x<get.length();x++){
         if(get.charAt(x) != ' '){
            for(int y=0;y<str.length();y++){
               if(get.charAt(x) == str.charAt(y)){
                  ans = ans +""+ str.charAt(y-1);
                  break;
               }
            }
         }
         else{
            ans = ans + " ";
         }
      }
      
      System.out.print(ans);
    
   }
}