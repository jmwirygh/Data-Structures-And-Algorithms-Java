/**
 * Name:
 *
 * Student number:
 */
 import java.io.*;

public class SplayTree<T extends Comparable<T>> {

    public TreeNode<T> root;

    public SplayTree() {
        // Your code here...
        root=null;
    }

    /**
     * Returns true if the key exists in the tree, otherwise false
     */
    public Boolean contains(T key) {
                  // Your code here...
                  TreeNode<T> p;   // Help variable

              /* --------------------------------------------
           Find the node with key == "key" in the BST
                 -------------------------------------------- */
              p = findEntry(key);
              if ( key.equals( p.key ) ){
                  return true;
              }
              else
           return false;
    }

    /**
     * Insert the given key into the tree.
     * Duplicate keys should be ignored.
     * No Splaying should take place.
     */
    public void insert(T key) {
                // Your code here...
                    TreeNode<T> newNode=new TreeNode(key);
                    TreeNode<T> p;   // Help variabl
                        if ( root == null )
                        {  // Insert into an empty BST
                           root = newNode;
                          return;
                        }
                        p = findEntry(key);
                        if ( key.equals( p.key ) )
                        {
                           p.key = key;			// Update value
                           return;
                        }
                        TreeNode<T> q = new TreeNode(key);
                        q.parent = p;
                        if ( key.compareTo( p.key ) < 0 ){
                             p.left = q;
                        }
                        else
                        p.right = q;           	// Add q as right child
    }

    /**
     * Return the successor of the given key.
     * If the given key does not exist return null.
     * If the given key does not have a successor, return null.
     */
    public T findSuccessor(T key) {
        // Your code here...
        TreeNode<T> temp= findEntry(key);
        if (temp==null) {
            return null;
        }
        else if (temp.right==null) {
           return null;
        }
        else{
          TreeNode<T> temp2=temp.right;
          while(temp2.left!=null){
              temp2=temp2.left;
          }
          return temp2.key;
        }
        // return key;
    }
    public void continueRotation(TreeNode<T> gr, TreeNode<T> par,
                                      TreeNode<T> ch, TreeNode<T> desc) {
            if (gr != null) {                    // if par has a grandparent;
                 if (gr.right == ch.parent)
                      gr.right = ch;
                 else gr.left  = ch;
            }
            else root = ch;
            if (desc != null)
                 desc.parent = par;
            par.parent = ch;
            ch.parent = gr;
        }
        public void rotateR(TreeNode<T> p) {
            p.parent.left = p.right;
            p.right = p.parent;
            continueRotation(p.parent.parent,p.right,p,p.right.left);
        }
        public void rotateL(TreeNode<T> p) {
            p.parent.right = p.left;
            p.left = p.parent;
            continueRotation(p.parent.parent,p.left,p,p.left.right);
        }
  public void semisplay(TreeNode<T> p) {
        while (p != root) {
            if (p.parent.parent == null)     // if p's parent is
                 if (p.parent.left == p)     // the root;
                      rotateR(p);
                 else rotateL(p);
            else if (p.parent.left == p)     // if p is a left child;
                 if (p.parent.parent.left == p.parent) {
                      rotateR(p.parent);
                      p = p.parent;
                 }
                 else {
                      rotateR(p); // rotate p and its parent;
                      rotateL(p); // rotate p and its new parent;
                 }
            else                             // if p is a right child;
                 if (p.parent.parent.right == p.parent) {
                      rotateL(p.parent);
                      p = p.parent;
                 }
                 else {
                      rotateL(p);            // rotate p and its parent;
                      rotateR(p);            // rotate p and its new parent;
                 }
                 if (root == null)           // update the root;
                      root = p;
        }
    }
    /**
     * Move the accessed key closer to the root using the semi-splaying strategy.
     * If the key does not exist, insert it without splaying
     */
    public void access(T key) {
      TreeNode<T> p = root;
      while (p != null)
          if (key.equals(p.key)) {
            // System.out.println("ddcdv");
               semisplay(p);
               return;
          }
          else if (key.compareTo(p.key) < 0)
               p = p.left;
          else p = p.right;
      insert(key);
    }


    public TreeNode<T> findEntry(T k)
   {
       TreeNode<T> curr_node;   // Help variable
       TreeNode<T> prev_node;   // Help variable

       /* --------------------------------------------
	  Find the node with key == "k" in the BST
          -------------------------------------------- */
       curr_node = root;  // Always start at the root node
       prev_node = root;  // Remember the previous node for insertion

       while ( curr_node != null )
       {
          if ( k.compareTo( curr_node.key ) < 0 )
	  {
	     prev_node = curr_node;       // Remember prev. node
	     curr_node = curr_node.left;  // Continue search in left subtree
	  }
          else if ( k.compareTo( curr_node.key ) > 0 )
	  {
	     prev_node = curr_node;       // Remember prev. node
	     curr_node = curr_node.right; // Continue search in right subtree
	  }
          else
	  {
	     // Found key in BST
	     return curr_node;
	  }
       }

       /* ======================================
	  When we reach here, k is NOT in BST
          ====================================== */
          if (prev_node==null) {
             return null;
          }		// Return the previous (parent) node
          else{
            return prev_node;
          }

   }
}
