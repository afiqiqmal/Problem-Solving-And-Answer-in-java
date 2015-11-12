   //FIZZBUZZ PROBLEM
   
   public static void main(String[] args){
      
      for(int x=1;x<=100;x++){
      if(x%3==0){
       System.out.print("Fizz");
       if(x%5==0){
        System.out.print("Buzz");
       }
       System.out.println();
      }
      else if(x%5==0)
       System.out.println("Buzz");
      else
       System.out.println(x);
      
     }
   
   }