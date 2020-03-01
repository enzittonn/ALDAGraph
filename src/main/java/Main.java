public class Main {

    public static void main(String[] args) {

        String[] nodes = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };

        MyUndirectedGraph graph = new MyUndirectedGraph();

        for (String node : nodes) {
            graph.add(node);
        }


        graph.connect("A", "A", 1);
        graph.connect("A", "G", 3);
        graph.connect("G", "B", 28);
        graph.connect("B", "F", 5);
        graph.connect("F", "F", 3);
        graph.connect("F", "H", 1);
        graph.connect("H", "D", 1);
        graph.connect("H", "I", 3);
        graph.connect("D", "I", 1);
        graph.connect("B", "D", 2);
        graph.connect("B", "C", 3);
        graph.connect("C", "D", 5);
        graph.connect("E", "C", 2);
        graph.connect("E", "D", 2);
        graph.connect("J", "D", 5);



        //System.out.println(graph.getCost("A", "A"));
        //System.out.println(graph.getCost("A", "G"));
        System.out.println(graph.getCost("G", "B"));
        System.out.println(graph.getCost("B", "F"));
        System.out.println(graph.getCost("F", "F"));
        System.out.println(graph.getCost("F", "H"));
        System.out.println(graph.getCost("H", "D"));
        System.out.println(graph.getCost("H", "I"));






    }


}
