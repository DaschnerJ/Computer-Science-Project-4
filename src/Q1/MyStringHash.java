package Q1;

import java.util.LinkedList;
import java.util.Scanner;

public class MyStringHash 
{
	//Linked list to hash to.
	LinkedList<String>[] hash;
	
	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		MyStringHash h = new MyStringHash(532999999);
	}
	
	/**
	 * Creates a hash and hashes the inputs.
	 * @param s Size of the hash set.
	 */
	@SuppressWarnings("unchecked")
	public MyStringHash(int s)
	{
		//The size of the hash.
		int size = s;
		
		//Makes sure it isn't too big.
		if(s > 532999999)
			size = 532999999;
		
		//Enter in your desired strings to hash.
		System.out.println("Enter in all the strings you wish to add and then type 'StopNow' to stop the program.");
		hash = new LinkedList[size];
		boolean cancel = false;
		Scanner in = new Scanner(System.in);
		
		//Take in the information.
		while(!cancel)
		{	
			try
			{
				//The next string.
				String a = in.next();
				//Stop method
				if(a.equals("StopNow"))
				{
					cancel = true;
				}
				//Adds the string to be hashed.
				else
				{
					add(a);
				}
			}
			//Exception
			catch(IndexOutOfBoundsException e)
			{
				System.out.println("The word is too large to be hashed.");
				System.out.println("The program is now stopping.");
				in.close();
				throw e;
			}
			catch(Exception e)
			{
				System.out.println("An error occured.");
				in.close();
				throw e;
			}
		}
		//Repeat the hashed strings.
		System.out.println("Information you entered:");
		for(int i = 0; i < hash.length; i++)
		{
			if(hash[i] != null)
			{
				LinkedList<String> l = hash[i];
				for(int j = 0; j < l.size(); i++)
				{
					find(l.get(j));
					remove(l.get(j));
				}
			}
		}
		in.close();
		
	}
	
	/**
	 * Hashes and adds the string to the hashset.
	 * @param s The string to be hashed and added.
	 * @return Returns true, otherwise throws an exception.
	 */
	boolean add(String s)
	{
		try
		{
			int hashed = HashString(s);
			if(containsHash(s))
			{
				LinkedList<String> a = hash[hashed];
				a.add(s);
				hash[hashed] = a;
				return true;
			}
			else
			{
				LinkedList<String> a = new LinkedList<String>();
				a.add(s);
				hash[hashed] = a;
				return true;
			}
		}
		catch(Exception e)
		{
			System.out.println("An error occured.");
			throw e;
		}
	}
	
	/**
	 * Attempts to remove the s within the hashset.
	 * @param s The string to be removed.
	 * @return Returns true if the string was successfully removed, reutnrs false otherwise.
	 */
	boolean remove(String s)
	{
		
		boolean b = contains(s);
		if(b)
		{
			int hashIndex = HashString(s);
			LinkedList<String> l = hash[hashIndex];
			l.remove(s);
			if(l.size() == 0)
			{
				hash[hashIndex] = null;
			}
			System.out.println("Removed string: " + s + ".");
		}
		else
		{
			System.out.println("Could not find string: " + s + ".");
		}
		return b;
	}
	
	/**
	 * Finds if the String is hashed and where it is hashed.
	 * @param s The string to be found.
	 * @return Returns true if the string was found and the location the string was found at, returns false otherwise.
	 */
	boolean find(String s)
	{
		boolean b = contains(s);
		if(b)
		{
			int hashIndex = HashString(s);
			int listIndex = 0;
			LinkedList<String> l = hash[hashIndex];
			for(int i = 0; i < l.size(); i++)
			{
				if(l.get(i).equals(s))
				{
					listIndex = i;
					i = l.size();
				}
			}
			System.out.println("Found string: " + s + ".");
			System.out.println("Hash: " + HashString(s) + ".");
			System.out.println("List Index: " + listIndex + ".");
		}
		else
		{
			System.out.println("Could not find string: " + s + ".");
		}
		return b;
	}
	
	/**
	 * Checks if the exact string is with in the hash set.
	 * @param s The string to check if the hash in the set.
	 * @return Returns true if the string is within the hashset, return false otherwise.
	 */
	boolean contains(String s)
	{
		if(containsHash(s))
		{
			int a = HashString(s);
			LinkedList<String> b = hash[a];
			if(b.contains(s))
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	/**
	 * Checks if the word or an exact hash number has been hashed before.
	 * @param s The string of the word to check has been hashed or has the same hash as another.
	 * @return Returns true if the hash exists, false if it does not.
	 */
	boolean containsHash(String s)
	{
		int a = HashString(s);
		if(hash[a] != null)
			return true;
		return false;
	}
	
	/**
	 * Hashes a string to a specific hash.
	 * @param a The string you wish to hash. 
	 * @return Returns the hashed integer of the string.
	 */
	private int HashString(String a)
	{
		char[] b = getStringCharacters(a);
		
		int[] c = convertCharToInts(b);
		
		int[] d = addArrays(addArrays(hashMultiply(hashMultiply(hashLength(hashAdd(c, -6)), 3), 2), hashMod(c, 2)), hashMod(c, 3));

		return hashInt(d);
	}
	
	/**
	 * @param s String to convert to characters.
	 * @return Returns the converted string as a character array.
	 */
	public char[] getStringCharacters(String s)
	{
		char[] a = s.toCharArray();
		
		return a;
	}
	
	/**
	 * @param a The character array to convert to integer array.
	 * @return Returns the converted character array as an integer array.
	 */
	public int[] convertCharToInts(char[] a)
	{
		int[] b = new int[a.length];
		
		for(int i = 0; i < a.length; i++)
		{
			b[i] = (int)a[i];
		}
		
		return b;
	}
	
	/**
	 * @param a The int array to be multiplied by a constant.
	 * @param p The constant to be multiplied.
	 * @return Returns the multiplied array by the constant.
	 */
	public int[] hashMultiply(int[] a, int p)
	{
		int[] b = new int[a.length];
		
		for(int i = 0; i < a.length; i++)
		{
			b[i] = p*a[i];
		}
		
		return b;	
	}
	
	/**
	 * Multiplies the array by it's length.
	 * @param a The int array to be multiplied by the length of itself.
	 * @return Returns the multiplied array by the length of the array.
	 */
	public int[] hashLength(int[] a)
	{
		int[] b = new int[a.length];
		int p = a.length;
		
		for(int i = 0; i < a.length; i++)
		{
			b[i] = p*a[i];
		}
		
		return b;
	}
	
	/**
	 * Adds a constant to each index of the array.
	 * @param a The int array to add a constant to.
	 * @param p The constant to add to the int array.
	 * @return Returns the int array with the added constant.
	 */
	public int[] hashAdd(int[] a, int p)
	{
		int[] b = new int[a.length];
		
		for(int i = 0; i < a.length; i++)
		{
			b[i] = a[i]+p;
		}
		
		return b;
	}
	
	/**
	 * Mods the array by a constant.
	 * @param a The int array to mod by a constant.
	 * @param p The constant to mod the array by.
	 * @return Returns the modded int array.
	 */
	public int[] hashMod(int[] a, int p)
	{
		int[] b = new int[a.length];
		
		for(int i = 0; i < a.length; i++)
		{
			b[i] = a[i]%p;
		}
		
		return b;
	}
	
	/**
	 * Divides the array by a constant.
	 * @param a The int array to divide by a constant.
	 * @param p The constant to divide the array by.
	 * @return Returns the divided int array.
	 */
	public int[] hashDivide(int[] a, int p)
	{
		int[] b = new int[a.length];
		
		for(int i = 0; i < a.length; i++)
		{
			b[i] = a[i]%p;
		}
		
		return b;
	}
	
	/**
	 * Adds two int arrays of the same size.
	 * @param a Int array a to be added with more priority.
	 * @param b Int array b to be added with less priority.
	 * @return Returns the added arrays.
	 */
	public int[] addArrays(int[] a, int[] b)
	{
		int[] c = new int[a.length];
		
		for(int i = 0; i < a.length; i++)
		{
			c[i] = a[i] + b[i];
		}
		
		return c;
	}
	
	/**
	 * Adds all the elements together into one number.
	 * @param a The array to convert to a long.
	 * @return
	 */
	public int hashInt(int[] a)
	{
		int b = 0;
		
		for(int i = 0; i < a.length; i++)
		{
			b = b + a[i];
		}
		
		return b;
	}

}
