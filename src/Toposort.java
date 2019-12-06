import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Toposort {
    private static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {
        boolean visited[] = new boolean[adj.length];
        ArrayList<Integer> order = new ArrayList<Integer>();

        for (int i = 0; i < adj.length; i++) {
            dfs(adj, visited, order, i);
        }

        return order;
    }

    private static void dfs(ArrayList<Integer>[] adj, boolean[] visited, ArrayList<Integer> order, int node) {

        if (!visited[node]) {
            visited[node] = true;
            for (int i = 0; i < adj[node].size(); i++) {
                dfs(adj, visited, order, adj[node].get(i));
            }

            order.add(node);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        ArrayList<Integer> order = toposort(adj);

        for (int i = order.size()-1; i >= 0; i--) {
            System.out.println((order.get(i)+1) + " s");
        }
    }
}

