// http://programmingcode4life.blogspot.my/2015/09/bitmap-kictm-uitm-jasin-2015.html#more

import java.util.*;
import java.lang.*;

public class Q1 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String line = System.getProperty("line.separator");
        scan.useDelimiter(line);
        char[][] map, pattern;

        pattern = readMap(scan);
        while (pattern.length != 0) {
            map = readMap(scan);
            System.out.println(countPattern(map, pattern));
            pattern = readMap(scan);
        }
    }

    public static boolean findPattern(char[][] map, char[][] pattern, int[] offset) {
        for (int y = 0; y < pattern.length; y++) {
            for (int x = 0; x < pattern[y].length; x++) {
                if ((y + offset[0] >= map.length) || (x + offset[1] >= map[y].length)) {
                    return false;
                }

                if ((pattern[y][x] == '#') && (map[y + offset[0]][x + offset[1]] != '#')) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int countPattern(char[][] map, char[][] pattern) {
        int count = 0;
        for (int y = 0; y < map.length - pattern.length + 1; y++) {
            for (int x = 0; x < map[0].length - pattern[0].length + 1; x++) {
                int[] offset = new int[] {
                    y, x
                };
                if (findPattern(map, pattern, offset)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static char[][] readMap(Scanner scan) {
        int rows, columns;
        char[][] map;

        String[] line = scan.next().split(" ");
        rows = Integer.parseInt(line[0]);
        columns = Integer.parseInt(line[1]);

        map = new char[rows][columns];

        for (int x = 0; x < map.length; x++) {
            String str = scan.next();
            for (int y = 0; y < map[x].length; y++) {
                map[x][y] = str.charAt(y);
            }
        }
        return map;
    }
}