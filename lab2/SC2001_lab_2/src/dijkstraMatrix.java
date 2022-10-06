import java.util.*;

public class dijkstraMatrix{
    private int V;
    public dijkstraMatrix(int V)
    {

        this.V = V;

    }

    public String shortestPath(int[] predecessor, int n, int source, String path)
    {
        int pi = predecessor[n];
        if (pi != source)
        {
            shortestPath(predecessor, pi, source, path);
        }
        else
            return path;
        path += " -> " + pi;

        return path;
    }

    void printMinpath(int[] path_array, int[] predecessor, int source)   {
        System.out.println("Vertex# \t Minimum Distance from Source \t Shortest Path from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t\t " + path_array[i] + " \t\t\t\t " + shortestPath(predecessor, i, source, String.valueOf(source)) + " -> " + i);
    }

    public long dijkstra_matrix(int[][] graph, int source)
    {
        int[] path_array = new int[V];
        boolean[] shortestpathset = new boolean[V];
        int[] predecessor = new int[V];
        long start, end;

        //initiallyy all the distance are infinite and shortestpathset is false

        for(int i=0; i<V; i++)
        {
            path_array[i]=Integer.MAX_VALUE;
            shortestpathset[i]=false;
            predecessor[i] = 0;
        }

        //path between vertex and itself is always 0
        path_array[source]= 0;
        start = System.nanoTime();
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
                    predecessor[v] = u;
                    priorityQueueWithArray.enqueue(queue,v,path_array[v]);
                }
            }
        }
        //shortest path for all vertices
        end = System.nanoTime();
        // printMinpath(path_array, predecessor, source);
        System.out.println("Hello");

        return end-start;
    }

    public long dijkstraMatrixHeap(int[][] graph, int source)
    {
        int[] path_array = new int[V];
        boolean[] shortestpathset = new boolean[V];
        int[] predecessor = new int[V];
        long start,end;
        ArrayList<ArrayList<Integer>> list= matrixToAdjList(graph);
       // printArrayList(list);
        //initiallyy all the distance are infinite and shortestpathset is false

        for(int i=0; i<V; i++)
        {
            path_array[i]=Integer.MAX_VALUE;
            shortestpathset[i]=false;
            predecessor[i] = 0;
        }

        //path between vertex and itself is always 0
        path_array[source]= 0;
        start = System.nanoTime();
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
                if(!shortestpathset[v] && list.get(uNode).get(v)!=0 && path_array[uNode] + list.get(uNode).get(v) < path_array[v])
                {
                    path_array[v] = list.get(uNode).get(v) + path_array[uNode];
                    predecessor[v] = uNode;
                    queue.enqueue(v,path_array[v]);
                }
            }
        }
        end = System.nanoTime();
        //shortest path for all vertices
        // printMinpath(path_array, predecessor, source);

        return end-start;
    }
    
    public static ArrayList<ArrayList<Integer>> matrixToAdjList(int[][] a)
    {
        
        int l = a[0].length;
        ArrayList<ArrayList<Integer>> adjListArray= new ArrayList<ArrayList<Integer>>(l);
 
        // Create a new list for each
        // vertex such that adjacent
        // nodes can be stored
        for (int i = 0; i < l; i++) {
            adjListArray.add(new ArrayList<Integer>());
        }
         
        int i, j;
        for (i = 0; i < a[0].length; i++) {
            for (j = 0; j < a.length; j++) {
               // if (a[i][j] >0) {
                    adjListArray.get(i).add(a[i][j]);
                //}
            }
        }
         
        return adjListArray;
    }
    
	static void printArrayList(ArrayList<ArrayList<Integer>> adjListArray) {
// Print the adjacency list
		for (int v = 0; v < adjListArray.size(); v++) {
			System.out.print(v);
			for (Integer u : adjListArray.get(v)) {
				System.out.print(" -> " + u);
			}
			System.out.println();
		}
	}
}
