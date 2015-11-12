public class BinarySearch{

     public static void main(String []args){
        // Binary search must be sort first
        int[] array = new int[]{10,20,50,53,68,81,92,105,110,200,280,360,361,386,400};
        
        if(binSearch(array,81) == -1)
            System.out.print("not found");
        else
            System.out.print("found at index "+ binSearch(array,81));
     }
     
     public static int binSearch(int[] arr, int search){
         int first =0;
         int last = arr.length-1;
         int mid=0;
         
         while(first<=last){
             mid = (first+last)/2;
             
             if(arr[mid] == search)
                return mid;
             else if (arr[mid]<search)
                first = mid+1;
             else
                last = mid-1;
         }
         
         return -1;
     }
}