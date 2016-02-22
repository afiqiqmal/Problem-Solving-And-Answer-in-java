import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.lang.*;
import java.util.*;

 
public class BlowfishTest {
    private static Random random = new Random((new Date()).getTime());
    
    public static void main(String[] args) throws Exception {
        String enc = encrypt("qwerty1993");
        System.out.println(enc);
        
        decrypt(enc);
    }
 
    private static String encrypt(String password) throws Exception {
        byte[] keyData = (password).getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] hasil = cipher.doFinal(password.getBytes());
        return new String(Base64.getEncoder().encode(hasil));
    }
     
    private static void decrypt(String dec) throws Exception {
        byte[] keyData = ("qwerty1993").getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] hasil = cipher.doFinal(Base64.getDecoder().decode(dec));
        System.out.println(new String(hasil));
    }
}