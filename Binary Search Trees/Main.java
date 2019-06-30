public class Main
{
	public static void printCount(BST<Integer> tree)
	{
		System.out.println(tree.count);
	}

	public static void minElement(BST<Integer> tree)
	{
		Integer result = tree.minValue();
		if (result != null)
			System.out.println("Min element " + result);
		else
			System.out.println("Tree is empty");
	}

	public static void maxElement(BST<Integer> tree)
	{
		Integer result = tree.maxValue();
		if (result != null)
			System.out.println("Max element " + result);
		else
			System.out.println("Tree is empty");
	}

	public static void searchElement(BST<Integer> tree, Integer element)
	{
		if (tree.isEmpty())
			System.out.println("Tree is empty");
		else
		{
			Integer result = tree.search(element);
			if (result != null)
				System.out.println("Found element " + result);
			else
				System.out.println("Element " + element + " not found");
		}
	}

	public static void deleteElement(BST<Integer> tree, Integer element)
	{
		if (tree.isEmpty())
			System.out.println("Tree is empty");
		else
		{
			Boolean result = tree.deleteByCopy(element);
			if (result)
				System.out.println("Deleted element " + element);
			else
				System.out.println("Element " + element + " not found for deletion");
		}
	}

	public static void printTree(BST<Integer> tree, Boolean verbose)
	{
    		if (verbose)
		{
			String result;
			System.out.println();
			System.out.println("Binary Search Tree Content:");
    			result = tree.inorder(tree.root);
			System.out.println(result);
		} else
		{
			tree.printPostorder();
		}
	}

	public static void main(String[] args)
	{
		//Practical 3 - Tuesday
		// Delete by copy
		// postorder print
		// min and max

		BST<Integer> tree = new BST<Integer>();

		minElement(tree);

		maxElement(tree);

		tree.insert(8);

		tree.insert(5);

		tree.insert(12);
    // tree.printPostorder();
		printTree(tree, false);

		searchElement(tree, 10);

		tree.insert(14);

		tree.insert(7);

		tree.insert(10);

		printTree(tree, true);

		searchElement(tree, 10);

		deleteElement(tree, 12);

		printTree(tree, true);

		minElement(tree);

		maxElement(tree);

		/* Expected Output:
		Tree is empty
		Tree is empty
		5 12 8
		Element 10 not found

		Binary Search Tree Content:
		5 [L: null]  [R: 7]
		7 [L: null]  [R: null]
		8 [L: 5]  [R: 12]
		10 [L: null]  [R: null]
		12 [L: 10]  [R: 14]
		14 [L: null]  [R: null]

		Found element 10
		Deleted element 8

		Binary Search Tree Content:
		5 [L: null]  [R: null]
		7 [L: 5]  [R: 12]
		10 [L: null]  [R: null]
		12 [L: 10]  [R: 14]
		14 [L: null]  [R: null]

		Min element 5
		Max element 14
		*/


	}
}
