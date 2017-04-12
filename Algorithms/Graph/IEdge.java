interface IEdge extends Comparable<Edge> {
    double weight();
    int either();
    int other(int v);
    int compareTo(Edge that);
    String toString();
}
