public class merge_sort {
    public static void merge(int[] arr, int start, int mid, int end){
        if (end-start <=0)
            return;
        int[] left_array = new int[mid-start+1]; //left half of original array from start to mid
        int[] right_array = new int[end-mid]; //right half of array from mid to end
        for (int i=0;i<mid-start+1;i++){
            left_array[i] = arr[start+i];
        } //copy contents of original array
        for (int j=0;j<end-mid;j++){
            right_array[j]=arr[mid+j+1];
        } //copy contents of original array

        int i,j,k;
        i=j=0;
        k=start;
        while(i<mid-start+1 && j<end-mid){
            if (left_array[i]<=right_array[j]){
                arr[k]=left_array[i];
                i++;
                Main.key_comparisons++;
            } //if element in left array is smaller
            else{
                arr[k]=right_array[j];
                j++;
                Main.key_comparisons++;
            } //if element in right array is smaller
            k++;
        }
        while (i<mid-start+1){
            arr[k]=left_array[i];
            k++;
            i++;
        } //copy remaining elements in left array
        while(j<end-mid){
            arr[k]=right_array[j];
            k++;
            j++;
        } //copy remaining elements in right array

    }
    public static void sort(int[] arr, int start, int end){
        int mid=0;
        if (end-start>=1){
            mid = (end-start)/2 + start;
            sort(arr,start,mid);
            sort(arr,mid+1,end);
            merge(arr,start,mid,end);
        }
    }

    public static void print_array(int[] arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
