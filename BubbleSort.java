public class BubbleSort {
        public static void main(String[] args) {
                int intArray[] = new int[]{51,1,61,7,55,90,25,99,91,15,35};
               
                System.out.println("Array Before Bubble Sort");
                for(int i=0; i < intArray.length; i++){
                        System.out.print(intArray[i] + ", ");
                }
                System.out.println();
                bubbleSort(intArray);
        }
 
        private static void bubbleSort(int[] intArray) {
           int n = intArray.length;
           int temp = 0;
           for(int i=0; i < n; i++){
               for(int j=1; j < (n-i); j++){
                  if(intArray[j-1] > intArray[j]){
                     temp = intArray[j-1];
                     intArray[j-1] = intArray[j];
                     intArray[j] = temp;             
                   }      
                   display(intArray);
                }
           }
        }
        
        private static void display(int[] intArray){
            for(int i=0; i < intArray.length; i++){
                    System.out.print(intArray[i] + ", ");
                }
                System.out.println();
        }
}