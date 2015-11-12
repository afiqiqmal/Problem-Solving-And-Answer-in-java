import java.io.*;
import java.security.*;

//http://programmingcode4life.blogspot.my/2015/09/password-hash-with-sha-1-and-file.html#more

public class HashFileTest {
     
    public static void main(String[] args){
        boolean result = verifyChecksum("/Downloads/Iso/kali-linux-2.0-amd64.iso", "aaeb89a78f155377282f81a785aa1b38ee5f8ba0");
        System.out.println("File's checksum matches the expected one? " + result);
    
    } 
    public static boolean verifyChecksum(String file, String checksum)
    {
        String shaHash = "";
        try{
           System.out.println("Verifying File..'"+file+"'");
           System.out.println("Please Wait..");
           
           MessageDigest sha1 = MessageDigest.getInstance("SHA1");
           FileInputStream fis = new FileInputStream(file);
            
           byte[] data = new byte[1024];
           int read = 0; 
           while ((read = fis.read(data)) != -1) {
               sha1.update(data, 0, read);
           }
           byte[] Bytes = sha1.digest();
     
           StringBuffer shasum = new StringBuffer();
           for (int i = 0; i < Bytes.length; i++) {
              shasum.append(Integer.toString((Bytes[i] & 0xff) + 0x100, 16).substring(1));
           }
            
           shaHash = shasum.toString();
        }
        catch(IOException | NoSuchAlgorithmException e){
           e.printStackTrace();   
        }
        
        return shaHash.equals(checksum);
    }
 
 
}