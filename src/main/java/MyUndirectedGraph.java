import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyUndirectedGraph<T> implements UndirectedGraph<T> {

    /** hashmap that takes generic type as key, and list with Edge objects **/
    /**
     * graph HashMap contains Node objects as key, adjacent list of Edge objects as value
     **/
    private Map<T, List<Edge<T>>> graph = new HashMap<>();
    private List<Edge<T>> edges = new ArrayList<>();
    private boolean visited;


    public int getNumberOfNodes() {
        return graph.keySet().size();
    }


    public int getNumberOfEdges() {
        return graph.entrySet().size();
    }


    public boolean add(T newNode) {
        /** if the node exists, dont add **/
        if (graph.containsKey(newNode))
            return false;

        /** if it doesn't exist, add**/
        /** newNode as key, and create new ArrayList with Edge objects as value (adjacent list) **/
        graph.put(newNode, new ArrayList<>());
        return true;
    }


    public boolean connect(T node1, T node2, int cost) {

        if (!graph.containsKey(node1) || !graph.containsKey(node2) || cost <= 0)
            return false;
        if (!isConnected(node1, node2)) {
            Edge<T> edge = new Edge<T>(node1, node2, cost);
            graph.get(node1).add(new Edge<T>(node1, node2, cost));
            graph.get(node1).add(new Edge<T>(node2, node1, cost));
            edges.add(edge);
        } else {
            for (Edge edge : edges) {
                if (edge.source == node1 && edge.destination == node2 || edge.source == node2 && edge.destination == node1) {
                    edge.setCost(cost);
                    return true;
                }
            }
        }
        return false;
    }


    public boolean isConnected(T node1, T node2) {
        return graph.get(node1).contains(node2);
    }


    public int getCost(T node1, T node2) {
        for (Edge edge : edges) {
            if (edge.source == node1 && edge.source == node2
                    || edge.source == node2 && edge.source == node1)
                return edge.getCost();
        }
        return -1;

    }


    public List<T> depthFirstSearch(T start, T end) {
        return null;
    }


    public List<T> breadthFirstSearch(T start, T end) {
        return null;
    }


    public UndirectedGraph<T> minimumSpanningTree() {
        return null;
    }


    private class Edge<T> {
        private T source;
        private T destination;
        private int weight;

        public Edge(T source, T destination, int cost) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        public T getDestination() {
            return destination;
        }

        public int getCost() {
            return weight;
        }

        public void setCost(int cost) {
            this.weight = cost;
        }

        @Override
        public String toString() {
            return "source: " + source +
                    "destination: " + destination +
                    "\ncost: " + weight;
        }
    }


}




