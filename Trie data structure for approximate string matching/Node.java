/**
 * Name:
 * Student Number:
 */

import java.util.ArrayList;

public class Node {
    // The edges are to be sorted alphabetically based on the label
    public ArrayList<Edge> edges;
    Boolean hasKey;
    String suffix;

    public Node() {
        // Your code here...
    }

    /**
     * Return the string representation of the node.
     * 
     * DO NOT MODIFY!
     */
    public String toString() {
        String edgeLabels = "";

        for (int i = 0; i < edges.size(); i++) {
            edgeLabels = edgeLabels + edges.get(i).label;

            if (i + 1< edges.size()) {
                edgeLabels = edgeLabels + ", ";
            }
        }

        return "[" + (hasKey ? "true" : "false") + ", " + (suffix.equals("") ? "NO_SUFFIX" : suffix) + ", [" + edgeLabels + "]]";
    }
}
