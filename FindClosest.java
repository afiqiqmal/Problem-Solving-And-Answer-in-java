import java.util.*;

public class FindClosest{   
   public static int findCrossOver(List<Double> arr, int low, int high, int x)
   {
      if (arr.get(high) <= x) // x is greater than all
      	return high;
      if (arr.get(low) > x) // x is smaller than all
      	return low;
      
      // Find the middle point
      int mid = (low + high)/2; /* low + (high - low)/2 */
      
      /* If x is same as middle element, then return mid */
      if (arr.get(mid) <= x && arr.get(mid+1) > x)
      	return mid;
      
      if(arr.get(mid) < x)
      	return findCrossOver(arr, mid+1, high, x);
      
      return findCrossOver(arr, low, mid - 1, x);
   }
   
   public static double printKclosest(List<Double> arr, int x,int n)
   {
   	// Find the crossover point
   	int l = findCrossOver(arr, 0, n-1, x); // le
   	int r = l+1; // Right index to search
   	int count = 0; // To keep track of count of elements already printed
   
   	// If x is present in arr[], then reduce left index
   	// Assumption: all elements in arr[] are distinct
   	if (arr.get(l) == x) l--;
   
   	// Compare elements on left and right of crossover
   	// point to find the 1 closest elements
   	double a = 0;
       while (l >= 0 && r < n && count < 1)
       {
           if (x - arr.get(l) < arr.get(r) - x)
               a = arr.get(l--);
           else
               a = arr.get(r++);
           count++;
       }
    
       // If there are no more elements on right side, then
       // print left elements
       while (count < 1 && l >= 0){
           a = arr.get(l--);
           count++;
       }
    
       // If there are no more elements on left side, then
       // print right elements
       while (count < 1 && r < n){
           a = arr.get(r++);
           count++;
       }
       return a;
   }
   
   public static void main(String[] args)
   {
      Double arr[] ={12.0, 16.0, 22.0, 3.00, 35.0, 39.0, 42.0,45.0, 48.0, 50.0, 53.0, 5.05, 56.0};
      
      List<Double> doubleList = Arrays.asList(arr);
      
      int n = arr.length/2;
      int x = 11;
      double d = printKclosest(doubleList, x, n);
      
      System.out.print(d);
   }
}