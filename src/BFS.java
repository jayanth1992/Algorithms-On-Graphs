import java.util.*;

public class BFS {
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {

        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[adj.length];
        Arrays.fill(dist, -1);
        dist[s] = 0;

        queue.add(s);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i = 0; i < adj[node].size(); i++) {
                if (dist[adj[node].get(i)] == -1) {
                    queue.add(adj[node].get(i));
                    dist[adj[node].get(i)] = dist[node] + 1;
                }
            }
        }

        return dist[t];
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
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, x, y));
    }
}

