interface IEdgeWeightedGraph {
    int V();
    int E();
    void addEdge(Edge e);
    Iterable<Edge> adj(int v);
    String toString();
}
