//http://programmingcode4life.blogspot.my/2015/09/house-numbering-kictm-uitm-jasin-2015.html

import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = System.getProperty("line.separator");
        scan.useDelimiter(line);
        
        String ans = "";
        int a = 0, b = 0, no = 0, ct = 1;
        String op = scan.next();
        while (!op.equalsIgnoreCase("#")) {
            if (op.contains("COST")) {
                ans = ans + "Set " + ct + "\n";
                String get[] = op.split(" ");
                a = Integer.parseInt(get[1]);
                b = Integer.parseInt(get[2]);
                ct++;
            } else {
                no = Integer.parseInt(op);
                String c = Integer.toBinaryString(no);
                int z = 0, s = 0;

                for (int x = 0; x < c.length(); x++) {
                    if (c.charAt(x) == '1')
                        s++;
                    else
                        z++;
                }

                int total = (z * a) + (s * b);
                ans = ans + total + "\n";

            }
            op = scan.next();
        }
        System.out.println(ans);
    }
}