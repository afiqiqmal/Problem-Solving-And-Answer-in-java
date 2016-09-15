import java.util.*;


/**
   Author : Hafiq
   Date :
**/

public class multiplicationTable{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      int input = scan.nextInt();
      for(int x=1;x<=12;x++){
         System.out.println(x+"*"+input+"="+(x*input));
      }
   }
}