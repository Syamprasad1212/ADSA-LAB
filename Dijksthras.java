import java.util.*;

class DijkstraAlgorithm {

    int minDistance(int dist[], boolean visited[], int V) {
        // Function to find vertex with minimum distance

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < V; i++) {

            if (!visited[i] && dist[i] < min) {
                // Select smallest unvisited distance

                min = dist[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    void dijkstra(int graph[][], int src, int V) {
        // Function to implement Dijkstra's algorithm

        int dist[] = new int[V];
        // Stores shortest distances from source

        boolean visited[] = new boolean[V];
        // Tracks visited vertices

        Arrays.fill(dist, Integer.MAX_VALUE);
        // Initialize all distances as infinity

        dist[src] = 0;
        // Distance from source to itself is 0

        for (int count = 0; count < V - 1; count++) {

            int u = minDistance(dist, visited, V);
            // Pick minimum distance vertex

            visited[u] = true;
            // Mark as visited

            for (int v = 0; v < V; v++) {

                if (!visited[v] &&
                    graph[u][v] != 0 &&
                    dist[u] != Integer.MAX_VALUE &&
                    dist[u] + graph[u][v] < dist[v]) {

                    // Update shortest distance

                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        System.out.println("\nVertex\tDistance from Source");

        for (int i = 0; i < V; i++)
            System.out.println(i + "\t" + dist[i]);
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        int graph[][] = new int[V][V];

        System.out.println("Enter adjacency matrix:");

        for (int i = 0; i < V; i++) {

            for (int j = 0; j < V; j++) {

                graph[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter source vertex: ");
        int src = sc.nextInt();

        DijkstraAlgorithm obj = new DijkstraAlgorithm();

        obj.dijkstra(graph, src, V);
    }
}
