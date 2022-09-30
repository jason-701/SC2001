import java.util.*;

public class dijkstraMatrix{
    private int V;
    public dijkstraMatrix(int V)
    {

        this.V = V;

    }
    void printMinpath(int[] path_array)   {
        System.out.println("Vertex# \t Minimum Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t\t " + path_array[i]);
    }

    public void dijkstra_matrix(int[][] graph, int source)
    {
        int[] path_array = new int[V];
        boolean[] shortestpathset = new boolean[V];

        //initiallyy all the distance are infinite and shortestpathset is false

        for(int i=0; i<V; i++)
        {
            path_array[i]=Integer.MAX_VALUE;
            shortestpathset[i]=false;
        }

        //path between vertex and itself is always 0
        path_array[source]= 0;
        int u;
        priorityQueueWithArray priorityQueueWithArray = new priorityQueueWithArray();
        int[] queue = priorityQueueWithArray.createQueue(V,path_array);
        int[] arr = new int[V];
        Heap heap = new Heap();
        heap.heapSort(arr,queue,V);
        while(!priorityQueueWithArray.isEmpty(queue,V)){
            u = priorityQueueWithArray.dequeue(queue,V);
            shortestpathset[u] = true;
            for(int v=0; v< V; v++)
            {
                //if the vertex is not in the shortestpathset then update
                if(!shortestpathset[v] && graph[u][v]!=0 && path_array[u] + graph[u][v] < path_array[v])
                {
                    path_array[v] = graph[u][v] + path_array[u];
                    priorityQueueWithArray.enqueue(queue,v,path_array[v]);
                }
            }
        }
        //shortest path for all vertices
        printMinpath(path_array);
        System.out.println("Hello");

    }

    public void dijkstraMatrixHeap(int[][] graph, int source)
    {
        int[] path_array = new int[V];
        boolean[] shortestpathset = new boolean[V];

        //initiallyy all the distance are infinite and shortestpathset is false

        for(int i=0; i<V; i++)
        {
            path_array[i]=Integer.MAX_VALUE;
            shortestpathset[i]=false;
        }

        //path between vertex and itself is always 0
        path_array[source]= 0;
        edges u;
        int uNode;
        priorityQueueHeap queue = new priorityQueueHeap();

        for (int i = 0; i < V; i++) {
            queue.enqueue(i,path_array[i]);
        }
        while(!queue.isEmpty()){
            u = queue.dequeue();
            uNode = u.getNode();
            shortestpathset[u.getNode()] = true;
            for(int v=0; v< V; v++)
            {
                //if the vertex is not in the shortestpathset then update
                if(!shortestpathset[v] && graph[uNode][v]!=0 && path_array[uNode] + graph[uNode][v] < path_array[v])
                {
                    path_array[v] = graph[uNode][v] + path_array[uNode];
                    queue.enqueue(v,path_array[v]);
                }
            }
        }
        //shortest path for all vertices
        printMinpath(path_array);

    }
}
