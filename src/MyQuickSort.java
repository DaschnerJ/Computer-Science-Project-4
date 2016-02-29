

public class MyQuickSort {
	
	public static int[] a;
	
	/**
	 * Main method.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		a = makeRandomArray();
		printArray();
		quickSort(a);
		printArray();
	}

	/**
	 * The start of a quick sort recursive method. Fills in the extra required information.
	 * @param a The array to be sorted.
	 */
	public static void quickSort(int[] a) 
	{
		quickSort(a, 0, a.length-1);
	}
	
	/**
	 * The quick sort method, to sort each of the arrays.
	 * @param a The array to quick sort.
	 * @param o The originial starting position.
	 * @param e The ending position of the array.
	 */
	public static void quickSort(int[] a, int o, int e)
	{
		int b = array(a, o, e);
		
		if(o < b - 1)
		{
			quickSort(a, o, b-1);
		}
		
		if(e > b)
		{
			quickSort(a, b, e);
		}
	}
	
	/**
	 * The method to readjust and parse the array recursively.
	 * @param a The array to be sorted.
	 * @param l The left hand marker.
	 * @param r The right hand marker.
	 * @return Returns a partially sorted array.
	 */
	public static int array(int[] a, int l, int r)
	{
		int p = a[l];
		
		while(l <= r)
		{
			while(a[l] < p)
			{
				l++;
			}
			while(a[r] > p)
			{
				r--;
			}
			if(l <= r)
			{
				int o = a[l];
				a[l] = a[r];
				a[r] = o;
				
				l++;
				r++;
			}
		}
		return l;
	}
	
	/**
	 * Prints out a given array.
	 */
	public static void printArray()
	{
		for(int i : a)
		{
			System.out.print(i + " ");
			
		}
		System.out.println("");
	}
	
	/**
	 * Makes a random array.
	 * @return Returns a random array of a given size.
	 */
	public static int[] makeRandomArray()
	{
		//Change this to make a different size array.
		int s = 10;
		int[] b = new int[s];
		int r = 0;
		for(int i = 0; i < s; i++)
		{
			r = (int)(Math.random()*100);
			b[i] = r;
		}
		return b;
	}
	

}
