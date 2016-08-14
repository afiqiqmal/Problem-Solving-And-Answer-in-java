import java.util.*;
import java.io.*;

/**
 * Created by Hafiq Iqmal on 14/8/2016.
 * PROMED CS 2012
 */

public class DashPattern{

   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      String line = System.getProperty("line.separator");
      scan.useDelimiter(line);
   
      int cases = scan.nextInt();
      String [] ans = new String[cases];
      
      for(int x=0;x<cases;x++){
         String[] split = scan.next().split("\\s+");
         
         String tiang = "|";
         String draw = "";
         
         int[] num = new int[split.length];
         
         for(int z=0;z<split.length;z++){
            num[z] = Integer.parseInt(split[z]);
         }
         
         int len = num[0];
         
         int current = 0;
         boolean selang = true;
         
         while(current < len){
            for(int y=1;y<num.length;y++){
                  for(int index=0;index<num[y];index++){
                     if (current < len){
                        if(y%2 == 1)
                           draw += "_";
                        else
                           draw += " ";
                     }
                     else{
                        break;
                     }
                     current ++;
                  }
                                
               selang = (selang)?false:true;
            }
         }
         
         ans[x] = "Case #"+(x+1)+": "+tiang+draw+tiang;
      }
      
      for(int x=0;x<cases;x++){
         System.out.println(ans[x]);
      }
      
   }

}