import java.util.regex.Pattern;
import java.io.*;
import java.lang.*;
import java.text.*;
import java.net.*;

public class IPValidationPattern {
    private static final Pattern IPV4_PATTERN = 
        Pattern.compile(
                "^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

    private static final Pattern IPV6_STD_PATTERN = 
        Pattern.compile(
                "^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");

    private static final Pattern IPV6_HEX_COMPRESSED_PATTERN = 
        Pattern.compile(
                "^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    public static boolean isIPv4Address(final String input) {
        return IPV4_PATTERN.matcher(input).matches();
    }

    public static boolean isIPv6StdAddress(final String input) {
        return IPV6_STD_PATTERN.matcher(input).matches();
    }
    
    public static boolean isIPv6HexCompressedAddress(final String input) {
        return IPV6_HEX_COMPRESSED_PATTERN.matcher(input).matches();
    }
    
    public static boolean isIPv6Address(final String input) {
        return isIPv6StdAddress(input) || isIPv6HexCompressedAddress(input); 
    }
    
    public static void main(String[] args){
        InetAddress ip;
        String hostname;
        try {
            ip = InetAddress.getLocalHost();
            String[] getIp = ip.toString().split("/");
            if(isIPv4Address(getIp[1])){
               hostname = ip.getHostName();
               System.out.println("Your current IP address : " + ip);
               System.out.println("Your current Hostname : " + hostname);
            }
 
        } catch (UnknownHostException e) {
 
            e.printStackTrace();
        }
    }
   
}