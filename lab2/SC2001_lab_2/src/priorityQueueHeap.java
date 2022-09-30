import java.util.Comparator;
import java.util.PriorityQueue;

public class priorityQueueHeap {
    private PriorityQueue<edges> queue;
    public priorityQueueHeap(){
        queue = new PriorityQueue<edges>(Comparator.comparingInt(edges::getDistance));
        /*edges a = new edges(1,5);
        edges b = new edges(2,12);
        edges c = new edges(3,1);
        edges d = new edges(4,23);
        edges e = new edges(5,10);
        queue.add(b);
        queue.add(c);
        queue.add(d);
        queue.add(e);
        edges temp = queue.peek();
        System.out.println(temp.getNode());*/
    }
    public void enqueue(int node, int distance){
        edges a = new edges(node,distance);
        queue.add(a);
    }

    public edges dequeue(){
        return queue.poll();
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }
}
