import java.util.*;

class GraphColoring {

    int V;            // number of vertices
    int[] color;      // stores color assigned to each vertex
    int[][] graph;    // adjacency matrix representation

    GraphColoring(int V) {

        this.V = V;
        color = new int[V];
        graph = new int[V][V];
    }

    boolean isSafe(int v, int c) {
        // Check if assigning color c to vertex v is safe

        for (int i = 0; i < V; i++) {

            if (graph[v][i] == 1 && color[i] == c)
                // Adjacent vertex already has same color
                return false;
        }

        return true;
    }

    boolean solveColoring(int v, int m) {
        // Recursive function to assign colors

        if (v == V)
            // All vertices are colored
            return true;

        for (int c = 1; c <= m; c++) {
            // Try all colors from 1 to m

            if (isSafe(v, c)) {

                color[v] = c;
                // Assign color

                if (solveColoring(v + 1, m))
                    // Recur for next vertex
                    return true;

                color[v] = 0;
                // Backtrack if solution not found
            }
        }

        return false;
    }

    void printSolution() {

        System.out.println("Vertex Colors:");

        for (int i = 0; i < V; i++)
            System.out.println("Vertex " + i +
                               " → Color " + color[i]);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        GraphColoring obj = new GraphColoring(V);

        System.out.println("Enter adjacency matrix:");

        for (int i = 0; i < V; i++) {

            for (int j = 0; j < V; j++) {

                obj.graph[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter number of colors: ");
        int m = sc.nextInt();

        if (obj.solveColoring(0, m)) {

            System.out.println("\nSolution exists:");
            obj.printSolution();

        } else {

            System.out.println("\nNo solution exists.");
        }
    }
}
