import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ConnectedComponents {

    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int[] p = new int[adj.length];

        for (int i = 1; i < adj.length; i++) {
            if (p[i] == 0) {
                p[i] = i;
                helper(i, adj, p);
            }
        }

        return connectedComponents(p);
    }

    private static void helper(int vertex, ArrayList<Integer>[] adj,  int[] p){

        for (int i = 0; i < adj[vertex].size(); i++){

            if (p[adj[vertex].get(i)] == 0) {
                p[adj[vertex].get(i)] = vertex;
                helper(adj[vertex].get(i), adj, p);
            }

        }

    }

    private static int connectedComponents(int[] p) {
        int count = 0;

        for (int i = 1; i < p.length; i++) {
            if (p[i] == i) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        System.out.println(numberOfComponents(adj));
    }
}

