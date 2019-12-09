import java.util.*;

public class Bipartite {

    private static int bipartite(ArrayList<Integer>[] adj) {

        int[] color = new int[adj.length];

        for (int i = 0; i < adj.length; i++) {
            if (color[i] == 0) {
                if (!isBipartiteHelper(i, color, adj)) {
                    return 0;
                }
            }
        }

        return 1;
    }

    private static boolean isBipartiteHelper(int node, int[] color, ArrayList<Integer>[] adj) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        color[node] = -1;

        while (!queue.isEmpty()) {
            int n = queue.poll();

            for (int i : adj[n]) {
                if (color[i] == 0) {
                    queue.add(i);
                    color[i] = -color[n];
                } else if (color[i] == color[n]){
                    return false;
                }
            }
        }

        return true;
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
        System.out.println(bipartite(adj));
    }
}

