public class LazyPrimMST implements IMST {
    private boolean[] marked; // vertexes in tree
    private Queue<Edge> mst; // edges in tree
    private MinPQ<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph G) {
        pq = new MinPQ<>(0);
        marked = new boolean[G.V()];
        mst = new Queue<>();

        visit(G, 0);
        while (!pq.isEmpty()) {
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w])
                continue;
            mst.enqueue(e);
            if (!marked[v])
                visit(G, v);
            if (!marked[w])
                visit(G, w);
        }
    }
    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v))
            if (!marked[e.other(v)])
                pq.insert(e);
    }
    public Iterable<Edge> edges() { return mst; }
    public double weight() {
        double summaryWeight = 0;
        for (Edge e : mst)
            summaryWeight += e.weight();
        return summaryWeight;
    }
}
