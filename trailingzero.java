import java.util.*;
import java.math.*;

public class trailingzero{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      int cases=scan.nextInt();
      int[] num = new int[cases];
      
      for(int x=0;x<cases;x++)
         num[x] = scan.nextInt();
      
      for(int x=0;x<cases;x++){
         int count =0;                
         String sfact = ""+factorial(num[x]);
         for(int y=sfact.length();y>=0;y--)
         {
            if(!sfact.substring(y-1,y).equalsIgnoreCase("0"))
               break;
            else
               count++;
         }                  
         System.out.println("Case#"+(x+1)+": "+count);
      }
   }
   //this function for factorial number >=100
   public static BigInteger factorial(int number){
       BigInteger fact = new BigInteger("1"); 
       for ( int i = 2; i <= number; i++)
         fact = fact.multiply(BigInteger.valueOf(i));
       
       return fact;
   }
   
   
}