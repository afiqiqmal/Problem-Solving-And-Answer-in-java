//http://programmingcode4life.blogspot.my/2015/09/money-changing-problem-kictm-uitm-jasin.html

import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;

public class Q5{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      DecimalFormat df = new DecimalFormat("0.00");
      String line = System.getProperty("line.separator");
      scan.useDelimiter(line);
      
      while (true){
         String get = scan.next();
         String[] init = get.split(" ");
         
         if(get.equals("0.00 0.00"))
            break;
         
         int bil = Integer.parseInt(""+init[0].charAt(init[0].length()-1));
         
         if(bil == 1 || bil == 2)
            init[0] = init[0].substring(0,init[0].length()-1)+"0";
         else if(bil ==3 || bil == 4)
            init[0] = init[0].substring(0,init[0].length()-1)+"5";
         else if(bil ==6 || bil == 7)
            init[0] = init[0].substring(0,init[0].length()-1)+"5";
         else if(bil ==8 || bil == 9){
            init[0] = df.format(Float.parseFloat(init[0])+0.1);
            init[0] = init[0].substring(0,init[0].length()-1)+"0";
         }

         if(Float.parseFloat(init[0])>Float.parseFloat(init[1]))
            System.out.println("Not enough money offered.");
         else if(init[0].equals(init[1]))
            System.out.println("Exact amount.");
         else{
            String total = df.format(Float.parseFloat(init[1]) - Float.parseFloat(init[0]));
            System.out.println(findMin(Float.parseFloat(total)));
         }
      }  
   }
   
   public static String findMin(float total){
      float n = total*100;
      int [] sets = new int[]{5,10,20,50,100,200,500,1000,2000};
      List<String> list = new ArrayList<String>();
      int counta=0;
      
      while(n>0){
         int max = sets[0]; 
         //review my blog title "minumum coin change"  
         //find list of minumum coin change (sorted coins list)
         for(int x=sets.length-1;x>=0;x--){
            if(sets[x]<=n){
               max = sets[x];
               break;
            }
         }
         
         if(max>=100){
            //convert cents to dollar
            int rev = max/100;
            list.add("$"+rev);
         }
         else
            list.add(max+"c");

         n=n-max;
      }
      
      StringBuilder str = new StringBuilder();

      Set<String> set = new HashSet<String>(list); 
      String []newstr = new String[set.size()];
      set.toArray(newstr);
      
      for(int x=0;x<newstr.length;x++){
          for(int y=0;y<list.size();y++){
             if(newstr[x].equals(list.get(y))){
                counta++;
             }
          }
          str.append(newstr[x]+"*"+counta+" ");
          counta=0;
      }      
      return str.toString();
   }
   
   
}