//http://programmingcode4life.blogspot.my/

//Kamasutra cipher
import java.util.*;

public class KSCipher{
   public static void main(String[] args){
      String text = "KAMA SUTRA CIPHER";
      String key  = RandomAlphaNoDuplicate(26);
      
      String enc = KSutra(text,key);
      System.out.println("Encryption: "+ enc);
      String dec = KSutra(enc,key);
      System.out.println("Decryption: "+ dec);
   }
   
   public static String RandomAlphaNoDuplicate(int len){
      Random r = new Random();
      String key = "";
      for (int i = 0; i < len;) {
          char c = (char) (r.nextInt(26) + 'A');
          if(!key.toString().contains(""+c)){
             key = key + c;
             i++;
          }
      }      
      return key;
   }
   
   public static String KSutra(String text,String key){
      int keyLen = key.length()/2;
      
      // arrange random key
      char[][] keyRow = new char[2][keyLen];
      int count=0;
      for(int x=0;x<2;x++){
         for(int y=0;y<keyLen;y++){
            keyRow[x][y] = key.charAt(count);
            System.out.print(keyRow[x][y]+" ");
            count++;
         }
         System.out.println();
      }
      
      String sb = "";
      
      count=0;
      for(int x=0;x<text.length();x++){
         for(int y=0;y<2;y++){
            for(int z=0;z<keyLen;z++){
               if(y == 0){
                  if(text.charAt(x) == keyRow[y][z])
                     sb += keyRow[y+1][z];
               }
               else if (y == 1){
                  if(text.charAt(x) == keyRow[y][z])
                     sb += keyRow[y-1][z];
               }
            }
         }
         if(text.charAt(x) == ' ')
            sb += text.charAt(x);
      }
      
      return sb;
   }
}