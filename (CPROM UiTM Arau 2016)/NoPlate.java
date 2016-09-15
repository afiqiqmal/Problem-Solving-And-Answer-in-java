import java.util.*;


/**
   Author : Hafiq
   Date :
**/

public class NoPlate{

   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      String in = scan.next();
      
      String[] split = in.split("(?<=\\D)(?=\\d)");
      
      int num = Integer.parseInt(split[1]);
      boolean tukar = false;
      String cur = split[0];
      
      for(int x=0;x<5;x++){
         num += 1;
         if(num > 9999){
            num = 1;
            tukar = true;
         }
         else
            tukar = false;
         
         int count = 0;   
         if(tukar){
            int z=0;
            while(true){
               if(cur.equals(plateStr(z))){
                  count = z;
                  break;
               }
               z++;
            }
            
            cur = plateStr(count+1);
         }
         
         System.out.println(cur+""+num);        
      }
   }
   
   static String plateStr(int x) {
      return x < 0?"":plateStr((x / 26) - 1) + (char)(65 + x % 26);
   }
   
   
   //ZZ9997
   //ZZ9998
   //ZZ9999
   //AAA1
   //AAA2
}