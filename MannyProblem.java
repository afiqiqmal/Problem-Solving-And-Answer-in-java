//http://programmingcode4life.blogspot.my/2015/08/mannys-password-problem.html

import java.util.*;
import java.io.*;
//http://programmingcode4life.blogspot.my/2015/08/mannys-password-problem.html
class MannyProblem {
   public static void main(String args[] ) throws Exception {
     Scanner scan = new Scanner(System.in);
     int cases = scan.nextInt();
     
     String [] data = new String[cases];
     for(int x=0;x<cases;x++){
         data[x] = scan.next();
     }
     
     String mid="";
     for(int x=0;x<data.length-1;x++){
         for(int y=1;y<data.length;y++){
            if(palin(data[x]).equals(data[y]))
                mid = data[x].length()+" "+data[x].substring(data[x].length() / 2, data[x].length() / 2 + 1 );
        
         }
     }
     
     System.out.print(mid);
   }
       
   public static String palin(String x){
      String value = "";
        
      value = new StringBuffer(x).reverse().toString();
         
      return value;
  }
}