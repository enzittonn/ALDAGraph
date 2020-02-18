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
        return edges.size();
    }


    public boolean add(T newNode) {
        /** if the node exists, dont add **/
        if (graph.containsKey(newNode)) {
            System.out.println("Duplicate not added. \n");
            return false;
        }

        /** if it doesn't exist, add**/
        /** newNode as key, and create new ArrayList with Edge objects as value (adjacent list) **/
        graph.put(newNode, new ArrayList<>());
        System.out.println("Added\n");
        return true;
    }


    public boolean connect(T node1, T node2, int cost) {
        if (!graph.containsKey(node1) || !graph.containsKey(node2) || cost <= 0) {
            System.out.println("Something doesnt exist");
            return false;
        }
        if (!isConnected(node1, node2)) {
            Edge<T> edge = new Edge<T>(node1, node2, cost);
            Edge<T> edgeBack = new Edge<T>(node2, node1, cost);
            graph.get(node1).add(new Edge<T>(node1, node2, cost));
            graph.get(node1).add(new Edge<T>(node2, node1, cost));
            edges.add(edge);
            edges.add(edgeBack);
            System.out.println("Wasn't connected, now connected");
            return true;
        } else {
            for (Edge edge : edges) {
                if (edge.source == node1 && edge.destination == node2 || edge.source == node2 && edge.destination == node1) {
                    edge.setCost(cost);
                    System.out.println("Newly connected");
                    return true;
                }
            }
        }
        return false;
    }


    public boolean isConnected(T node1, T node2) {
        for (Edge<T> edge : edges) {
            if (edge.source == node1 && edge.destination == node2
                    || edge.source == node2 && edge.destination == node1) {
                return true;
            }
        }

        return false;
    }


    public int getCost(T node1, T node2) {
        if ((!isConnected(node1, node2) || !graph.containsKey(node1) || !graph.containsKey(node2)))
            return -1;

        int cost = 0;
        for (Edge edge : edges) {
            if (edge.source == node1 && edge.destination == node2 || edge.source == node2 && edge.destination == node1)
                cost = edge.cost;
            return cost;
        }
        return -1;
    }


    public List<T> depthFirstSearch(T start, T end) {
        ArrayList<T> visited = new ArrayList<>();
        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            return visited;
        }

        for (Edge<T> edge : edges)
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
        private int cost;

        public Edge(T source, T destination, int cost) {
            this.source = source;
            this.destination = destination;
            this.cost = cost;
        }

        public T getDestination() {
            return destination;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "source: " + source +
                    "destination: " + destination +
                    "\ncost: " + cost;
        }
    }


}




