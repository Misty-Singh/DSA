import java.util.Scanner;

public class MColoring {

    static boolean isSafe(int vertex, int color, int[] colors,
                          int[][] graph, int V) {

        for (int i = 0; i < V; i++) {

            if (graph[vertex][i] == 1 && colors[i] == color) {
                return false;
            }
        }

        return true;
    }

    static boolean colorGraph(int vertex, int V, int m,
                              int[][] graph, int[] colors) {

        // All vertices are colored
        if (vertex == V) {
            return true;
        }

        // Try every color
        for (int color = 1; color <= m; color++) {

            if (isSafe(vertex, color, colors, graph, V)) {

                // Assign color
                colors[vertex] = color;

                // Color next vertex
                if (colorGraph(vertex + 1, V, m, graph, colors)) {
                    return true;
                }

                // Backtrack
                colors[vertex] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        int[][] graph = new int[V][V];

        System.out.println("\nEnter edges:");

        for (int i = 0; i < E; i++) {

            System.out.print("Edge " + (i + 1) + ": ");

            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        System.out.print("\nEnter number of colors: ");
        int m = sc.nextInt();

        int[] colors = new int[V];

        boolean result = colorGraph(0, V, m, graph, colors);

        if (result) {

            System.out.println("\nGraph can be colored using " + m + " colors.");

            System.out.println("\nColor Assignment:");

            for (int i = 0; i < V; i++) {
                System.out.println("Vertex " + i + " -> Color " + colors[i]);
            }

        } else {

            System.out.println("\nGraph cannot be colored using " + m + " colors.");
        }

        sc.close();
    }
}