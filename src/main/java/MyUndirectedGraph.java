// Nyamgarig Naranbaatar nyna2000
// Samarbete Mosleh Mahamud moma1820

import java.util.*;

public class MyUndirectedGraph<T> implements UndirectedGraph<T> {
    private Map<T, Map<T, Integer>> graphMap = new HashMap<T, Map<T, Integer>>();

    @Override
    public int getNumberOfNodes() {
        return graphMap.size();
    }

    @Override
    public int getNumberOfEdges() {
        for (Map.Entry<T, Map<T, Integer>> n : graphMap.entrySet())
            return n.getValue().size();
        return 0;
    }

    @Override
    public boolean add(T newNode) {
        // If newNode exists already - return false;
        if (graphMap.containsKey(newNode))
            return false;

        // Else add
        graphMap.put(newNode, new HashMap<T, Integer>());
        return true;
    }

    @Override
    public boolean connect(T node1, T node2, int cost) {
        if (!graphMap.containsKey(node1) || !graphMap.containsKey(node2) || cost <= 0)
            return false;

        Map<T, Integer> source = graphMap.get(node1);
        Map<T, Integer> destination = graphMap.get(node2);

        destination.put(node1, cost);
        graphMap.put(node2, destination);

        source.put(node2, cost);
        graphMap.put(node1, source);

        return true;
    }

    @Override
    public boolean isConnected(T node1, T node2) {
        if (!graphMap.containsKey(node1) || !graphMap.containsKey(node2))
            return false;

        return graphMap.get(node1).containsKey(node2) || graphMap.get(node2).containsKey(node1);
    }

    @Override
    public int getCost(T node1, T node2) {
        if (!isConnected(node1, node2)) {
            return -1;
        } else {
            for (Map.Entry<T, Integer> edge : graphMap.get(node1).entrySet())
                if (edge.getKey() == node2 || edge.getKey().equals(node2))
                    return edge.getValue();
        }
        return -1;
    }

    @Override
    public List<T> depthFirstSearch(T start, T end) {

        ArrayList<T> empty = new ArrayList<>();

        ArrayList<T> v = new ArrayList<T>();

        ArrayList<T> b = new ArrayList<T>();


        depthFirstSearch(start, end, b, v);

        v.add(start);

        Collections.reverse(v);

        if (v.contains(end)) {
            return v;
        } else
            return empty;
    }

    private boolean depthFirstSearch(T s, T d, ArrayList<T> b, ArrayList<T> ts) {

        b.add(s);
        //
        if (s == d) {
            return true;
        }

        for (Map.Entry<T, Integer> e : graphMap.get(s).entrySet()) {
            // edge.get() -> node -  soruce and destination
            if (!b.contains(e.getKey())) {
                if (depthFirstSearch(e.getKey(), d, b, ts)) {
                    ts.add(e.getKey());
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<T> breadthFirstSearch(T start, T end) {

        ArrayList<T> v = new ArrayList<>();
        Queue<T> q = new LinkedList<>();
        ArrayList<T> b = new ArrayList<>();

        q.add(start);
        b.add(start);

        breadthFirstSearch(end, q, v, b);

        return v;

    }

    private void breadthFirstSearch(T d, Queue<T> q, ArrayList<T> v, ArrayList<T> b) {
        for (T n : b) {
            for (Map.Entry<T, Integer> e : graphMap.get(n).entrySet()) {
                // e.getKey() -> neighbours; destinations
                if (!v.contains(e.getKey()))
                    // add to the queue
                    q.add(e.getKey());
            }
        }

        b.clear();
        boolean ex = false;

        while (!q.isEmpty()) {
            T f = q.remove();
            v.add(f);
            b.add(f);

            if (f == d) {

                ex = true;

                for (int i = v.size() - 1; i > 0; i--) {
                    if (!isConnected(v.get(i), v.get(i - 1)))
                        v.remove(i - 1);
                }

                for (int k = v.size() - 1; k > 1; k--) {
                    if (isConnected(v.get(k), v.get(k - 2)))
                        v.remove(k - 1);
                }
                break;
            }
        }

        if (!ex)
            breadthFirstSearch(d, q, v, b);
    }


    @Override
    public UndirectedGraph<T> minimumSpanningTree() {
        MyUndirectedGraph<T> tree = new MyUndirectedGraph<>();

        ArrayList<T> v = new ArrayList<>();

        Map.Entry<T, Map<T, Integer>> current = graphMap.entrySet().iterator().next();

        tree.add(current.getKey());
        v.add(current.getKey());
        minimumSpanningTree(tree, v);

        return tree;
    }

    private void minimumSpanningTree(UndirectedGraph<T> tree, ArrayList<T> vs) {

        T n = null;
        int m = Integer.MAX_VALUE;
        T d = null;


        if (tree.getNumberOfNodes() >= graphMap.size()) {
        } else {


            for (T v : vs) {
                for (Map.Entry<T, Integer> e : graphMap.get(v).entrySet()) {
                    if (e.getValue() < m && !vs.contains(e.getKey())) {

                        m = e.getValue();
                        d = e.getKey();
                        n = v;
                    }
                }

            }

            if (d != null) {
                tree.add(d);
                tree.connect(n, d, m);
            }

            vs.add(d);

            minimumSpanningTree(tree, vs);
        }
    }
}
