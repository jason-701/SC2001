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
        long start,end;
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
        end = System.nanoTime();
        //shortest path for all vertices
        printMinpath(path_array, predecessor, source);
        return (end-start);

    }

    public long dijkstraMatrixHeap(int[][] graph, int source)
    {
        int[] path_array = new int[V];
        boolean[] shortestpathset = new boolean[V];
        int[] predecessor = new int[V];
        long start,end;
        ArrayList<ArrayList<edges>> list= matrixToAdjList(graph);
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
        edges u;
        start = System.nanoTime();
        int uNode;
        priorityQueueHeap queue = new priorityQueueHeap();

        for (int i = 0; i < V; i++) {
            queue.enqueue(i,path_array[i]);
        }
        while(!queue.isEmpty()){
            u = queue.dequeue();
            uNode = u.getNode();
            shortestpathset[uNode] = true;
            for (edges edge : list.get(uNode)){
                if(!shortestpathset[edge.getNode()] && path_array[uNode]+ edge.getDistance() < path_array[edge.getNode()]){
                    path_array[edge.getNode()] = path_array[uNode]+ edge.getDistance();
                    predecessor[edge.getNode()] = uNode;
                    queue.enqueue(edge.getNode(),path_array[edge.getNode()]);
                }
            }
        }
        //shortest path for all vertices
        end = System.nanoTime();
        printMinpath(path_array, predecessor, source);
        return (end-start);

    }
    
    public ArrayList<ArrayList<edges>> matrixToAdjList(int[][] a)
    {

        int l = a[0].length;
        ArrayList<ArrayList<edges>> adjListArray= new ArrayList<ArrayList<edges>>(l);

        // Create a new list for each
        // vertex such that adjacent
        // nodes can be stored
        for (int i = 0; i < l; i++) {
            adjListArray.add(new ArrayList<edges>());
        }
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (a[i][j]!=0){
                    edges u = new edges(j,a[i][j]);
                    adjListArray.get(i).add(u);
                }
            }
        }
        return adjListArray;
    }

}
