public static void main(String []args){
         int n = 13195;
         
         isPrimeFactor(n);
         
     }
     
     public static void isPrimeFactor(int n){
         
         int count=0;
         ArrayList arr = new ArrayList();
         for(int x=2;x<=n;x++){
            if(n%x==0){
               arr.add(x);
               
               n = n/x;
               x--;
               count++;      
            }
         }
         
         System.out.print(arr.toString());
     }