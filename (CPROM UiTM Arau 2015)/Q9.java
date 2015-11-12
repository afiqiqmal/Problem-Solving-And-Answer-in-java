//http://programmingcode4life.blogspot.my/2015/09/odd-stars-cprom-uitm-arau-2015.html
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;

public class Q9{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      String line =System.getProperty("line.separator");
      scan.useDelimiter(line);
            
      int in = scan.nextInt();
      int mid = (in/2);
      for(int x=0;x<in;x++){
         for(int y=0;y<in;y++){
            if(y == mid)
               System.out.print("*");
            else if(x == y)
               System.out.print("*");
            else if(x==mid)
               System.out.print("*");
            else if(y == (in-1)-x)
               System.out.print("*");
            else
               System.out.print(" ");
               
         }
         
         System.out.println();
      }
   }
}


/*
Judge Answer

#include <iostream> 
#include <math.h> 
using namespace std;
int main() {
    int size;
    cout<<"Enter an odd integer: ";
    cin>>size;
    char star[size][size];
    int center = ceil (size/2);
    for (int i = 0;
    i < size;
    i++) {
        for (int j = 0;
        j < size;
        j++) {
            if (j == center) cout<<"*";
            else if (i == center) cout<<"*";
            else if (i == j) cout<<"*";
            else if (i + j == size - 1) cout<<"*";
            else cout<<" ";
        }
        cout<<"n";
    }
    system("pause");
    return 0;
}

*/