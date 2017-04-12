import java.util.*;

// TODO : поиск в ширину стр 486

public class DepthISearch implements ISearch, IPath {
    //private Graph G;
    private int s;
    private boolean[] marked;
    private int countLinked;
    private int[] edgeTo;

    DepthISearch(Graph G, int s) {
        //this.G = G;
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G, s);
    }
    private void dfs(Graph G, int v) {
        marked[v] = true;
        countLinked++;
        for (int w : G.adj(v))
            if (!marked[w]) dfs(G, w);
    }
    public boolean marked(int v) {
        return marked[v];
    }
    public int countLinked() {
        return countLinked;
    }
    public boolean hasPathTo(int v) {
        return marked[v];
    }
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v))
            return null;
        Stack<Integer> path = new Stack<>();
        for (int i = v; i != s; i = edgeTo[i])
            path.push(i);
        path.push(s);
        return path;
    }
    /*public setVertex(int v) {
        this.v = v;
    }*/
}
