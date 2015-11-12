//http://programmingcode4life.blogspot.my/2015/09/the-mirror-cprom-uitm-arau-2015.html

import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;

public class Q10{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      String line =System.getProperty("line.separator");
      scan.useDelimiter(line);
            
      int cases = scan.nextInt();
      
      String [] ans = new String[cases];
            
      for(int x=0;x<cases;x++){
         String get = scan.next();
         
         StringBuilder str = new StringBuilder(get);
         get = get+str.reverse().toString();
         
         ans[x] = get;         
      }
      
      for(int x=0;x<cases;x++){
         System.out.println(ans[x]);
      }
   }
}


/*
Judge Answer

import.java.util.Scanner;
public class Mirror {
    public static void main(String[] args) {
        Scanner sc = newScanner(System.in);
        intN = sc.nextInt();
        String testCase[] = new String[N];
        for (inti = 0; i < N; i++) {
            testCase[i] = sc.next();
        }
        for (inti = 0; i < N; i++) {
            for (intj = testCase[i].length() - 1; j >= 0; j--) {
                testCase[i] += testCase[i].charAt(j);
            }
            System.out.println(testCase[i]);
        }
        sc.close();
    }
}

*/