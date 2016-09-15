import java.util.*;


/**
   Author : Hafiq
   Date :
**/

public class Aveg{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      String line = System.getProperty("line.separator");
      scan.useDelimiter(line);
      
      int cases = scan.nextInt();
      
      for(int x=0;x<cases;x++){
         int count = scan.nextInt();
         String[] split = scan.next().split(" ");
         int [] num = new int[count];
         for(int z=0;z<count;z++){
            num[z] = Integer.parseInt(split[z]);
         }
         Arrays.sort(num);
         
         int median = 0;double mean = 0;
         int mid = count/2;
         
         if(count%2 == 0)
            median = (num[mid-1]+num[mid]) / 2;
         else
            median = num[mid];
                     
         for(int y=0;y<count;y++){
            mean += num[y];
         }
         
         System.out.println("Average:"+mean/count+" Median:"+median);
         
      }
   }
}