import java.util.*;
import java.lang.*;
import java.math.*;
//http://programmingcode4life.blogspot.my/2015/09/caesar-cipher.html
public class Cipher {
    public static void main(String[] args) {
 
        String str = "Programming Code For Life. Think Twice Code Once.";
        int shift = 5;

        System.out.println("ORIGINAL STRING: "+str);
        
        String r_encode_str = rightEncode(str,shift);
        System.out.println("\nRIGHT SHIFT ENCRYPT: "+r_encode_str);
        
        String l_decode_str = leftDecode(r_encode_str,shift);
        System.out.println("DECRYPT: "+l_decode_str);
        
        String l_encode_str = leftEncode(str,shift);
        System.out.println("\nLEFT SHIFT ENCRYPT: "+l_encode_str);  
        
        String r_decode_str = rightDecode(l_encode_str,shift);
        System.out.println("DECRYPT: "+r_decode_str);
        
        
        System.out.println("\nDECRYPTION WITHOUT KEY. ASSUME MAX KEY IS 26");
        System.out.println("-LEFT SHIFT DECRYPT FIRST-");
        for(int x=1;x<26;x++){
            System.out.println(x+". "+leftDecode(r_encode_str,x));
        }
        System.out.println("\n-RIGHT SHIFT DECRYPT-");
        for(int x=1;x<26;x++){
            System.out.println(x+". "+rightDecode(l_encode_str,x));
        }
                
    }
 
    public static String leftEncode(String enc, int offset) {
        return rightEncode(enc, 26-offset);
    }
 
    public static String rightEncode(String enc, int offset) {
        offset = offset % 26 + 26;
        StringBuilder encoded = new StringBuilder();
        
        for (char i : enc.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    encoded.append((char) ('A' + (i - 'A' + offset) % 26 ));
                } else {
                    encoded.append((char) ('a' + (i - 'a' + offset) % 26 ));
                }
            } else {
                encoded.append(i);
            }
        }
        return encoded.toString();
    }
    
     public static String leftDecode(String enc,int offset){
         return rightDecode(enc, 26-offset);
     }
     
     public static String rightDecode(String enc,int offset){
         offset = offset % 26 + 26;
         StringBuilder encoded = new StringBuilder();
         
         for (char i : enc.toCharArray()) {
             if (Character.isLetter(i)) {
                 if (Character.isUpperCase(i)) {
                     encoded.append((char) ('A' + (i - 'A' + offset) % 26 ));
                 } else {
                     encoded.append((char) ('a' + (i - 'a' + offset) % 26 ));
                 }
             } else {
                 encoded.append(i);
             }
         }
         return encoded.toString(); 
     }
}