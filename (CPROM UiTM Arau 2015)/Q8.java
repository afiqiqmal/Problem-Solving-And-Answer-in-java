//http://programmingcode4life.blogspot.my/2015/09/character-classifier-cprom-uitm-arau.html

import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;

public class Q8{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      String line =System.getProperty("line.separator");
      scan.useDelimiter(line);      
 
      int cases = scan.nextInt();
            
      for(int x=0;x<cases;x++){
         String get = scan.next();
         
         int countd=0,countl=0,counts=0,countu=0,countlo=0;
         for(int y=0;y<get.length();y++){
            if(Character.isDigit(get.charAt(y)))
               countd++;
            else if(Character.isLetter(get.charAt(y))){
               countl++;
               
               if(Character.isUpperCase(get.charAt(y)))
                  countu++;
               else if(Character.isLowerCase(get.charAt(y)))
                  countlo++;
            }
            else
               counts++;
            
         }
         
         System.out.println("Digit:"+countd+"\nAlphabet:"+countl+"\nSymbol:"+counts+"\nUppercase:"+countu+"\nLowercase:"+countlo+"\n");
         
      }

   }
}


/*
Judge Answer

#include<iostream.h> 
#include<ctype.h>
void main() {
    int i, alpha, digit,upper,lower,punc;
    char testcase[10][40];
    int num;
    cin>>num;
    for(int j=0;
    j<num;
    j++) {
        cin>>testcase[j];
    }
    for(j=0;
    j<num;
    j++) {
        alpha=0, digit=0,upper=0,lower=0,punc=0,i=0;
        while (testcase[j][i]!= '')  {
            if (isdigit(testcase[j][i])) {
                digit++;
            }
            else if (isalpha(testcase[j][i])) {
                alpha++;
                if (isupper(testcase[j][i]))  upper++;
                else if (islower(testcase[j][i]))  lower++;
            }
            else if (ispunct(testcase[j][i])) {
                punc++;
            }
            i++;
        }
        cout<<endl;
        cout<<"Digit: "<<digit<<endl;
        cout<<"Alphabet: "<<alpha<<endl;
        cout<<"Symbol: "<<punc<<endl;
        cout<<"Uppercase: "<<upper<<endl;
        cout<<"Lowercase: "<<lower<<endl;
    }
}

*/