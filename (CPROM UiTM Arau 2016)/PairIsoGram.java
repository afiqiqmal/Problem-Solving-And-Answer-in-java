import java.util.*;


/**
   Author : Hafiq
   Date :
**/

public class PairIsoGram{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      String line = System.getProperty("line.separator");
      scan.useDelimiter(line);
      
      int cases = scan.nextInt();
      
      for(int x=0;x<cases;x++){
         String input = scan.next();
         Map<Character, Integer> count = new HashMap<Character, Integer>();
         for(int y=0;y<input.length();y++){
            char c = input.charAt(y);
            if (count.containsKey(c)) {
                int cnt = count.get(c);
                count.put(c, ++cnt);
            } else {
                count.put(c, 1);
            }
         }
         
         boolean flag = true;
         for(Map.Entry<Character, Integer> entry : count.entrySet()){
            if(entry.getValue() != 2){
               flag = false;
               break;
            }
         }
         
         System.out.println(input+" --- "+ ((flag)?"pair program":"not pair isogram"));
      }
      
            
   }
}