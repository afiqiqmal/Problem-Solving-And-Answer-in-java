//http://programmingcode4life.blogspot.my/2015/09/division-of-nlogonia-kictm-uitm-jasin.html

import java.util.*;
import java.lang.*;
import java.math.*;

public class Q7{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      String line = System.getProperty("line.separator");
      scan.useDelimiter(line);
  
      while(true){         
         int cases = scan.nextInt(); 
         if(cases == 0)
            break;
          
         String[] coor = scan.next().split(" ");
         int coorx = Integer.parseInt(coor[0]);
         int coory = Integer.parseInt(coor[1]);
         
         String[] input = new String[cases];
         for(int x=0;x<cases;x++){
            input[x] = scan.next();
               
            String[] get = input[x].split(" ");
            
            int getx = Integer.parseInt(get[0]);
            int gety = Integer.parseInt(get[1]);
            
            int totalx = getx-coorx;
            int totaly = gety-coory;
                        
            if(totalx == 0 || totaly == 0)
               System.out.println("divisa");
            else if(totalx >0 && totaly >0)
               System.out.println("NE");
            else if(totalx <0 && totaly >0)
               System.out.println("NO");
            else if(totalx <0 && totaly <0)
               System.out.println("SO");
            else if(totalx >0 && totaly <0)
               System.out.println("SE");
         }
      }
   }
}