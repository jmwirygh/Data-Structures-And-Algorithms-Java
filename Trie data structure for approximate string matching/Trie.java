/**
 * Name:
 * Student Number:
 */

import java.util.ArrayList;

public class Trie {
    public Node root;

    public Trie() {
        // Your code here...
    }

    /**
     * Insert the given key into the trie. Duplicate keys should be ignored.
     */
    public void insert(String key) {
        // Your code here...
    }

    /**
     * Return true if the key exists in the trie, otherwise false.
     */
    public Boolean contains(String key) {
        // Your code here...
    }

    /**
     * Return the closest string in the trie using Levenshtein distance.
     * Only consider distances that are in the range [0, maxDistance].
     * If no match could be found in the given range, return null.
     * When multiple strings have the same Levenshtein distance, return 
     * the string that comes first alphabetically.
     */
    public String closestMatch(String str, Integer maxDistance) {
        // Your code here...
    }

    /**
     * Return a string representation of the trie.
     * 
     * DO NOT MODIFY!
     */
    public String toString() {
        StringBuilder result = new StringBuilder();

        ArrayList<Node> nodesToVisit = new ArrayList<>();

        nodesToVisit.add(root);

        while (nodesToVisit.size() != 0) {
            Node node = nodesToVisit.remove(0);

            for (int i = 0; i < node.edges.size(); i++) {
                nodesToVisit.add(node.edges.get(i).target);
            }

            result.append(node.toString());
        }

        return result.toString();
    }
}