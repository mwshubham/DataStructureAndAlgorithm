package leetcode.problems.difficulty.hard;

import java.util.*;

public class AlienDictionary {

    /**
     * A B C D E F (Normal Dictionary)
     * D E F C B A (Alien Dictionary)
     */
    public String foreignDictionary(String[] words) {
        LinkedHashMap<Character, Node> map = new LinkedHashMap<>();
        LinkedHashMap<Character, Integer> inDegree = new LinkedHashMap<>();

        // Step 1: Build Graph
        for (String word : words) {
            Node prev = null;
            for (int j = 0; j < word.length(); j++) {
                Character ch = word.charAt(j);
                Node node = map.get(ch);
                // Create a new node if not exist and put into the map.
                if (node == null) {
                    node = new Node(ch);
                    map.put(ch, node);
                    // Initialize in-degree
                    inDegree.put(ch, 0);
                }
                // Add the newly created node to the prev children if available.
                if (prev != null && prev.ch != ch) {
                    if (!prev.children.contains(node)) {
                        prev.children.add(node);
                        inDegree.put(ch, inDegree.get(ch) + 1);
                    }
                }
                prev = node;
            }
        }

        // Step 2: Detect Cycle (Using DFS)
        if (hasCycle(map)) {
            return "";
        }

        // Step 3: Return BFS Order (Topological Sort)
        return bfsOrder(map, inDegree);
    }

    public boolean hasCycle(HashMap<Character, Node> map) {
        Set<Character> visiting = new HashSet<>();
        for (Map.Entry<Character, Node> entry : map.entrySet()) {
            Node node = entry.getValue();
            if (!node.visited && isCyclic(node, visiting)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCyclic(Node current, Set<Character> visiting) {
        if (visiting.contains(current.ch)) {
            // Cycle detected
            return true;
        }
        if (current.visited) {
            return false;
        }

        visiting.add(current.ch);
        for (Node child : current.children) {
            if (isCyclic(child, visiting)) {
                return true;
            }
        }
        visiting.remove(current.ch);
        current.visited = true;
        return false;
    }

    private String bfsOrder(LinkedHashMap<Character, Node> map, LinkedHashMap<Character, Integer> inDegree) {
        Queue<Character> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        // Step 1: Start with nodes having in-degree 0
        for (Character ch : inDegree.keySet()) {
            if (inDegree.get(ch) == 0) {
                queue.offer(ch);
            }
        }

        // Step 2: Process nodes in BFS order
        while (!queue.isEmpty()) {
            char current = queue.poll();
            result.append(current);

            for (Node neighbor : map.get(current).children) {
                inDegree.put(neighbor.ch, inDegree.get(neighbor.ch) - 1);
                if (inDegree.get(neighbor.ch) == 0) {
                    queue.offer(neighbor.ch);
                }
            }
        }

        // If all characters are processed, return result
        return result.length() == map.size() ? result.toString() : "";
    }

    public static void main(String[] args) {
        AlienDictionary ad = new AlienDictionary();
        // Array of test cases for words
        String[][] testCases = {
                {"DEF", "ABC", "DF", "DA", "FA"},
                {"z", "o"},
                {"wrtkj", "wrt"},
                {"hrn", "hrf", "er", "enn", "rfnn"}
        };

        // Using a loop to iterate over test cases
        for (String[] words : testCases) {
            System.out.println(ad.foreignDictionary(words));
        }

    }
}

class Node {
    Character ch;
    final LinkedHashSet<Node> children = new LinkedHashSet<>();
    boolean visited;

    public Node(Character ch) {
        this.ch = ch;
    }
}

