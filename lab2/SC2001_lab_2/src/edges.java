import java.util.Comparator;

public class edges implements Comparable<edges> {
    private int node,distance;
    public edges(int node, int distance){
        this.node = node;
        this.distance = distance;
    }
    public int getNode(){
        return this.node;
    }
    public int getDistance(){
        return this.distance;
    }

    @Override
    public int compareTo(edges o) {
        return this.distance-o.distance;
    }
}
