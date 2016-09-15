import java.util.*;


/**
   Author : Hafiq
   Date :
**/

public class Winner{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      String line = System.getProperty("line.separator");
      scan.useDelimiter(line);
      
      int cases = scan.nextInt();
      
      int max = 0;
      String current = "";
      Event ev = new Event();
      List<Event> event = new ArrayList<>();
      for(int x=0;x<cases;x++){
         String[] split = scan.next().split(" ");
         ev = new Event(split[0],Integer.parseInt(split[1]),Integer.parseInt(split[2]),Integer.parseInt(split[3]));
         event.add(ev);
      }
      
            
      Collections.sort(event, new Comparator<Event>(){
         @Override
         public int compare(Event e1,Event e2){
            if (e1.gold > e2.gold) {
               return -1;
            } else if (e1.gold < e2.gold) {
               return 1;
            } else {
               return 0;
            }
         }
      });
      
       
      for(Event e:event){
         System.out.println(e.toString());
      }
   }
}

class Event{
      public String name;
      public int gold;
      public int silver;
      public int bronze;
      
      public Event(){}
      
      public Event(String a,int b,int c, int d){
          name = a;
          gold = b;
          silver = c;
          bronze = d;
      }
      
      public String toString(){
         return name+" "+gold+" "+silver+" "+bronze;
      }
   }