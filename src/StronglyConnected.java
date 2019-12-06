import java.util.*;

public class StronglyConnected {

    private static boolean[] visited;

    private static int numberOfStronglyConnectedComponents(ArrayList<Integer>[] adj) {
        List<Integer> reversePostOrder = postOrder(adj);
        int count = 0;
        visited = new boolean[adj.length];
        for (int i = reversePostOrder.size()-1; i >= 0; i--) {
            if (!visited[reversePostOrder.get(i)]) {
                count++;
                dfs(adj, new ArrayList<>(), reversePostOrder.get(i));
            }
        }
        return count;
    }

    private static List<Integer> postOrder(ArrayList<Integer>[] adj) {
        ArrayList[] reverseGraph = reverseGraph(adj);
        List<Integer> postOrder = new ArrayList<>();
        for (int i = 0; i < reverseGraph.length; i++) {
            dfs(reverseGraph, postOrder, i);
        }

        return postOrder;
    }

    private static void dfs(ArrayList<Integer>[] adj, List<Integer> order, int node) {

        if (!visited[node]) {
            visited[node] = true;
            for (int i = 0; i < adj[node].size(); i++) {
                dfs(adj,order,adj[node].get(i));
            }
            order.add(node);
        }

    }

    private static ArrayList<Integer>[] reverseGraph(ArrayList<Integer>[] adj) {
        ArrayList<Integer>[] adjT = new ArrayList[adj.length];

        for (int i = 0; i < adj.length; i++) {
            adjT[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int node = adj[i].get(j);
                adjT[node].add(i);
            }
        }

        return adjT;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        visited = new boolean[n];
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

        System.out.println(numberOfStronglyConnectedComponents(adj));
    }
}

