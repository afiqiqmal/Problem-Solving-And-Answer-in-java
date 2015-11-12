import java.security.*;

public class MD5
{
    public static void main(String[] args)
    {
        String passwordToHash = "HELLOWORLD";
        StringBuilder sb = new StringBuilder();
        try {
           MessageDigest md = MessageDigest.getInstance("MD5");
           md.update(passwordToHash.getBytes());
           byte[] bytes = md.digest();
           for(int x=0; x< bytes.length ;x++){
               sb.append(String.format("%02x", bytes[x]));
           }
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        System.out.println(sb.toString());
    }
}