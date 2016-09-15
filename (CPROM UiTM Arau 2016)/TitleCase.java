import java.util.*;


/**
   Author : Hafiq
   Date :
**/

public class TitleCase{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      String line = System.getProperty("line.separator");
      scan.useDelimiter(line);
      int cases = scan.nextInt();
      
      for(int x=0;x<cases;x++){
         String[] split = scan.next().split(" ");
         
         String temp = "";
         for(int y=0;y<split.length;y++){
            temp += (""+split[y].charAt(0)).toUpperCase() + split[y].substring(1,split[y].length());
            if(y<=split.length-1){
               temp+=" ";
            }
         }
         
         System.out.println(temp);
      }
   
   }
}