/*
Input
3   <--- input cases
*
6
$
5
#
4

Output:

******
*    *
*    *
*    *
*    *
******

$$$$$
$   $
$   $
$   $
$$$$$

####
#  #
#  #
####

*/
import java.util.*;
public class squarepattern {
    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            String lineSeparator = System.getProperty("line.separator");
            scan.useDelimiter(lineSeparator);
            int N = 0;
            System.out.println("Enter number of test cases : ");
            N = scan.nextInt();
            String[] huruf = new String[5];
            int[] num = new int[5];
            for (int x = 0; x < N; x++) {
                huruf[x] = scan.next();
                num[x] = scan.nextInt();
            }
            for (int x = 0; x < N; x++) {
                if (num[x] == 1)
                    System.out.print(huruf[x]);
                System.out.println();
                if (num[x] == 2) {
                    for (int row = 0; row < num[x]; row++) {
                        for (int col = 0; col < num[x]; col++) {
                            System.out.print(huruf[x]);
                        }
                        System.out.println();
                    }
                }
                if (num[x] > 2) {
                    for (int row = 0; row < num[x]; row++) {
                        for (int col = 0; col < num[x]; col++) {
                            if ((row == 0) || (row == num[x] - 1))
                                System.out.print(huruf[x]);
                            else {
                                if ((col == 0) || (col == num[x] - 1))
                                    System.out.print(huruf[x]);
                                else
                                    System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                }
            }
        } //close main
} //close class