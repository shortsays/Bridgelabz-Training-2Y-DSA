import java.util.*;

class CityNetwork {
    static class Edge {
        String to;
        int wt;
        Edge(String t, int w) {
            to = t;
            wt = w;
        }
    }

    Map<String, List<Edge>> graph = new HashMap<>();

    void addEdge(String u, String v, int w, boolean bidir) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.get(u).add(new Edge(v, w));

        if (bidir) {
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(v).add(new Edge(u, w));
        }
    }

    void bfs(String start) {
        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        q.add(start);
        vis.add(start);

        while (!q.isEmpty()) {
            String curr = q.poll();
            System.out.print(curr + " ");

            for (Edge e : graph.getOrDefault(curr, new ArrayList<>())) {
                if (!vis.contains(e.to)) {
                    vis.add(e.to);
                    q.add(e.to);
                }
            }
        }
    }

    public static void main(String[] args) {
        CityNetwork g = new CityNetwork();

        g.addEdge("A", "B", 5, false);
        g.addEdge("B", "C", 3, true);
        g.addEdge("A", "D", 7, true);
        g.addEdge("D", "E", 2, false);
        g.addEdge("C", "E", 4, false);

        g.bfs("A");
    }
}