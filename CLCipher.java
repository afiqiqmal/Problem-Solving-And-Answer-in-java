/*
   authors by hafiq
   
   Colummnar Transposition without key and possible decrytion
   
   any expert can advise me to improve this code...tq..
*/
import java.util.*;
import java.lang.*;

public class CLCipher {
    public static void main(String[] args) {
        String str = "REPEAT ATTACK TONIGHT";
        System.out.println("Encryption Text: " + encrypt(str));
        String get[] = decrypt(encrypt(str));

        System.out.println("Possible Decyrption Text:");
        for (int x = 0; x < get.length; x++)
            System.out.println((x + 1) + ". " + get[x]);

    }

    public static String encrypt(String str) {

        String[] get = str.split(" ");

        int maxlen = 0;
        String init = "";
        for (String a: get) {
            if (a.length() >= init.length())
                init = a;
        }

        //if maxlen == 7, so the column must be 7
        //get.length will be the row number;
        maxlen = init.length();
        char[][] grid = new char[get.length][maxlen];

        for (int x = 0; x < get.length; x++) {
            String gt = get[x];
            for (int y = 0; y < maxlen; y++) {
                if (y != gt.length())
                    grid[x][y] = gt.charAt(y);
                else
                // can be replace with random alphabet also
                    grid[x][y] = 'X';
            }
        }

        StringBuilder cb = new StringBuilder();
        for (int x = 0; x < maxlen; x++) {
            for (int y = 0; y < get.length; y++) {
                cb.append(grid[y][x]);
            }
        }

        return cb.toString();
    }

    public static String[] decrypt(String str) {

        int getnum = str.length();

        //get possible division number
        List < Integer > val = new ArrayList < Integer > ();
        for (int x = 1; x < getnum; x++) {
            if (getnum % x == 0)
                val.add(x);
        }

        String[] dec = new String[val.size()];
        for (int x = 0; x < val.size(); x++) {
            int now = (int) val.get(x);
            String regex = "(?<=\\G.{" + now + "})";
            String[] get = str.split(regex);

            //tranpose
            char grid[][] = new char[now][get.length];
            for (int y = 0; y < get.length; y++) {
                String nw = get[y];
                for (int z = 0; z < nw.length(); z++) {
                    grid[z][y] = nw.charAt(z);
                }
            }

            //combine
            dec[x] = "";
            for (int y = 0; y < now; y++) {
                for (int z = 0; z < get.length; z++) {
                    dec[x] = dec[x] + grid[y][z];
                }
                dec[x] = dec[x] + " ";
            }

        }


        return dec;
    }

}