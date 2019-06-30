// Name:
// Student number:
import java.util.Arrays;

public class Sort
{
	
	////// Implement the functions below this line //////
	static Comparable[] temp;
	/********** MERGE **********/
	public static <T extends Comparable<? super T>> void mergesort(T[] data, int first, int last, boolean debug)
	{

		  if (data.length < 2)

            return;

        //T[] temp = (T[])new Comparable<?>[data.length];
         temp = new Comparable[data.length];

        mergesort2(data,first,last,debug);

	}
	public static <T extends Comparable<? super T>> void mergesort2(T[] data, int first, int last, boolean debug)
	{
        int mid = (first + last) / 2;

        if (first < mid)

            mergesort(data, first, mid ,debug);

        if (mid+1 < last)

            mergesort(data, mid+1, last ,debug);

        merge(data, first, last ,debug);

	}
     
	private static <T extends Comparable<? super T>> void merge(T[] data, int first, int last, boolean debug)
	{

		// Your code here
        int mid = (first + last) / 2;

        int i1 = 0, i2 = first, i3 = mid + 1;

        while (i2 <= mid && i3 <= last)

            if (data[i2].compareTo(data[i3]) < 0)

                 temp[i1++] = data[i2++];

            else temp[i1++] = data[i3++];

        while (i2 <= mid)

            temp[i1++] = data[i2++];

        while (i3 <= last)

            temp[i1++] = data[i3++];

        for (i1 = 0, i2 = first; i2 <= last; data[i2++] = (T) temp[i1++]);
		//DO NOT MOVE OR REMOVE!
		if (debug)
			System.out.println(Arrays.toString(data));
	}
     
	/********** COUNTING **********/
	public static void countingsort(int[] data, boolean debug)
	{

		// Your code here
               int i, largest = data[0];

        int[] tmp = new int[data.length];

        for (i = 1; i < data.length; i++)      // find the largest number

            if (largest < data[i])             // in data and create the array

                largest = data[i];             // of counters accordingly;

        int[] count = new int[largest+1];

	for (i = 0; i <= largest; i++)

            count[i] = 0;

        for (i = 0; i < data.length; i++)      // count numbers in data[];

            count[data[i]]++;

        for (i = 1; i <= largest; i++)         // count numbers <= i; 

            count[i] = count[i-1] + count[i];

        for (i = data.length-1; i >= 0; i--) { // put numbers in order in tmp[];

             tmp[count[data[i]]-1] = data[i];

             count[data[i]]--;

	}

        for (i = 0; i < data.length; i++)      // transfer numbers from tmp[]

             data[i] = tmp[i];                 // to the original array;
		//DO NOT MOVE OR REMOVE!
		if (debug)
			System.out.println(Arrays.toString(data));
	}

}