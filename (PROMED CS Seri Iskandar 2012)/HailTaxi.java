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
            List <Coordinate> list = new ArrayList <>();
            String[] p = scan.next().trim().split(" ");
            
            Coordinate player = new Coordinate(Double.parseDouble(p[0]), Double.parseDouble( p[1]));
            
            while (true) {
                String input = scan.next().trim();
                if (input.equals("10001 10001"))
                    break;
                else {
                    String[] in = input.split(" ");
                    list.add(new Coordinate(Double.parseDouble(in[0]), Double.parseDouble(in[1])));
                }
            }
            
            list.add(new Coordinate(0,0));
            Collections.sort(list);
                        
            Coordinate bf = findNearest(list,player);

            ans[x] = "Case #" + (x + 1) + ": " + bf;
        }

        for (int x = 0; x < cases; x++) {
            System.out.println(ans[x]);
        }
    }

    private static class Coordinate implements Comparable<Coordinate> {
        private double x;
        private double y;

        public Coordinate(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
        
        @Override
        public int compareTo(Coordinate p){
            if(y - p.y != 0){
                return (int)(y - p.y);
            }
 
            if(x - p.x != 0){
                return (int)(x - p.x);
            }
 
            return 0;
        }

        public String toString() {
            return (int)x + " " + (int)y;
        }
    }

 
    private static double calDistance(Coordinate a,Coordinate p){
        return (a.getX()-p.getX())*(a.getX()-p.getX()) + (a.getY()-p.getY())*(a.getY()-p.getY());
    }

    private static Coordinate findNearest(List <Coordinate> points, Coordinate player) {        
        Coordinate closest = points.get(0);
        for (Coordinate coor:points) {            
            if (calDistance(coor,player) <= calDistance(closest, player))
               closest = coor;
        }
        
        return closest;
    }
   
}