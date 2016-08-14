import java.util.*;
import java.io.*;

/**
 * Created by Hafiq Iqmal on 14/8/2016.
 * PROMED CS 2012
 * Using bruteforce closest pairing coordinate
 */

public class HailTaxi {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String line = System.getProperty("line.separator");
        scan.useDelimiter(line);

        int cases = scan.nextInt();
        String[] ans = new String[cases];

        for (int x = 0; x < cases; x++) {
            List < Coordinate > list = new ArrayList < > ();
            while (true) {
                String input = scan.next();
                if (input.equals("10001 10001"))
                    break;
                else {
                    String[] in = input.split(" ");
                    list.add(new Coordinate(Integer.parseInt( in [0]), Integer.parseInt( in [1])));
                }
            }

            CoordinateDetail bf = bruteForce(list);

            ans[x] = "Case #" + (x + 1) + ": " + bf;
        }

        for (int x = 0; x < cases; x++) {
            System.out.println(ans[x]);
        }
    }

    private static class Coordinate {
        private int x;
        private int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public String toString() {
            return x + " " + y;
        }
    }

    private static class CoordinateDetail {
        private Coordinate point1 = null;
        private Coordinate point2 = null;
        private int distance = 0;

        public CoordinateDetail(Coordinate point1, Coordinate point2, int distance) {
            this.point1 = point1;
            this.point2 = point2;
            this.distance = distance;
        }

        public Coordinate getPoint1() {
            return point1;
        }

        public Coordinate getPoint2() {
            return point2;
        }


        public int getDistance() {
            return distance;
        }


        public void set(Coordinate point1, Coordinate point2, int distance) {
            this.point1 = point1;
            this.point2 = point2;
            this.distance = distance;
        }

        public String toString() {
            return point2.toString();
        }
    }

    private static int calDistance(Coordinate p1, Coordinate p2) {
        int xdist = p2.getX() - p1.getX();
        int ydist = p2.getY() - p1.getY();
        return (int) Math.hypot(xdist, ydist);
    }

    private static CoordinateDetail bruteForce(List < Coordinate > points) {
        int coorSize = points.size();
        if (coorSize < 2)
            return null;

        CoordinateDetail coorPoint = new CoordinateDetail(points.get(0), points.get(1), calDistance(points.get(0), points.get(1)));
        if (coorSize > 2) {
            for (int i = 0; i < coorSize - 1; i++) {
                Coordinate point1 = points.get(i);
                for (int j = i + 1; j < coorSize; j++) {
                    Coordinate point2 = points.get(j);
                    int distance = calDistance(point1, point2);
                    if (distance < coorPoint.getDistance())
                        coorPoint.set(point1, point2, distance);
                }
            }
        }
        return coorPoint;
    }
}