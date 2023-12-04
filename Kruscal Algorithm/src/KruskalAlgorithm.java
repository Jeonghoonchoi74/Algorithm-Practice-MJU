// Shortest Spanning Tree (MST) - Kruskal's Algorithm
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

public class KruskalAlgorithm {
    public static void main(String[] args) {
        List<Edge>[] graph = new ArrayList[5];

        // 그래프 초기화
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 간선 추가
        addEdge(graph, 0, 1, 2);
        addEdge(graph, 0, 3, 6);
        addEdge(graph, 1, 2, 3);
        addEdge(graph, 1, 3, 8);
        addEdge(graph, 1, 4, 5);
        addEdge(graph, 2, 3, 7);
        addEdge(graph, 3, 4, 9);

        kruskalMST(graph);
    }

    private static void addEdge(List<Edge>[] graph, int src, int dest, int weight) {
        graph[src].add(new Edge(src, dest, weight));
        graph[dest].add(new Edge(dest, src, weight));
    }

    private static void kruskalMST(List<Edge>[] graph) {
        int vertices = graph.length;

        Edge[] edges = getEdges(graph);
        Arrays.sort(edges);

        int[] parent = new int[vertices];
        Arrays.fill(parent, -1);

        Edge[] result = new Edge[vertices - 1];
        int ecount = 0;
        int k = 0;

        while (ecount < vertices - 1) {
            Edge nextEdge = edges[k++];
            int rootSrc = find(parent, nextEdge.src);
            int rootDest = find(parent, nextEdge.dest);

            if (rootSrc != rootDest) {
                result[ecount++] = nextEdge;
                union(parent, rootSrc, rootDest);
            }
        }

        printMST(result);
    }

    private static Edge[] getEdges(List<Edge>[] graph) {
        int edgeCount = 0;
        for (List<Edge> edges : graph) {
            edgeCount += edges.size();
        }

        Edge[] result = new Edge[edgeCount];
        int index = 0;
        for (List<Edge> edges : graph) {
            for (Edge edge : edges) {
                result[index++] = edge;
            }
        }

        return result;
    }

    private static int find(int[] parent, int vertex) {
        if (parent[vertex] == -1) {
            return vertex;
        }
        return find(parent, parent[vertex]);
    }

    private static void union(int[] parent, int rootSrc, int rootDest) {
        parent[rootSrc] = rootDest;
    }

    private static void printMST(Edge[] result) {
        System.out.println("Edge \tWeight");
        for (Edge edge : result) {
            System.out.println(edge.src + " - " + edge.dest + "\t" + edge.weight);
        }
    }
}
