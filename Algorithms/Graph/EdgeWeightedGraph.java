import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class EdgeWeightedGraph implements IEdgeWeightedGraph {

    private int V;
    private int E;
    private ArrayList<Edge>[] adj;

    private void init(int V) {
        this.V = V; this.E = 0;
        adj = new ArrayList[V];
        for (int v = 0; v < V; v++)
            adj[v] = new ArrayList<>();
    }
    public EdgeWeightedGraph(String fileName) {
        try {
            File file = new File(fileName);
            Scanner s = new Scanner(file);
            s.useLocale(Locale.US);
            init(s.nextInt());
            int E = s.nextInt();
            for (int i = 0; i < E; i++) {
                int v = s.nextInt();
                int w = s.nextInt();
                double weight = s.nextDouble();
                Edge edge = new Edge(v, w, weight);
                addEdge(edge);
            }
        } catch (Exception e) {
            System.out.println("Exception while reading graph : " + e);
        }
    }
    public int V() { return V; }
    public int E() { return E; }
    public void addEdge(Edge e) {
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }
    public Iterable<Edge> adj(int v) { return adj[v]; }
    public Iterable<Edge> edges() {
        ArrayList<Edge> b = new ArrayList<>();
        for (int v = 0; v < V; v++)
            for (Edge e : adj[v])
                if (e.other(v) > v)
                    b.add(e);
        return b;
    }
    public String toString() {
        String stringGraph = "";
        for (ArrayList<Edge> bag  : adj) {
            for (Edge e : bag)
                stringGraph += e.toString() + " ";
            stringGraph += "\n";
        }
        return stringGraph;
    }
}
