import java.util.*;

//http://programmingcode4life.blogspot.my/

//Railfence Columnar Cipher
public class RFwithColumnar {
    public static void main(String[] args) {

        String text = "IF YOU CAN READ THIS YOU ARE GENIUS";
        String key = "HACK";

        String enc = RFCEncryption(text, key);

        System.out.println(enc);
    }

    public static String RFCEncryption(String text, String keytext) {
        int[] arrange = arrangeKey(keytext);

        int key = arrange.length;
        int lentext = text.length();

        int move = 1;
        int count = 0;
        String[][] rfp = new String[key][lentext];

        // arrange dot fence
        for (int x = 0; x < rfp.length; x++) {
            for (int y = 0; y < rfp[x].length; y++) {
                rfp[x][y] = ".";
            }
        }

        // formatting according fence rails
        for (int i = 0; i < lentext; i++) {
            if ((move % 2) != 0) {
                rfp[count][i] = "" + text.charAt(i);
                if (count == (key - 1)) {
                    move = 2;
                    count = (key - 2);
                } else
                    count++;
            } else if ((move % 2) == 0) {
                rfp[count][i] = "" + text.charAt(i);
                if (count == 0) {
                    move = 1;
                    count = 1;
                } else
                    count--;
            }
        }

        //replace any white space with X or random
        for (int x = 0; x < rfp.length; x++) {
            for (int y = 0; y < rfp[x].length; y++) {
                if (rfp[x][y].equals(" "))
                    rfp[x][y] = ""+Character.toUpperCase(RandomAlpha());
            }
        }

        // display
        System.out.println();
        for (int i = 0; i < rfp.length; i++) {
            for (int u = 0; u < rfp[i].length; u++) {
                System.out.print(rfp[i][u] + " ");
            }
            System.out.println();
        }
        System.out.println();


        StringBuilder cb = new StringBuilder();
        //encode string from fence
        for (int x = 0; x < key; x++) {
            for (int y = 0; y < key; y++) {
                if (x == arrange[y]) {
                    for (int u = 0; u < lentext; u++) {
                        if (!".".equals(rfp[y][u])) {
                            cb.append(rfp[y][u]);
                        }
                    }
                }
            }
        }
        return "" + cb;
    }
    
    public static int[] arrangeKey(String key) {
        //arrange position of grid
        String[] keys = key.split("");
        Arrays.sort(keys);
        int[] num = new int[key.length()];
        for (int x = 0; x < keys.length; x++) {
            for (int y = 0; y < key.length(); y++) {
                if (keys[x].equals(key.charAt(y) + "")) {
                    num[y] = x;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(num));
        return num;
    }
    
    public static char RandomAlpha() {
        //generate random alpha for null space
        Random r = new Random();
        return (char)(r.nextInt(26) + 'a');
    }
}