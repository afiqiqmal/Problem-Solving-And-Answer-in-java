public static String RandomAlpha(int len){
      Random r = new Random();
      String key = "";
      for(int x=0;x<len;x++)
         key = key + (char) (r.nextInt(26) + 'A');
      return key;
   }
   
   public static String RandomAlphaNoDuplicate(int len){
      Random r = new Random();
      String key = "";
      for (int i = 0; i < len;) {
          char c = (char) (r.nextInt(26) + 'A');
          if(!key.toString().contains(""+c)){
             key = key + c;
             i++;
          }
      }      
      return key;
   }