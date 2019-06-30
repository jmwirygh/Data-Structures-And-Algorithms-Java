public class Main {
	

    public static void main(String[] args) 
    {
	BTree<Integer> t = new BTree<Integer>(2); // A B-Tree with order 4 (2*m)
   
	t.insert(20);
	t.insert(10);
	t.insert(30);
	t.insert(50);
	t.insert(40);
	t.insert(60);
	t.insert(90);
	t.insert(70);
	t.insert(80);
	System.out.println("Traversal of the constucted tree is : ");
    	t.traverse();
	System.out.println("Structure of the constucted tree is : ");
	t.print();

	/* Expected Output:
	Traversal of the constucted tree is :
	 10 20 30 40 50 60 70 80 90
	Structure of the constucted tree is :
	Level 1 [ 30 60]
	Level 2 [ 10 20]
	Level 2 [ 40 50]
	Level 2 [ 70 80 90]
	*/
    }
}