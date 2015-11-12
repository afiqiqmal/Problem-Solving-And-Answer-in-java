//http://programmingcode4life.blogspot.my/2015/09/search-and-replace-cprom-uitm-arau.html

import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;

public class Q3{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      String line =System.getProperty("line.separator");
      scan.useDelimiter(line);

      String get = scan.next();
      
      String str = get.replace("a","$");
      str = str.replace("A","$");
      str = str.replace("e","@");
      str = str.replace("E","@");
      str = str.replace("i","#");
      str = str.replace("I","#");
      str = str.replace("o","&");
      str = str.replace("O","&");
      str = str.replace("u","%");
      str = str.replace("U","%");
         
      System.out.print(str);
   }
}

/*
Judge Answer

#include<iostream> 
#include<string.h>
using namespace std;
int main() {
    char sentence[300];
    //declaration string //user input 
    cout<<"Please enter string of sentence:";
    cin.getline(sentence,300);
    //loop for each character
    for(int i=0;i<strlen(sentence);i++) {
        //check & replase vowels : a e i o u  if((sentence[i]=='a')||(sentence[i]=='A'))  sentence[i]='$';
        else if((sentence[i]=='e')||(sentence[i]=='E'))  sentence[i]='@';
        else if((sentence[i]=='i')||(sentence[i]=='I'))  sentence[i]='#';
        else if((sentence[i]=='o')||(sentence[i]=='O'))  sentence[i]='&';
        else if((sentence[i]=='u')||(sentence[i]=='U'))  sentence[i]='%';
    }
    //display output after replacement
    cout<<"After replace the vowels:"<<sentence<<endl;
    return 0;
}

*/