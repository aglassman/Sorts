public abstract class Sorter{
	
	protected int[] contents;
	private long sortExecutionTime = -1;
	private String sorterAlgorithmName;
	public Sorter(String sorterAlgorithmName, int[] contents)
	{
		this.sorterAlgorithmName = sorterAlgorithmName;
		this.contents = contents;
	}

	public String getSorterAlgorithmName()
	{
		return sorterAlgorithmName;
	}
	
	public void sortAndCalcExeTime() throws SortException{
		long startTime = System.currentTimeMillis();
		sort();
		sortExecutionTime = System.currentTimeMillis() - startTime;
		
		if(!validSort())
		{
			throw new SortException("Incorrect ordering.");
		}
	}
	public abstract void sort();

	public long getSortExecutionTime()
	{
		return sortExecutionTime;
	}

	public int getContentsLength()
	{
		return contents.length;
	}

	public boolean validSort(){
		boolean validSort = true;
		for(int i = 0; i < contents.length - 2 ; i++)
		{
			if(contents[i] > contents[i+1])
			{
				System.err.println(
					String.format("element: %s is greather than element: %s. [%s,%s]",
						i,i+1,contents[i],contents[i+1])
					);
				validSort = false;
				break;
			}
		}
		return validSort;
	}

	public class SortException extends Exception{
		public SortException(String reason)
		{
			super("Invalid sort: " + reason);
		}
	}	
}
