package Q2;

public class MySkipList<E> extends ExampleLinkedList<E>
{
	
	private static final long serialVersionUID = -4926218632483817338L;

	private int nextPosition(int currentIndex)
	{
		if(currentIndex+2 < size())
			return currentIndex+2;
		else if(currentIndex++ < size())
			return currentIndex++;
		else
			return currentIndex;
	}
	
	public int skipSearch(E e)
	{
		if(size() != 0)
		{
			if(e instanceof String)
			{
				return skipSearch(e.toString(), 0);
			}
			else
			{
				return skipSearch(e, 0);
			}
		}
		else
			return 0;
	}
	
	private int skipSearch(String s, int p)
	{
		int nextInt = this.nextPosition(p);
		if(nextInt == p)
		{
			return 0;
		}
		else if(convertString((String)get(nextInt)) < convertString(s))
		{
			return(skipSearch(s, nextInt));
		}
		else if(((String)get(nextInt)).equals(s))
		{
			return nextInt;
		}
		else if(convertString((String)get(nextInt)) > convertString(s))
		{
			if(get(nextInt--) != null)
			{
				if(((String)get(nextInt--)).equals(s))
				{
					return nextInt--;
				}
				else
				{
					return 0;
				}
			}
			else
			{
				return 0;
			}
		}
		else
		{
			return 0;
		}
	}
	
	private int skipSearch(E e, int p)
	{
		int nextInt = this.nextPosition(p);
		if(nextInt == p)
		{
			return 0;
		}
		else if(get(nextInt).hashCode() < e.hashCode())
		{
			return(skipSearch(e, nextInt));
		}
		else if(get(nextInt).equals(e))
		{
			return nextInt;
		}
		else if(get(nextInt).hashCode() > e.hashCode())
		{
			if(get(nextInt--) != null)
			{
				if(get(nextInt--).equals(e))
				{
					return nextInt--;
				}
				else
				{
					return 0;
				}
			}
			else
			{
				return 0;
			}
		}
		else
		{
			return 0;
		}
	}
	
	private int convertString(String s)
	{
		return s.hashCode();
	}
	
	public void skipInsert(E e)
	{
		if(size() != 0)
		{
			add(findInsertPosition(e, 0), e);
		}
		else
		{
			add(e);
		}
	}
	
	private int findInsertPosition(E e, int p)
	{
		int nextInt = this.nextPosition(p);
		if(nextInt == p)
		{
			return size();
		}
		else if(get(nextInt).hashCode() < e.hashCode())
		{
			return(findInsertPosition(e, nextInt));
		}
		else if(get(nextInt).equals(e))
		{
			return nextInt;
		}
		else if(get(nextInt).hashCode() > e.hashCode())
		{
			if(get(nextInt--) != null)
			{
				if(get(nextInt--).equals(e))
				{
					return nextInt--;
				}
				else if(get(nextInt--).hashCode() < e.hashCode())
				{
					return nextInt;
				}
				else
				{
					return findInsertPosition(e, nextInt--);
				}
			}
			else
			{
				return 0;
			}
		}
		else
		{
			return 0;
		}
	}

	public void skipRemove(E e)
	{
		int p = skipSearch(e);
		if(get(p).equals(e))
			remove(p);
	}
}
