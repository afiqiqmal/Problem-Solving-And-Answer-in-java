import java.util.*;
public class Permutations {
    public static Set<String> permutationFinder(String str) {
        Set<String> perm = new HashSet<String>();
        
        //whitespaces
        if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        
        char initial = str.charAt(0); // first character
        String rem = str.substring(1); // Full string without first character
        Set<String> words = permutationFinder(rem);
        for (String strNew : words) {
            for (int i = 0;i<=strNew.length();i++){
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }
 
    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }
 
    public static void main(String[] args) {
        String s = "1234";
        System.out.println("\nPermutations for " + s + " are: \n" + permutationFinder(s));
    }
}