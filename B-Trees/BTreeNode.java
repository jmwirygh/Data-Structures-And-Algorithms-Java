@SuppressWarnings("unchecked")
class BTreeNode<T extends Comparable<T>> {
	boolean leaf;
	int keyTally;
	Comparable<T> keys[];
	BTreeNode<T> references[];
	int m;
	static int level = 0;
BTreeNode<T>root=this;
	// Constructor for BTreeNode class
	public BTreeNode(int order, boolean leaf1)
	{
    		// Copy the given order and leaf property
		m = order;
    		leaf = leaf1;

    		// Allocate memory for maximum number of possible keys
    		// and child pointers
    		keys =  new Comparable[2*m-1];
    		references = new BTreeNode[2*m];

    		// Initialize the number of keys as 0
    		keyTally = 0;
	}

	// Function to print all nodes in a subtree rooted with this node
	public void print()
	{
		level++;
		if (this != null) {
			System.out.print("Level " + level + " ");
			this.printKeys();
			System.out.println();

			// If this node is not a leaf, then
        		// print all the subtrees rooted with this node.
        		if (!this.leaf)
			{
				for (int j = 0; j < 2*m; j++)
    				{
        				if (this.references[j] != null)
						this.references[j].print();
    				}
			}
		}
		level--;
	}

	// A utility function to print all the keys in this node
	private void printKeys()
	{
		System.out.print("[");
    		for (int i = 0; i < this.keyTally; i++)
    		{
        		System.out.print(" " + this.keys[i]);
    		}
 		System.out.print("]");
	}

	////// You may not change any code above this line //////

	////// Implement the functions below this line //////

	// Function to insert the given key in tree rooted with this node
	public BTreeNode<T> insert(T k)
	{

							if (root.keyTally == 2*m-1)
							{
								BTreeNode s = new BTreeNode(m, false);
								s.references[0] = root;
								s.splitChild(0, root);
								int i = 0;
								if (s.keys[0].compareTo(k)<0)
									i++;
								s.references[i].insertNonFull(k);
								root = s;
							}
							else{
								 root.insertNonFull(k);
							}

        return root;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void insertNonFull(T k) {
						int i = keyTally-1;
						if (leaf == true)
						{
										while (i >= 0 &&  keys[i].compareTo(k) >0)
										{
												keys[i+1] = keys[i];
												i--;
										}
										keys[i+1] = k;
										keyTally = keyTally+1;
						}
						else // If this node is not leaf
						{
										while (i >= 0 && keys[i].compareTo(k) >0)
										     i--;


										if (references[i+1].keyTally == 2*m-1)
										{
												splitChild(i+1, references[i+1]);
												if (keys[i+1].compareTo(k)<0)
												   i++;
										}
										references[i+1].insertNonFull(k);
						}
		}

		public void splitChild(int i ,BTreeNode y) {

						BTreeNode z = new BTreeNode(y.m, y.leaf);
						z.keyTally = m - 1;


						for (int j = 0; j < m-1; j++)
							  z.keys[j] = y.keys[j+m];


						if (y.leaf == false)
						{
							for (int j = 0; j < m; j++)
								z.references[j] = y.references[j+m];
						}

						y.keyTally = m- 1;

				for (int j = keyTally; j >= i+1; j--)
					   references[j+1] = references[j];

		references[i+1] = z;

				for (int j = keyTally-1; j >= i; j--)
					   keys[j+1] = keys[j];

		keys[i] = y.keys[m-1];
		keyTally = keyTally+ 1;
		}


	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Function to traverse all nodes in a subtree rooted with this node
	public void traverse()
	{
    		// Your code goes here
				// and first n children
     int i;
     for (i = 0; i < keyTally; i++)
     {
         // If this is not leaf, then before printing key[i],
         // traverse the subtree rooted with child C[i].
         if (leaf == false)
             references[i].traverse();
         System.out.print(" "+ keys[i]);
     }
     // Print the subtree rooted with last child
     if (leaf == false)
         references[i].traverse();
	}
}
