import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Graph {

    private int V;
    private int E;
    private ArrayList<Integer>[] adj;

    private void init(int V) {
        this.V = V; this.E = 0;
        adj = new ArrayList[V];
        for (int v = 0; v < V; v++)
            adj[v] = new ArrayList<>();
    }

    public Graph(String fileName) {
        try {
            File file = new File(fileName);
            Scanner s = new Scanner(file);
            init(s.nextInt());
            int E = s.nextInt();
            for (int i = 0; i < E; i++) {
                int v = s.nextInt();
                int w = s.nextInt();
                addEdge(v, w);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int V() { return V; }
    public int E() { return E; }
    public Iterable<Integer> adj(int v) { return adj[v]; }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public String toString() {
        String s = V + " vertexes, " + E + " edges\n";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (int w : this.adj(v))
                s += w + " ";
            s += "\n";
        }
        return s;
    }

    public int degree(int v) {
        int degree = 0;
        for (int w : adj(v)) degree++;
        return degree;
    }

    public int maxDegree() {
        int max = 0;
        for (int v = 0; v < V; v++)
            if (max < degree(v))
                max = degree(v);
        return max;
    }

    public int avgDegree() {
        return 2 * E / V;
    }

    public int numberOfSelfLoops() {
        int count = 0;
        for (int v = 0; v < V; v++)
            for (int w : adj(v))
                if (v == w) count++;
        return count;
    }
}
