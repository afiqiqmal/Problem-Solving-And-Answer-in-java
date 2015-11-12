import java.util.*;
import java.lang.*;
import java.math.*;

/*

%  represents  0
)  represents  1
~  represents  2
@  represents  3
?  represents  4
\  represents  5
$  represents  -1  (yes, they even have a negative digit)

As you may expect, their system is base 6 where each place value is 6 times the value to its right, as in the following examples:

)@% is 1*62+3*6+0 = 36+18+0 = 54
?$~~  is 4*63+(–1)*62+2*6+2 = 864–36+12+2 = 842
$~~    is (–1)*62+2*6+2 = –36+12+2 = -22 

Your task is to take Wacmian numbers and represent them as standard base 10 numbers.

Sample Input
)@%
?$~~
$~~
%
#

Sample Output
54
842
-22
0

*/
public class WacmianNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.next();
        while (line.charAt(0) != '#') {
            System.out.println(convertNumber(line, 6));
            line = scan.next();
        }
    }
    public static int convertDigit(char wdigit) {
        switch (wdigit) {
            case '%':
                return 0;
            case ')':
                return 1;
            case '~':
                return 2;
            case '@':
                return 3;
            case '?':
                return 4;
            case '\\':
                return 5;
            case '$':
                return -1;
        }
        return 0;
    }

    public static int convertNumber(String str, int base) {
        int total = 0;
        for (int x = 0; x < str.length(); x++) {
            total = base * total + convertDigit(str.charAt(x));
        }
        return total;
    }
}