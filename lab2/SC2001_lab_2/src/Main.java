/*
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;


public class Main {
    public static void create_array(int[] arr, int max, int min){
        Random rand= new Random(System.currentTimeMillis());
        for(int i=0; i<arr.length; i++)
        {
            arr[i]= rand.nextInt(max-min+1)+min;
        }
    }
    public static void print_Rand_array(int[] arr){
        for (int i=0;i<arr.length;i++){

            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
    //https://www.programiz.com/dsa/priority-queue   priority queue with heap
        int[] distance = new int[10];
        create_array(distance,50,1);
        print_Rand_array(distance);

        priorityQueueWithArray priorityQueueWithArray = new priorityQueueWithArray();
        int[] queue = priorityQueueWithArray.createQueue(10,distance);
        int min = priorityQueueWithArray.dequeue(queue,10);
        System.out.println(min);
        System.out.println(distance[min]);
        System.out.println(queue[min]);
    }
}*/


/*import java.util.*;

public class Main{
    public static void main(String[] args) {
        int V = 6;
        int source = 0;
        // adjacency list representation of graph
        List<List<dijkstra.Node>> adj_list = new ArrayList<List<Node> >();
        // Initialize adjacency list for every node in the graph
        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<Node>();
            adj_list.add(item);
        }


        // Input graph edges
        adj_list.get(0).add(new Node(1, 5));
        adj_list.get(0).add(new Node(2, 3));
        adj_list.get(0).add(new Node(3, 2));
        adj_list.get(0).add(new Node(4, 3));
        adj_list.get(0).add(new Node(5, 3));
        adj_list.get(2).add(new Node(1, 2));
        adj_list.get(2).add(new Node(3, 3));
        // call Dijkstra's algo method

        // Print the shortest path from source node to all the nodes
        System.out.println("The shorted path from source node to other nodes:");
        System.out.println("Source\t\t" + "Node#\t\t" + "Distance");
        for (int i = 0; i < dpq.dist.length; i++)
            System.out.println(source + " \t\t " + i + " \t\t "  + dpq.dist[i]);
    }
}

class Node implements Comparator<dijkstra.Node> {

    // Member variables of this class
    public int node;
    public int cost;

    // Constructors of this class

    // Constructor 1
    public Node() {}

    // Constructor 2
    public Node(int node, int cost)
    {

        // This keyword refers to current instance itself
        this.node = node;
        this.cost = cost;
    }


    @Override public int compare(dijkstra.Node node1, dijkstra.Node node2)
    {

        if (node1.cost < node2.cost)
            return -1;

        if (node1.cost > node2.cost)
            return 1;

        return 0;
    }
}*/

import java.util.*;
public class Main{

    public static void print_Rand_array(int V, int[][] arr){
        for (int i=0;i<V;i++){
            for (int j = 0; j < V; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] create_array(int V, int max, int min){
        Random rand= new Random(System.currentTimeMillis());
        int[][] arr = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                arr[i][j]= rand.nextInt(max-min+1)+min;
            }
        }
        for (int i = 0; i < V; i++) {
            arr[i][i]=0;
        }
        return arr;
    }
    
    static ArrayList<ArrayList<Integer>> matrixToAdjList(int[][] a)
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
                if (a[i][j] >0) {
                    adjListArray.get(i).add(j);
                }
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
   
    
    public static void main(String[] arg)   {
        int V;
        int source = 0;
        long start, end, timecomplex, startHeap, endHeap, timecomplexHeap;

        System.out.println("Enter the number of nodes: ");
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();

        /*int[][] graph = new int[][] { { 0, 2, 1, 0, 0, 0},
                { 2, 0, 7, 0, 8, 4},
                { 1, 7, 0, 7, 0, 3},
                { 0, 0, 7, 0, 8, 4},
                { 0, 8, 0, 8, 0, 5},
                { 0, 4, 3, 4, 5, 0} };*/
        int[][] graph = create_array(V,V,0);
        
        printArrayList(matrixToAdjList(graph));
        
        print_Rand_array(V,graph);
        dijkstraMatrix dijkstraMatrix = new dijkstraMatrix(V);

        timecomplex = dijkstraMatrix.dijkstra_matrix(graph,0);

        timecomplexHeap = dijkstraMatrix.dijkstraMatrixHeap(graph,0);

        System.out.println("Time taken to sort " + V + " number of nodes using priority queue: " + timecomplex + "ns");
        System.out.println("Time taken to sort " + V + " number of nodes using minHeap as priority queue: " + timecomplexHeap + "ns");
    }
}
