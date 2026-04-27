import java.util.*;

class CoursePrerequisite {
    Map<String, List<String>> graph = new HashMap<>();

    void addEdge(String u, String v) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.get(u).add(v);
    }

    boolean hasCycle(String node, Set<String> vis, Set<String> rec) {
        vis.add(node);
        rec.add(node);

        for (String nei : graph.getOrDefault(node, new ArrayList<>())) {
            if (!vis.contains(nei) && hasCycle(nei, vis, rec)) return true;
            else if (rec.contains(nei)) return true;
        }

        rec.remove(node);
        return false;
    }

    List<String> topoSort() {
        Map<String, Integer> indeg = new HashMap<>();
        for (String u : graph.keySet()) {
            indeg.putIfAbsent(u, 0);
            for (String v : graph.get(u))
                indeg.put(v, indeg.getOrDefault(v, 0) + 1);
        }

        Queue<String> q = new LinkedList<>();
        for (String k : indeg.keySet())
            if (indeg.get(k) == 0) q.add(k);

        List<String> res = new ArrayList<>();

        while (!q.isEmpty()) {
            String curr = q.poll();
            res.add(curr);

            for (String nei : graph.getOrDefault(curr, new ArrayList<>())) {
                indeg.put(nei, indeg.get(nei) - 1);
                if (indeg.get(nei) == 0) q.add(nei);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CoursePrerequisite g = new CoursePrerequisite();

        g.addEdge("CS101", "CS102");
        g.addEdge("CS101", "CS201");
        g.addEdge("CS102", "CS202");
        g.addEdge("MATH101", "CS201");

        System.out.println(g.topoSort());
    }
}