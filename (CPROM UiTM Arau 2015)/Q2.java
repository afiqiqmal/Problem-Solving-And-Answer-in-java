//http://programmingcode4life.blogspot.my/2015/09/electricity-charges-cprom-uitm-arau.html

import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;

public class Q2{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      String line =System.getProperty("line.separator");
      scan.useDelimiter(line);
            
      int use = scan.nextInt();
      
      double total = 0;
      
      if(use<=250){
         total = use*0.10;
      }
      else if(use>250){
         total = 250*0.10;
         use = use - 250;
         
         if(use<=200){
            total = total + (use*0.2);
         }
         else if(use>200){
            total = total + (200*0.2);     
            use = use - 200;       
            if(use<=200){
               total = total + (use*0.3);   
            }
            else if(use > 200){
               total = total + (200*0.3);
               use = use - 200;
               total = total + (use*0.5);
            }   
         }
      }
      
      System.out.print(total);
   }
}


/*
Judge Answer

#include <iostream>
using namespace std;
int main() {
    float kWh,charges;
    cin>>kWh;
    if(kWh<=50 ) charges=5.00;
    else if(kWh>50 && kWh<=250) charges=kWh*0.10;
    else if(kWh>250 && kWh<=450) charges=25+((kWh-250)*0.20);
    else if(kWh>450 && kWh<=650) charges=65+((kWh-450)*0.30);
    else charges=125+((kWh-650)*0.50);
    cout<<charges;
}
*/