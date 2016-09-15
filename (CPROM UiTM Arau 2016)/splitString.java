import java.util.*;


/**
   Author : Hafiq
   Date :
**/

public class splitString{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      String[] input = scan.nextLine().split("[\\s@&.;$?+-]+");
      System.out.println("Substrings length:"+input.length);
      for(int x=0;x<input.length;x++){
         System.out.println("Str["+x+"]"+input[x]+" Length:"+input[x].length());
      }
   }
}