/*
   Polyalphabet Subtitution
   Create by Hafiq
*/

import java.util.*;

public class PolyAlpahbetSub{
   
   private static String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   private static ArrayList<String> list = new ArrayList<String>(); 
   
   public static void main(String[] args){
      
      String text = "IHateYou";
      int period = 4;
      Period(period);
      
      System.out.println("CT:   "+alpha);
      for(int x=0;x<list.size();x++){
         System.out.println("PT"+x+":  "+list.get(x));
      }
            
      String enc = PASEncryption(text,period);
      System.out.println("\nPlaintext : "+text);
      System.out.println("Encrypted : "+enc);
      System.out.println("Decrypted : "+PASDecryption(enc,period));
   }
   
   public static void Period(int period){
      Random r = new Random();
      
      for(int x=0;x<period;x++){
         String key = "";
         for (int i = 0; i < 26;) {
             char c = (char) (r.nextInt(26) + 'A');
             if(!key.toString().contains(""+c)){
                key = key + c;
                i++;
             }
         }  
         list.add(key);    
      }
   }
   
   public static String PASEncryption(String text,int period){
      int len = text.length();
      
      String sb = "";
      
      int p = 0;
      for(int x=0;x<len;x++){
         if (p == period)
               p = 0;
               
         char g = text.charAt(x);
         
         if(Character.isUpperCase(g)){
            int get = alpha.indexOf(g);
            
            String CT = list.get(p);
            
            sb = sb + CT.charAt(get);
               
            p++;
         }
         else if(Character.isLowerCase(g)){
            int get = alpha.toLowerCase().indexOf(g);
            
            String CT = list.get(p);
            
            sb = sb + CT.toLowerCase().charAt(get);
               
            p++;
         }
         else{
            sb += g;
         }
      }
      
      return sb;
   }
   
   public static String PASDecryption(String text,int period){
      int len = text.length();
      
      String sb = "";
      
      int p = 0;
      for(int x=0;x<len;x++){
         if (p == period)
            p = 0;
         
         char g = text.charAt(x);
         if(Character.isUpperCase(g)){
            int get = list.get(p).indexOf(g);
            
            sb = sb + alpha.charAt(get);
               
            p++;
         }
         else if(Character.isLowerCase(g)){
            int get = list.get(p).toLowerCase().indexOf(g);
            
            sb = sb + alpha.toLowerCase().charAt(get);
               
            p++;
         }
         else{
            sb += g;
         }
      }
      
      return sb;
   }

}