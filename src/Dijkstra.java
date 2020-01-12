import java.util.*;

public class Dijkstra {

    private static class Node implements Comparable{

        int node;
        long distTo;

        Node(int node, long distTo) {
            this.node = node;
            this.distTo = distTo;
        }

        @Override
        public int compareTo(Object o) {
            return Long.compare(this.distTo, ((Node) o).distTo);
        }
    }

    private static long distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        boolean[] processed = new boolean[adj.length];
        int[] parent = new int[adj.length];
        long[] distTo = new long[adj.length];

        Arrays.fill(distTo, Long.MAX_VALUE);

        priorityQueue.add(new Node(s, 0));
        parent[s] = s;
        distTo[s] = 0;

        while (!priorityQueue.isEmpty()) {

            Node currNode = priorityQueue.poll();

            if (!processed[currNode.node]) {

                processed[currNode.node] = true;

                for(int i = 0; i < adj[currNode.node].size(); i++) {

                    int childNode = adj[currNode.node].get(i);
                    int costToChildNode = cost[currNode.node].get(i);

                    if (distTo[childNode] > (distTo[currNode.node] + costToChildNode)) {
                        distTo[childNode] = distTo[currNode.node] + costToChildNode;
                        parent[childNode] = currNode.node;

                        priorityQueue.add(new Node(childNode, distTo[childNode]));
                    }

                }

            }

        }

        return distTo[t] == Long.MAX_VALUE ? -1 : distTo[t];
    }

    private static List<Integer> path(int[] parent, int s, int t) {
        List<Integer> list = new ArrayList<>();
        list.add(t);

        while (parent[t] != s) {
            list.add(parent[t]);
            t = parent[t];
        }

        list.add(s);

        Collections.reverse(list);

        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, cost, x, y));
    }
}

