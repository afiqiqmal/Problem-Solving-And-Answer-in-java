import java.util.*;


/**
   Author : Hafiq
   Date :
**/

public class Encryption{

   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      String input = scan.nextLine();
      
      String temp = "";
      int count = 1;
      for(int x=0;x<input.length();x++){
         char a = input.charAt(x);
         
         if(a == ' '){
            temp += (char)(a+count);
            count++;
         }
         else{
            temp += (char)(a+2);
         }
      }
      
      System.out.println(temp);
   
   }
}