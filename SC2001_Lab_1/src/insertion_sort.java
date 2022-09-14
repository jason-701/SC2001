public class insertion_sort {
    public static void sort (int arr[], int n)
    {
        int i, j, temp;

        for (i = 1; i < n; i++)
        {
            for(j = i; j > 0; j--)
            {
                //numcompare += 1;
                Main.key_comparisons++;
                if (arr[j] < arr[j-1])
                {
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                else
                    break;
            }
        }
    }
}
