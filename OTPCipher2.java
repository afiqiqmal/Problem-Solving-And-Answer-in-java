/*

*/
import java.util.*;

public class OTPCipher2{
                                //  A  B  C  D  E  F  G  H  I J K L M N O P Q R S  T  U  V  W  X  Y  Z
   private static Integer[] list = {25,23,21,19,17,15,13,11,9,7,5,3,1,0,2,4,6,8,10,12,14,16,18,20,22,24};
   private static String alpha =  "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   
   public static void main(String[] args){
      String text = "Conspiracy Theory";
      String key =  "UNITEDSTATE";
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
      String sb= "";
      int y =0;
      for(int x=0;x<len;x++){
         char get = text.charAt(x);
         char keyget = key.charAt(y);
         if(Character.isUpperCase(get)){
            int index = list[alpha.indexOf(get)];
            int keydex = list[alpha.indexOf(keyget)];
            
            int total = (index + keydex) % 26;
            
            sb = sb + alpha.charAt(Arrays.asList(list).indexOf(total));
            y++;
         }
         else if(Character.isLowerCase(get)){
            int index = list[alpha.toLowerCase().indexOf(get)];
            int keydex = list[alpha.indexOf(keyget)];
            
            int total = (index + keydex) % 26;
            
            sb = sb + alpha.toLowerCase().charAt(Arrays.asList(list).indexOf(total));
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
            int index = list[alpha.indexOf(get)];
            int keydex = list[alpha.indexOf(keyget)];

            int total = (index + 26) - keydex;
            total = total % 26;
            
            sb = sb + alpha.charAt(Arrays.asList(list).indexOf(total));
            y++;
         }
         else if(Character.isLowerCase(get)){
            int index = list[alpha.toLowerCase().indexOf(get)];
            int keydex = list[alpha.indexOf(keyget)];

            int total = (index + 26) - keydex;
            total = total % 26;
            
            sb = sb + alpha.toLowerCase().charAt(Arrays.asList(list).indexOf(total));
            y++;
         }
         else{
            sb = sb + get;
         }
      }
      return sb;
   }   
}