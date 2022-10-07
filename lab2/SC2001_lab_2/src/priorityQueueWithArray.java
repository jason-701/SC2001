import java.util.Arrays;

public class priorityQueueWithArray {
    public edges[] createQueue(int numOfVertex, int[] distance){
        edges [] arr = new edges[distance.length];
        for (int i = 0; i < distance.length; i++) {
            arr[i] = new edges(i,distance[i]);
        }
        sortArray(arr);
        return arr;
    }
    public void enqueue(edges[] arr, int vertex, int distance ){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getNode()==vertex){
                arr[i]=new edges(vertex,distance);
                break;
            }
        }
        Arrays.sort(arr);
    }

    public edges dequeue(edges[] arr){
        edges u = arr[0];
        arr[0] = new edges(u.getNode(),99999);
        Arrays.sort(arr);
        return u;
    }
    public boolean isEmpty(edges[] arr){
        return arr[0].getDistance() == 99999;
    }

    public void sortArray(edges[] arr){
        Arrays.sort(arr);
    }
}
