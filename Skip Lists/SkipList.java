import java.util.Random;

@SuppressWarnings("unchecked")
public class SkipList<T extends Comparable<? super T>>
{

	public int maxLevel;
	public SkipListNode<T>[] root;
	private int[] powers;
	private Random rd = new Random();
	////added variables
	public int size=0;
	SkipListNode<T> lastNode;

	SkipList(int i)
	{
		maxLevel = i;
		root = new SkipListNode[maxLevel];
		powers = new int[maxLevel];
		for (int j = 0; j < i; j++)
			root[j] = null;
		choosePowers();
		rd.setSeed(1230456789);
	}

	SkipList()
	{
		this(4);
	}

	public void choosePowers()
	{
		powers[maxLevel-1] = (2 << (maxLevel-1)) - 1;
		for (int i = maxLevel - 2, j = 0; i >= 0; i--, j++)
			powers[i] = powers[i+1] - (2 << j);
	}

	public int chooseLevel()
	{
		int i, r = Math.abs(rd.nextInt()) % powers[maxLevel-1] + 1;
		for (i = 1; i < maxLevel; i++)
		{
			if(r < powers[i])
				return i-1;
		}
		return i-1;
	}

	public boolean isEmpty()
	{
		//Your code goes here
	    return root[0] == null;
	}
	public T first()
	{
		//Your code goes here
      return root[0].key;
	}

	public T last()
	{
			SkipListNode<T> node = root[0];
			SkipListNode<T> temp = node;
		for (int i = 0; i < 1; i++)
		{
				while (node != null)
				{
							temp=node;
							node = node.next[i];
				}

		}
  	return temp.key;
	}

	public void insert(T key)
	{
		//Your code goes here
		SkipListNode<T>[] curr = new SkipListNode[maxLevel];
			 SkipListNode<T>[] prev = new SkipListNode[maxLevel];
			 SkipListNode<T> newNode;
			 int lvl, i;
			 curr[maxLevel-1] = root[maxLevel-1];
			 prev[maxLevel-1] = null;
			 for (lvl = maxLevel - 1; lvl >= 0; lvl--) {
					 while (curr[lvl] != null && curr[lvl].key.compareTo(key) < 0) {
							 prev[lvl] = curr[lvl];
							 curr[lvl] = curr[lvl].next[lvl];
					 }
					 if (curr[lvl] != null && key.equals(curr[lvl].key))
							 return;
					 if (lvl > 0)
							 if (prev[lvl] == null) {
										 curr[lvl-1] = root[lvl-1];
										 prev[lvl-1] = null;
							 }
							 else {
										curr[lvl-1] = prev[lvl].next[lvl-1];
										prev[lvl-1] = prev[lvl];
							 }
			 }
			 lvl = chooseLevel();
			 newNode = new SkipListNode<T>(key,lvl+1);
			 for (i = 0; i <= lvl; i++) {
					 newNode.next[i] = curr[i];
					 if (prev[i] == null)
								root[i] = newNode;

					 else prev[i].next[i] = newNode;

			 }
			 size++;
	 }


	public T search(T key)
	{
		//Your code goes here
		int lvl;
        SkipListNode<T> prev, curr;
        for (lvl = maxLevel-1; lvl >= 0 && root[lvl] == null; lvl--);
        prev = curr = root[lvl];
        while (true) {
            if (key.equals(curr.key))
                 return curr.key;
            else if (key.compareTo(curr.key) < 0) {
                 if (lvl == 0)
                      return null;
                 else if (curr == root[lvl])
                      curr = root[--lvl];
                 else curr = prev.next[--lvl];
            }
            else {
                 prev = curr;
                 if (curr.next[lvl] != null)
                      curr = curr.next[lvl];
                 else {
                      for (lvl--; lvl >= 0 && curr.next[lvl] == null; lvl--);
                      if (lvl >= 0)
                           curr = curr.next[lvl];
                      else return null;
                 }
            }
        }
	}
 }
