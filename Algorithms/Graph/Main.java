public class Main {
    public static void main(String[] args) {

        // regular graph

        Graph graph = new Graph("tinyG.txt");
        System.out.println(graph.toString());
        System.out.println(graph.maxDegree());

        int chosenVertex = 0;
        DepthISearch search = new DepthISearch(graph, chosenVertex);
        System.out.println(chosenVertex + " vertex connected to : ");
        for (int w = 0; w < graph.V(); w++)
            if (search.marked(w))
                System.out.print(w + " ");
        if (search.countLinked() == graph.V())
            System.out.println("Complete graph");
        else
            System.out.println("Not a complete graph");

        // weighted graph

        EdgeWeightedGraph ewg = new EdgeWeightedGraph("tinyEWG.txt");
        System.out.println(ewg.toString());

        LazyPrimMST lazyMST = new LazyPrimMST(ewg);
        for (Edge e : lazyMST.edges())
            System.out.print(e + "\t");
        System.out.println("\n" + lazyMST.weight());

        PrimMST MST = new PrimMST(ewg);
        for (Edge e : lazyMST.edges())
            System.out.print(e + "\t");
        System.out.println("\n" + lazyMST.weight());
    }
}
