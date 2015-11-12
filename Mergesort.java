import java.util.*;

//http://programmingcode4life.blogspot.my/2015/09/merge-sort.html#more

public class Mergesort{
 public static void main(String[] args){
  int [] a = {22,63,22,54,102,1,38,36,89,98,99,200,36};
  mergeSort(a);
  System.out.println(Arrays.toString(a));
 }

 public static void mergeSort(int []a){
  int[] tmp = new int[a.length];
  mergeSort(a,tmp,0,a.length - 1);
 }


 private static void mergeSort(int []a, int []tmp, int left, int right){
  if( left < right ){
   int center = (left + right) / 2;
   mergeSort(a, tmp, left, center);
   mergeSort(a, tmp, center + 1, right);
   merge(a, tmp, left, center + 1, right);
  }
 }


    private static void merge(int[]a,int[]tmp,int left,int right,int rightEnd ){
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd){
            if(a[left] < a[right])
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];
        }
        // Copy rest of first half
        while(left <= leftEnd)
            tmp[k++] = a[left++];
        
        // Copy rest of right half
        while(right <= rightEnd)  
            tmp[k++] = a[right++];

        // Copy temp array back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }
 }