import java.util.Arrays;

public class new_sort {
    public static void sort(int[]arr, int size){
        if (arr.length<=size)
            insertion_sort.sort(arr,arr.length);
        else if (arr.length>1){
            int mid =arr.length/2;
            int[] left = Arrays.copyOfRange(arr, 0, mid+1);
            int[] right = Arrays.copyOfRange(arr, mid+1, arr.length);
            new_sort.sort(left,size);
            new_sort.sort(right,size);
            int i,j,k;
            i=j=k=0;
            while(i<left.length && j<right.length){
                if (left[i]<=right[j]){
                    arr[k]=left[i];
                    i++;
                    Main.key_comparisons++;
                }
                else{
                    arr[k]=right[j];
                    j++;
                    Main.key_comparisons++;
                }
                k++;
            }
            while (i<left.length){
                arr[k]=left[i];
                k++;
                i++;
            } //copy remaining elements in left array
            while(j<right.length){
                arr[k]=right[j];
                k++;
                j++;
            } //copy remaining elements in right array

        }
    }
}
