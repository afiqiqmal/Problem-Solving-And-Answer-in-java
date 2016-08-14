import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Hafiq Iqmal on 14/8/2016.
 * PROMED CS 2012
 */
public class PLock {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String line = System.getProperty("line.separator");
        scan.useDelimiter(line);

        int cases = scan.nextInt();
        String [] ans = new String[cases];

        for(int x=0;x<cases;x++){
            String get = scan.next();

            if(get.length()>2 && get.matches("[A-Z]+")){
                if (!findDuplicate(get))
                    ans[x] = "Case #"+(x+1)+": VALID";
                else
                    ans[x] = "Case #"+(x+1)+": INVALID";
            }
            else
                ans[x] = "Case #"+(x+1)+": INVALID";

        }

        for (int x=0;x<cases;x++){
            System.out.println(ans[x]);
        }
    }

    private static boolean findDuplicate(String str){

        Map<Character, Integer> map = new HashMap<>();
        char[] getChar = str.toCharArray();
        for(Character isDuplicate:getChar){
            if(map.containsKey(isDuplicate)){
               // plus 1 if found same character     
               map.put(isDuplicate, map.get(isDuplicate)+1);
            } else {
               // add 1 to new Character
               map.put(isDuplicate, 1);
            }
        }
        Set<Character> keys = map.keySet();
        for(Character isDuplicate:keys){
            if(map.get(isDuplicate) > 1){
                //found more than 1
                return true;
            }
        }

        return false;
    }
}
