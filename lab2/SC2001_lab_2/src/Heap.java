public class Heap
{
    public static void heapSort(int[] arr, int[] H, int n)
    {
        heapify(H, 1, n);

        int i, curMax;

        for (i=n-1; i>=0;i--)
        {
            curMax = H[0];
            deleteMax(H, n);
            arr[i] = curMax;
            n--;
        }
    }

    public static void deleteMax(int[] H, int n)
    {
        int k = n;

        fixHeap(H, 1, k, n-1);
    }

    public static void fixHeap(int[] H, int j, int k, int n)
    {
        int temp;
        int cj = leftSubTree(j);

        while (cj <= n)
        {
            if (cj < n && H[cj-1] < H[cj])
                cj++;

            if (H[k-1] >= H[cj-1])
                break;

            temp = H[j-1];
            H[j-1] = H[cj-1];
            H[cj-1] = temp;
            if (k == j)
                k = cj;
            j = cj;
            cj = leftSubTree(j);
        }

        temp = H[j-1];
        H[j-1] = H[k-1];
        H[k-1] = temp;
    }

    public static void heapify(int[] H, int j, int n)
    {
        int k;
        if(isLeaf(j, n) == 0)
        {
            heapify(H, leftSubTree(j), n);
            heapify(H, rightSubTree(j), n);
            k = j;
            fixHeap(H, j, k, n);
        }
    }

    public static int parent(int i)
    {
        return i/2;
    }

    public static int leftSubTree(int i)
    {
        return 2 * i;
    }

    public static int rightSubTree(int i)
    {
        return 2 * i + 1;
    }

    public static int isLeaf(int i, int n)
    {
        if (2*i > n)
            return 1;
        else
            return 0;
    }
}