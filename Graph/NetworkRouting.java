import java.util.*;

class NetworkRouting {
    Map<String, List<String>> graph = new HashMap<>();

    void addEdge(String u, String v) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.putIfAbsent(v, new ArrayList<>());
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    boolean isConnected() {
        Set<String> vis = new HashSet<>();
        String start = graph.keySet().iterator().next();
        dfs(start, vis);
        return vis.size() == graph.size();
    }

    void dfs(String node, Set<String> vis) {
        vis.add(node);
        for (String nei : graph.get(node)) {
            if (!vis.contains(nei))
                dfs(nei, vis);
        }
    }

    int bfsHops(String start, String end) {
        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        q.add(start);
        vis.add(start);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i=0;i<size;i++) {
                String curr = q.poll();
                if (curr.equals(end)) return level;

                for (String nei : graph.get(curr)) {
                    if (!vis.contains(nei)) {
                        vis.add(nei);
                        q.add(nei);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        NetworkRouting g = new NetworkRouting();

        g.addEdge("R1","R2");
        g.addEdge("R1","R3");
        g.addEdge("R2","R4");
        g.addEdge("R3","R4");
        g.addEdge("R4","R5");
        g.addEdge("R5","R6");

        System.out.println(g.isConnected());
        System.out.println(g.bfsHops("R1","R6"));
    }
}