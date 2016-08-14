import java.io.*;
import java.util.*;

/**
 * Created by Hafiq Iqmal on 14/8/2016.
 * PROMED CS 2012
 */

public class StructureWord{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      String line = System.getProperty("line.separator");
      scan.useDelimiter(line);
      
      int cases = scan.nextInt();
      String [] ans = new String[cases];
      
      for(int x=0;x<cases;x++){
         String[] word = scan.next().split(" ");
         
         if(getStructure(word[0]).equals(getStructure(word[1]))){
            ans[x] = "Case #"+(x+1)+": same";
         }
         else{
            ans[x] = "Case #"+(x+1)+": different";

         }
      }
      
      for(int x=0;x<cases;x++){
         System.out.println(ans[x]);
      }
   }
   
   private static String getStructure(String word){
      String v = "aeiouAEIOU";
      String s = "";
      for(int x=0;x<word.length();x++){
         if(v.contains(word.charAt(x)+"")){
            s +="v";
         }
         else{
            s +="c";
         }
      }
      
      return s;
   }
}