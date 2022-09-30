import java.util.Arrays;

public class priorityQueueWithArray {
    public int[] createQueue(int numOfVertex, int[] distance){
        int [] arr = Arrays.copyOf(distance,numOfVertex);
        return arr;
    }
    public void enqueue(int[] arr, int vertex, int distance ){
        arr[vertex] = distance;
    }

    public int dequeue(int[] arr, int numberOfVertex){
        int index, distance;
        index = 0;
        distance = 999999;
        for (int i = 1; i < numberOfVertex; i++) {
            if (arr[i] < distance && arr[i] !=-1){
                distance = arr[i];
                index = i;
            }
        }
        arr[index] = -1;
        return index;
    }
    public boolean isEmpty(int[] arr, int numberOfVertex){
        for (int i = 0; i < numberOfVertex; i++) {
            if (arr[i]!=-1){
                return false;
            }
        }
        return true;
    }
}
