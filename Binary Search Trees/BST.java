@SuppressWarnings("unchecked")
public class BST<T extends Comparable<? super T>> {

	protected BSTNode<T> root = null;
	protected static int count = 0;
/* JESSE MWIRIGI MWITI U17306192*/
	public BST()
	{
    	}

	public void clear()
	{
		root = null;
	}

	public String inorder(BSTNode<T> node)
	{
		Boolean verbose = true;
		if (node != null) {
			String result = "";
			result += inorder(node.left);
			if (verbose) {
				result += node.toString()+"\n";
			} else {
				result += node.element.toString() + " ";
			}
			result += inorder(node.right);
			return result;
		}
		return "";
	}

	////// You may not change any code above this line //////

	////// Implement the functions below this line //////

	public boolean isEmpty()
	{
		//Your code goes here
     return root == null;
	}
  public BSTNode<T> min(BSTNode<T> current)
{
     if (current.left == null) return current;
     else                      return min(current.left);
 }
	public T minValue()
	{
		//Your code goes here
    if (isEmpty()) return null;
    BSTNode<T>  current = root;
      while (current.left != null)
          current = current.left;

      return current.element;
	}
  private BSTNode<T> max(BSTNode<T> current)
  {
      if (current.right == null) return current;
      else                       return max(current.right);
  }
	public T maxValue()
	{
    if (isEmpty()) return null;
    BSTNode<T>  current = root;
      while (current.right != null)
          current = current.right;

      return current.element;
	}

	public void printPostorder()
	{
		//Your code goes here
    postorder(root);
    System.out.println(" ");
	}
  public void postorder(BSTNode<T> p) {

       if (p != null) {

            postorder(p.left);

            postorder(p.right);

            System.out.print(p.element +" ");


       }

   }

	public void insert(T el)
	{
		//Your code goes here
    BSTNode<T> p = root, prev = null;

        while (p != null) {  // find a place for inserting new node;

            prev = p;

            if (el.compareTo(p.element) < 0)

                 p = p.left;

            else p = p.right;

        }

        if (root == null)    // tree is empty;

             root = new BSTNode<T>(el);

        else if (el.compareTo(prev.element) < 0)

             prev.left  = new BSTNode<T>(el);

        else prev.right = new BSTNode<T>(el);
	}

	public boolean deleteByCopy(T el)
	{

		//Your code goes here
    BSTNode<T> node, p = root, prev = null;

        while (p != null && !p.element.equals(el)) {
             prev = p;
             if (el.compareTo(p.element) < 0)
                  p = p.left;
             else p = p.right;
        }
        node = p;
        if (p != null && p.element.equals(el)) {
             if (node.right == null)  {
                  node = node.left; }
             else if (node.left == null)  {
                  node = node.right;}
             else {
                  BSTNode<T> tmp = node.left;
                  BSTNode<T> previous = node;
                  while (tmp.right != null) {    // 2. find the rightmost
                      previous = tmp;            //    position in the
                      tmp = tmp.right;           //    left subtree of node;
                  }
                  node.element = tmp.element;              // 3. overwrite the reference

                                                 //    to the element being deleted;

                  if (previous == node)          // if node's left child's

                      previous.left  = tmp.left; // right subtree is null;

                 else previous.right = tmp.left; // 4.

             }

             if (p == root){

                  root = node;return true;}

             else if (prev.left == p){

                  prev.left = node;return true;}

             else {prev.right = node;return true;}


        }
        return false;
	}

	public T search(T el)
	{
		//Your code goes here
    BSTNode<T> p = root;

        while (p != null)

            if (el.equals(p.element))

                 return p.element;

            else if (el.compareTo(p.element) < 0)

                 p = p.left;

            else p = p.right;

        return null;
	}

}
