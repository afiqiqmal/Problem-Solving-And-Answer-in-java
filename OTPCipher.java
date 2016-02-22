/*
   modified by hafiq
   One time pad cipher and decrypt
   any expert can advise me to improve this code...tq..
*/
import java.util.*;

public class OTPCipher{
   private static String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   public static void main(String[] args){
      String text = "REPEAT ATTACK Tonight";
      String key = RandomAlpha(3);
      String k = "";
      int len = text.length();
      if(key.length()<len){
         int count = 0;
         for(int x=0;x<len;x++){  
            if(count == key.length()) 
               count = 0;
               
            k = k+key.charAt(count);
            count++;
         }
         key = k;
      }
      key = key.toUpperCase();
      String enc = OTPEncryption(text,key);
      System.out.println("Plaintext : "+text);
      System.out.println("Encrypted : "+enc);
      System.out.println("Decrypted : "+OTPDecryption(enc,key));
   }
   
   public static String RandomAlpha(int len){
      Random r = new Random();
      String key = "";
      for(int x=0;x<len;x++)
         key = key + (char) (r.nextInt(26) + 'A');
      return key;
   }
   
   public static String OTPEncryption(String text,String key){
      
      
      int len = text.length();

      String sb = "";
      int y=0;
      for(int x=0;x<len;x++){
         char get = text.charAt(x);
         char keyget = key.charAt(y);
         if(Character.isUpperCase(get)){
            int index = alpha.indexOf(get);
            int keydex = alpha.indexOf(keyget);
            
            int total = (index + keydex) % 26;
            
            sb = sb+ alpha.charAt(total);
            y++;
         }
         else if(Character.isLowerCase(get)){
            int index = alpha.toLowerCase().indexOf(get);
            int keydex = alpha.indexOf(keyget);
            
            int total = (index + keydex) % 26;
            
            sb = sb+ alpha.toLowerCase().charAt(total);
            y++;
         }
         else{
            sb = sb + get;
         }
      }
      
      return sb;
   }
   public static String OTPDecryption(String text,String key){
      
      int len = text.length();
      
      String sb = "";
      int y=0;
      for(int x=0;x<len;x++){
         char get = text.charAt(x);
         char keyget = key.charAt(y);
         if(Character.isUpperCase(get)){
            int index = alpha.indexOf(get);
            int keydex = alpha.indexOf(keyget);

            int total = (index - keydex) % 26;
            total = (total<0)? total + 26 : total;
            
            sb = sb+ alpha.charAt(total);
            y++;
         }
         else if(Character.isLowerCase(get)){
            int index = alpha.toLowerCase().indexOf(get);
            int keydex = alpha.indexOf(keyget);
            
            int total = (index - keydex) % 26;
            total = (total<0)? total + 26 : total;
            
            sb = sb+ alpha.toLowerCase().charAt(total);
            y++;
         }
         else{
            sb = sb + get;
         }
      }
      
      return sb;
   }
   
}