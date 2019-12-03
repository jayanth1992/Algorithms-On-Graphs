import java.util.ArrayList;
import java.util.Scanner;

public class Acyclicity {

    private static boolean[] onStack;
    private static boolean[] visited;

    private static int acyclic(ArrayList<Integer>[] adj) {

        for (int i = 0; i < adj.length; i++) {
            if (has_cycle(i, adj)) {
                return 1;
            }
        }

        return 0;
    }

    private static boolean has_cycle(int node, ArrayList<Integer>[] adj) {

        if (onStack[node]) {
            return true;
        }

        if (!visited[node]) {
            onStack[node] = true;
            visited[node] = true;
            for (int i = 0; i < adj[node].size(); i++) {
                if (has_cycle(adj[node].get(i), adj)) {
                    return true;
                }
            }
            onStack[node] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        onStack = new boolean[n];
        visited = new boolean[n];
        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        System.out.println(acyclic(adj));
    }
}

