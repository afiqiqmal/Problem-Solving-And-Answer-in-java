public class PalinLong{
//longest palindrome in a string
     public static void main(String []args){
        
        String s = "forgeeksskeegfor";
        String longest="";
        for(int x=0;x<s.length();x++){
            for(int y=x+1;y<=s.length();y++){
                String t = s.substring(x,y);
                if(isPalin(t)){
                    if(t.length()>longest.length()){
                        longest = t;
                    }
                }
            }   
        }
        
        System.out.print(longest);
     }
     
     public static boolean isPalin(String s){
         String rev="";
         
         for(int x=s.length()-1;x>=0;x--){
             rev = rev + s.charAt(x);
         }
         
        if(rev.equals(s))
            return true;
        else
            return false;
     }
}