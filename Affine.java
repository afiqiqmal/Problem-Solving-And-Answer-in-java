import java.util.*;
import java.lang.*;
import java.math.*;

public class Affine{
   public static void main(String[] args) {
       String input = "TWENTYFIFTEEN";
       int x = 17;
       int y = 20;
       String enc = encrypt(input,x,y);
       String dec = decrypt(enc,x,y);
       System.out.println("Input:     " + input);
       System.out.println("Decrypted: " + enc);
       System.out.println("Decrypted: " + dec);
   }
   
   public static String encrypt(String input,int FK,int SK) {
       String str = "";
       for (int in = 0; in < input.length(); in++) {
           char get = input.charAt(in);
           if (Character.isLetter(get)) {
               // ax + b % 26
               get = (char) ((FK * (int)(get + 'A') + SK) % 26 + 'A');
           }
           str +=get;
       }
       return str;
   }
   
   public static String decrypt(String input,int FK,int SK) {
       String str = "";
       int x = 0;
       int inverse = 0;
       
       // find 1 by using modular inverse
       // 17 * IN mod 26 == 1
       // IN is 0 - infiniti
       // if total == 1, then IN is the inverse modular
       while(true){
         inverse = FK * x % 26;
            if(inverse == 1)
               break;
         x++;
       }
       
       for (int in = 0; in < input.length(); in++) {
           char get = input.charAt(in);
           if (Character.isLetter(get)) {
               // IN *(x-b) mod 26
               get = (char)(x * ((get + 'A') - SK) % 26 + 'A');
           }
           str +=get;
       }
       return str;
   }
}