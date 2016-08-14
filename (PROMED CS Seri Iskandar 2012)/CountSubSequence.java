import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Hafiq Iqmal on 14/8/2016.
 * PROMED CS 2012
 */
public class CountSubSequence{

    static final int MODULES = 1000000003;

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        String line = System.getProperty("line.separator");
        scan.useDelimiter(line);

        int cases = scan.nextInt();
        String[] ans = new String[cases];

        for (int x = 0; x < cases; x++) {

            String first = scan.next();
            String second = scan.next();

            List<String> fList = getForwardPermutation(first);
            List<String> sList = getForwardPermutation(second);

            ans [x] ="Case #"+(x+1)+": "+countSS(fList,sList);
        }

        for (int x = 0; x < cases; x++) {
            System.out.println(ans[x]);
        }
    }

    private static int countSS(List<String> flist,List<String> slist){
        // swap which is greater
        if (flist.size() < slist.size()){
            List<String> temp  = flist;
            flist = slist;
            slist = temp;
        }

        int count = 0;

        for (String aFlist : flist) {
            for (String aSlist : slist) {
                if (aFlist.equals(aSlist)) {
                    count++;
                }
            }
        }

        return count % MODULES;
    }

    private static List<String> getForwardPermutation(String text) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            int lenRes = res.size();
            for (int j = 0; j < lenRes; j++) {
                res.add(text.charAt(i) + res.get(j));
            }
            res.add(Character.toString(text.charAt(i)));
        }
        // put null at first list
        res.add(0,"");

        return res;
    }

}
