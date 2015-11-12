//http://programmingcode4life.blogspot.my/2015/09/count-even-and-odd-numbers.html

import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;

public class Q4{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
            
      int cases = scan.nextInt();
      int counte=0,counto=0;
            
      for(int x=0;x<cases;x++){
         int in = scan.nextInt();
         
         int temp = (in%2 == 0)?counte++:counto++;        
      }
      
      System.out.println(counte);
      System.out.println(counto);
   }
}