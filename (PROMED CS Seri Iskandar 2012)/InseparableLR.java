import java.io.*;
import java.util.*;

/**
 * Created by Hafiq Iqmal on 14/8/2016.
 * PROMED CS 2012
 * Using bruteforce closest pairing coordinate and Divide and Conquer
 */

public class InseparableLR {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = System.getProperty("line.separator");
        scan.useDelimiter(line);

        int cases = scan.nextInt();
        String[] ans = new String[cases];

        for (int x = 0; x < cases; x++) {
            int num = scan.nextInt();
            List <Coordinate> points = new ArrayList <> ();

            for (int input = 0; input < num; input++) {
                String[] item = scan.next().split(" ");
                points.add(new Coordinate(input + 1, Double.parseDouble(item[0]), Double.parseDouble(item[1]), item[2].charAt(0)));
            }

            CoordinateDetail db = bruteForce(points);
            // CoordinateDetail db = divideAndConquer(points);

            ans[x] = "Case #" + (x + 1) + ": " + db.toString();
        }

        for (int x = 0; x < cases; x++) {
            System.out.println(ans[x]);
        }
    }


    private static class Coordinate {
        private int id;
        private double x;
        private double y;
        private char code;

        public Coordinate(int id, double x, double y, char code) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.code = code;
        }

        public int getId() {
            return id;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public char getCode() {
            return code;
        }

        public String toString() {
            return "(" + x + ", " + y + " , " + code + ")";
        }
    }

    private static class CoordinateDetail {
        private Coordinate point1 = null;
        private Coordinate point2 = null;
        private double distance = 0.0;

        public CoordinateDetail(Coordinate point1, Coordinate point2, double distance) {
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


        public double getDistance() {
            return distance;
        }


        public void set(Coordinate point1, Coordinate point2, double distance) {
            this.point1 = point1;
            this.point2 = point2;
            this.distance = distance;
        }

        public String toString() {
            if (Character.toLowerCase(point1.getCode()) > Character.toLowerCase(point2.getCode()))
                return point2.getId() + " " + point2.getCode() + " " + point1.getId() + " " + point1.getCode();
            else if (Character.toLowerCase(point1.getCode()) < Character.toLowerCase(point2.getCode()))
                return point1.getId() + " " + point1.getCode() + " " + point2.getId() + " " + point2.getCode();


            return "NO SOLUTION";

        }
    }

    private static double calDistance(Coordinate p1, Coordinate p2) {
        double xdist = p2.getX() - p1.getX();
        double ydist = p2.getY() - p1.getY();
        return Math.hypot(xdist, ydist);
    }

    // much faster than DnV for list of Coordinate is less than 100
    private static CoordinateDetail bruteForce(List <Coordinate> points) {
        int coorSize = points.size();
        if (coorSize < 2)
            return null;

        CoordinateDetail coorPoint = new CoordinateDetail(points.get(0), points.get(1), calDistance(points.get(0), points.get(1)));
        if (coorSize > 2) {
            for (int i = 0; i < coorSize - 1; i++) {
                Coordinate point1 = points.get(i);
                for (int j = i + 1; j < coorSize; j++) {
                    Coordinate point2 = points.get(j);
                    if(point1.getCode() != point2.getCode()){
                        double distance = calDistance(point1, point2);
                        if (distance < coorPoint.getDistance())
                            coorPoint.set(point1, point2, distance);
                    }
                }
            }
        }
        return coorPoint;
    }
}