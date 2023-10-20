import java.util.*;

class Result {

    public static String sExpression(String nodes) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Set<Character> nodesSet = new HashSet<>();

        String[] pairs = nodes.split(" ");
        for (String pair : pairs) {
            char parent = pair.charAt(1);
            char child = pair.charAt(3);

            if (parent == child) {
                return "E2";
            }

            nodesSet.add(parent);
            nodesSet.add(child);

            if (graph.containsKey(parent)) {
                Set<Character> children = graph.get(parent);
                if (children.size() == 2) {
                    return "E1";
                }
                if (children.contains(child)) {
                    return "E2";
                }
                children.add(child);
                graph.put(parent, children);
            } else {
                Set<Character> children = new HashSet<>();
                children.add(child);
                graph.put(parent, children);
            }
        }

        Set<Character> parents = new HashSet<>();
        for (Character parent : graph.keySet()) {
            if (graph.get(parent).size() > 2) {
                return "E1";
            }
            parents.add(parent);
        }

        parents.removeAll(graph.values().stream().flatMap(Set::stream).collect(Collectors.toSet()));

        if (parents.size() != 1) {
            return "E4";
        }

        Character root = parents.iterator().next();

        Set<Character> visited = new HashSet<>();
        if (isCyclic(graph, root, visited, null)) {
            return "E3";
        }

        StringBuilder sb = new StringBuilder();
        buildSExpression(graph, root, sb, new HashSet<>());
        return sb.toString();
    }

    private static boolean isCyclic(Map<Character, Set<Character>> graph, Character curr, Set<Character> visited, Character parent) {
        if (visited.contains(curr)) {
            return true;
        }
        visited.add(curr);

        if (!graph.containsKey(curr)) {
            return false;
        }

        for (Character child : graph.get(curr)) {
            if (child != parent && isCyclic(graph, child, visited, curr)) {
                return true;
            }
        }

        visited.remove(curr);
        return false;
    }

    private static void buildSExpression(Map<Character, Set<Character>> graph, Character root, StringBuilder sb, Set<Character> visited) {
        if (visited.contains(root)) {
            return;
        }

        sb.append("(");
        sb.append(root);

        visited.add(root);
        if (graph.containsKey(root)) {
            List<Character> children = new ArrayList<>(graph.get(root));
            Collections.sort(children);
            for (Character child : children) {
                buildSExpression(graph, child, sb, visited);
            }
        }

        sb.append(")");
    }
}
