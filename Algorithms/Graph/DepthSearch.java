import java.util.*;

public class DepthSearch implements Search, Path {
    private boolean[] marked;
    private int count;
    private int[] edgeTo;
    private int start;

    DepthSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        start = s;
        dfs(G, start);
    }
    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for (int w : G.adj(v))
            if (!marked[w])
            {
                edgeTo[w] = v;
                dfs(G, w);
            }
    }
    public boolean marked(int v) {
        return marked[v];
    }
    public int count() {
        return count;
    }
    public boolean hasPathTo(int v) {
        return marked[v];
    }
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v))
            return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != start; x = edgeTo[x])
            path.push(x);
        path.push(start);
        return path;
    }
}
