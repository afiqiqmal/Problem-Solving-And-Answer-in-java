public int stringMatch(String a, String b) {
  int len = (a.length()<=b.length())? a.length() : b.length();
  int count=0;
  for(int x=0;x<len-1;x++){
    if(a.substring(x,x+2).equals(b.substring(x,x+2)))
      count++;
  }
  
  return count;
}

//http://programmingcode4life.blogspot.my/2015/08/string-matching-1.html