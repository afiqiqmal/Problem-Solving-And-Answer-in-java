public class ChristmasTree{

     public static void main(String []args){
        int max=10; // height
        
        for(int x=0;x<max;x++){
            for(int y=0;y<x+1;y++){
                for(int z=0;z<max-y-1;z++){
                    System.out.print(" ");
                }
                for(int z=0;z<(y*2)+1;z++){
                    System.out.print("*");
                }
                
                System.out.println();
            }
        }
     }
}