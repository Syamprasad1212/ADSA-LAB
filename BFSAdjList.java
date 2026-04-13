import java.util.*;   // Import Scanner, Queue, LinkedList classes

// Class for BFS traversal using Adjacency List
class BFSAdjList {

    int vertices;                    // Number of vertices
    LinkedList<Integer> adjList[];   // Array of linked lists to store graph

    // Constructor to initialize adjacency list
    BFSAdjList(int v) {

        vertices = v;                      // Set number of vertices
        adjList = new LinkedList[v];       // Create array of linked lists

        // Initialize each linked list
        for (int i = 0; i < v; i++)
            adjList[i] = new LinkedList<>();
    }

    // Function to add edge between two vertices
    void addEdge(int src, int dest) {

        adjList[src].add(dest);   // Add destination to source list
        adjList[dest].add(src);   // Add source to destination list (undirected graph)

        // Remove above line if graph is directed
    }

    // Function to perform BFS traversal
    void BFS(int start) {

        boolean visited[] = new boolean[vertices];  // Track visited vertices

        Queue<Integer> queue = new LinkedList<>();  // Create queue for BFS

        visited[start] = true;   // Mark starting vertex visited
        queue.add(start);        // Insert starting vertex into queue

        System.out.print("BFS Traversal: ");

        // Continue until queue becomes empty
        while (!queue.isEmpty()) {

            int node = queue.poll();   // Remove element from queue
            System.out.print(node + " ");   // Print current node

            // Visit all neighbors of current node
            for (int neighbor : adjList[node]) {

                // If neighbor not visited
                if (!visited[neighbor]) {

                    visited[neighbor] = true;   // Mark visited
                    queue.add(neighbor);        // Add to queue
                }
            }
        }
    }

    // Main method (program execution starts here)
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);   // Create Scanner object

        // Input number of vertices
        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();

        BFSAdjList g = new BFSAdjList(v);   // Create graph object

        // Input number of edges
        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        System.out.println("Enter edges (source destination):");

        // Input edges one by one
        for (int i = 0; i < e; i++) {

            int src = sc.nextInt();
            int dest = sc.nextInt();

            g.addEdge(src, dest);   // Add edge into graph
        }

        // Input starting vertex
        System.out.print("Enter starting vertex: ");
        int start = sc.nextInt();

        g.BFS(start);   // Call BFS function
    }
}