//All Pair Shortest Path
public class Main {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] graph = {
                {0, 3, INF, INF, 7, INF, INF, INF},
                {INF, 0, 2, INF, INF, INF, 5, INF},
                {INF, INF, 0, 1, INF, INF, INF, 2},
                {INF, INF, INF, 0, 6, INF, 4, INF},
                {INF, INF, INF, INF, 0, INF, INF, INF},
                {INF, INF, INF, INF, INF, 0, INF, INF},
                {INF, INF, INF, INF, INF, 2, 0, 1},
                {INF, INF, INF, INF, INF, INF, INF, 0}
        };

        // Print the graph
        System.out.println("The input graph:");
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == INF) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(graph[i][j] + "\t");
                }
            }
            System.out.println();
        }

        int[][] result = floydWarshall(graph);
        // Add the shortest path to the graph
        System.out.println("\nThe shortest path:");
        // Print the result
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if (result[i][j] == INF) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(result[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    static int[][] floydWarshall(int[][] graph) {
        int V = graph.length;
        int[][] dist = new int[V][V];

        // Initialize the distance matrix with the given graph
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Update dist[][] to find the shortest path for all pairs
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        return dist;
    }
}