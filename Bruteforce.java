import java.util.*;
/*
   modified by hafiq
   Brute force list ex: a..aaab..aaaaaaC....
   any expert can advise me to improve this code...tq..
   
   String list is A-z. Length is 26 + 26 = 52 character.

   the combination of 5 character is
   
   52 * 52 * 52 * 52 *52 = 52^5 = 380204032 combination !!!
*/
public class Bruteforce
{
  public static void main(String[] args){
      String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
      int max = 4; //limit length
      generate(str.toCharArray(),max);
  }
  public static void generate(char[] input,int max) {
    char[] result = new char[input.length];
    int[] index = new int[input.length];

    // initialize the arrays.
    Arrays.fill(result, 0, result.length, input[0]);
    Arrays.fill(index,  0, index.length, 0);

    // loop over the output lengths.
    for( int length = 1; length <= max; length++ ) {
      int update = 0;
      
      while(update != -1){
        System.out.println(new String(result, 0, length));

        // update values that need to reset.
        for(update = length-1;
            update != -1 && ++index[update] == input.length;
            result[update] = input[0], index[update] = 0, update--);

        // update the character that is not resetting, if valid
        if( update != -1 ) 
            result[update] = input[index[update]];
      } 
    }
  }
}