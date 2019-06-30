/**
 * Name:
 *
 * Student Number:
 */
public class TreeNode<T extends Comparable<T>> {
    public T key;
    public TreeNode<T> left;
    public TreeNode<T> right;
    public TreeNode<T> parent;

    public TreeNode(T k) {
        // Your Code here...
        key=k;
        left=null;
        right=null;
        parent=null;
    }

    /**
     * Return a string representation of the TreeNode
     */
    public String toString() {
        String left = this.left == null ? "null" : this.left.key.toString();
        String right = this.right == null ? "null" : this.right.key.toString();

        return "[" + this.key + ", L:" + left + ", R:" + right + "]";
    }
}
