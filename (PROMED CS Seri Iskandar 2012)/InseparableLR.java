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

            // CoordinateDetail db = bruteForce(points);
            CoordinateDetail db = divideAndConquer(points);

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
                    double distance = calDistance(point1, point2);
                    if (distance < coorPoint.getDistance())
                        coorPoint.set(point1, point2, distance);
                }
            }
        }
        return coorPoint;
    }

    private static void sortByX(List <Coordinate> points) {
        Collections.sort(points, new Comparator <Coordinate> () {
            public int compare(Coordinate point1, Coordinate point2) {
                if (point1.getX() < point2.getX())
                    return -1;
                if (point1.getX() > point2.getX())
                    return 1;
                return 0;
            }
        });
    }

    private static void sortByY(List <Coordinate> points) {
        Collections.sort(points, new Comparator <Coordinate> () {
            public int compare(Coordinate point1, Coordinate point2) {
                if (point1.getY() < point2.getY())
                    return -1;
                if (point1.getY() > point2.getY())
                    return 1;
                return 0;
            }
        });
    }

    // much faster than bruteforce for list of Coordinate is more than 100
    public static CoordinateDetail divideAndConquer(List <Coordinate> points) {
        List <Coordinate> listofSortedX = new ArrayList <> (points);
        sortByX(listofSortedX);
        List <Coordinate> listofSortedY = new ArrayList <> (points);
        sortByY(listofSortedY);
        return divideAndConquer(listofSortedX, listofSortedY);
    }

    private static CoordinateDetail divideAndConquer(List <Coordinate> listofSortedX, List <Coordinate> listofSortedY) {
        int coorSize = listofSortedX.size();
        if (coorSize <= 3)
            return bruteForce(listofSortedX);

        int index = coorSize >>> 1;
        List <Coordinate> leftOfCenter = listofSortedX.subList(0, index);
        List <Coordinate> rightOfCenter = listofSortedX.subList(index, coorSize);

        List <Coordinate> tempList = new ArrayList <> (leftOfCenter);
        sortByY(tempList);

        CoordinateDetail closestPair = divideAndConquer(leftOfCenter, tempList);

        tempList.clear();

        tempList.addAll(rightOfCenter);
        sortByY(tempList);

        CoordinateDetail closestPairRight = divideAndConquer(rightOfCenter, tempList);

        if (closestPairRight.getDistance() < closestPair.getDistance())
            closestPair = closestPairRight;

        tempList.clear();

        double shortestDistance = closestPair.getDistance();
        double centerX = rightOfCenter.get(0).getX();
        for (Coordinate point: listofSortedY)
            if (Math.abs(centerX - point.getX()) < shortestDistance)
                tempList.add(point);

        for (int i = 0; i < tempList.size() - 1; i++) {
            Coordinate point1 = tempList.get(i);
            for (int j = i + 1; j < tempList.size(); j++) {
                Coordinate point2 = tempList.get(j);
                if ((point2.getY() - point1.getY()) >= shortestDistance)
                    break;
                double distance = calDistance(point1, point2);
                if (distance < closestPair.getDistance()) {
                    closestPair.set(point1, point2, distance);
                    shortestDistance = distance;
                }
            }
        }
        return closestPair;
    }

}