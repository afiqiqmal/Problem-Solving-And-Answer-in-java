//http://programmingcode4life.blogspot.my/2015/09/numbers-of-words.html

import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.*;

public class Q5{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      String line =System.getProperty("line.separator");
      scan.useDelimiter(line);
      
      String str = scan.next();
      str = str.replace(",","").replace(".","").toLowerCase();

      String[] get = str.split(" ");
      List<String> list = Arrays.asList(get);
      Set<String> set = new HashSet<String>(list);
      
      String []newstr = new String[set.size()];
      set.toArray(newstr);
               
      System.out.print(newstr.length);
   }
}

/*
Judge Answer

importjava.util.*;
public class wordsCountDifferent {
    public static void main(String args[]) {
        String sentence;
        ArrayListwordsAL = new ArrayList();
        Scanner in = new Scanner(System.in);
        intsame_words = 0;
        char[] tSentence = new char[1000];
        intnewWordCount = 0;
        String nSentence = " ";
        System.out.print("Enter a sentence: ");
        sentence = in .nextLine();
        for (int index = 0; index < sentence.length(); index++) {
            if (sentence.charAt(index) != ',' && sentence.charAt(index) != '.') {
                tSentence[newWordCount] = sentence.charAt(index);
                newWordCount++;
            }
        }

        nSentence = nSentence.copyValueOf(tSentence, 0, newWordCount);
        for (String word: nSentence.split(" ")) {
            wordsAL.add(word);
        }
        ArrayListdiffList = new ArrayList();
        intdiffIndex = 0;
        String word1;
        String word2 = " ";
        int flag = 0;
        for (int index = 0; index < wordsAL.size(); index++) {
            word1 = (String) wordsAL.get(index);
            if (diffIndex == 0) {
                diffList.add(diffIndex, word1);
                diffIndex++;
            } else {
                flag = 0;
                for (int counter = 0; counter < diffList.size(); counter++) {
                    word2 = (String) diffList.get(counter);
                    if (word1.equalsIgnoreCase(word2)) {

                        flag = 1;
                        counter = diffList.size();
                    }
                }
                if (flag == 0) {
                    diffList.add(diffIndex, word1);
                    diffIndex++;
                }
            }
        }
        System.out.println("Size of diffList =  " + diffList.size());
    }
}
*/