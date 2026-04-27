import java.util.*;

class SocialNetwork {
    Map<String, List<String>> graph = new HashMap<>();

    void addEdge(String u, String v) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.putIfAbsent(v, new ArrayList<>());
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    List<String> getFriends(String user) {
        return graph.getOrDefault(user, new ArrayList<>());
    }

    boolean isDirectlyConnected(String u, String v) {
        return graph.containsKey(u) && graph.get(u).contains(v);
    }

    List<String> shortestPath(String start, String end) {
        Queue<String> q = new LinkedList<>();
        Map<String, String> parent = new HashMap<>();
        Set<String> visited = new HashSet<>();

        q.add(start);
        visited.add(start);

        while (!q.isEmpty()) {
            String curr = q.poll();
            if (curr.equals(end)) break;

            for (String nei : graph.getOrDefault(curr, new ArrayList<>())) {
                if (!visited.contains(nei)) {
                    visited.add(nei);
                    parent.put(nei, curr);
                    q.add(nei);
                }
            }
        }

        List<String> path = new ArrayList<>();
        String curr = end;
        while (curr != null) {
            path.add(curr);
            curr = parent.get(curr);
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        SocialNetwork g = new SocialNetwork();

        g.addEdge("Alice", "Bob");
        g.addEdge("Alice", "Charlie");
        g.addEdge("Bob", "David");
        g.addEdge("Charlie", "Eve");
        g.addEdge("David", "Eve");

        System.out.println(g.getFriends("Alice"));
        System.out.println(g.isDirectlyConnected("Bob", "Eve"));
        System.out.println(g.shortestPath("Alice", "Eve"));
    }
}