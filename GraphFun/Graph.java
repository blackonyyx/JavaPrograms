import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
public class Graph<T> {
    // Map Contains a hashmap of nodes as keys and as values another map of Neighbour Nodes 
    // and weights
    Map<Node<T>,Map<Node<T>,Double>> graph;
    private Graph(){
        this.graph = new HashMap<Node<T>,Map<Node<T>,Double>>();
    }
    public void addNode(T value){
        Node<T> n = new Node<>(value);
        Map<Node<T>,Double> neighbours = new HashMap<Node<T>,Double>();
        this.graph.put(n,neighbours);
        System.out.println("Added new Node");
    }
    /**
     * The addNeighbours class is a class with a overloaded method for both an implementation that contains 
     * a directed graph as well as an implementation for a undirected graph
     */

    public void addNeighbours(Node<T> node,Node<T> neighbour){
        //Verson for undirected Graph Implementation
         if (!this.graph.containsKey(neighbour)){
              System.out.println("Graph does not originally contain node\nAdding automatically");
              this.addNode(neighbour.getValue());
              this.addNeighbours(node,neighbour,Double.valueOf(1));
         }else{
             this.graph.get(node).put(neighbour,Double.valueOf(1));
             this.graph.get(neighbour).put(node,Double.valueOf(1));
         }
    }

    public void addNeighbours(Node<T> node,Node<T> neighbour,Double weight){
        //Version for undirected Graph Implementation
         if (!this.graph.containsKey(neighbour)){
              System.out.println("Graph does not originally contain node\nAdding automatically");
              this.addNode(neighbour.getValue());
              this.addNeighbours(node,neighbour,weight);
         }else{
             this.graph.get(node).put(neighbour,weight);
             this.graph.get(neighbour).put(node,weight);
         }
    }

    public void addNeighbours(Node<T> node,Node<T> neighbour,Double nodeToNeighbour,Double neighbourToNode){
        //For a directed graph
         if (!this.graph.containsKey(neighbour)){
              System.out.println("Graph does not originally contain node\nAdding automatically");
              this.addNode(neighbour.getValue());
              this.addNeighbours(node,neighbour,nodeToNeighbour,neighbourToNode);
         }else{
             this.graph.get(node).put(neighbour,nodeToNeighbour);
             this.graph.get(neighbour).put(node,neighbourToNode);
         }
    }
    public boolean containsNode(Node<T> n){
        return this.graph.containsKey(n);
    }
    /**
     * Checks if a node has a query neighbour
     */
    public boolean neighboursNode(Node<T> node, Node<T> neigh){
        return this.graph.get(node).containsKey(neigh);
    }
    /**
     * If graph contains node, returns the neighbours hashmap
     */
    public Map<Node<T>,Double> getNeighbour(Node<T> n){
        if (containsNode(n)){
            return this.graph.get(n);
        }else{
            return null;
        }
    }
    /**
     * Gets the weight of a node neighbouring a query node
     */
    public Double getNeighbourWeight(Node<T> n,Node<T> neighbour){
        return getNeighbour(n).get(neighbour);
    }
    public String toString(){
        StringBuilder s = new StringBuilder("Graph\n");
        for (Map.Entry<Node<T>,Map<Node<T>,Double>> e : graph.entrySet()){
            s.append(e.getKey().toString()+": ");
            for (Map.Entry<Node<T>,Double> nei : e.getValue().entrySet()){
                s.append("Node"+nei.getKey()+" Weight: "+nei.getValue());
            }
            s.append("\n");
        }
        return s.toString();
    }
}
