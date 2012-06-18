

public class LinearSorter extends Sorter{
	public LinearSorter(int[] contents)
	{
		super("Linear",contents);
	}
	public void sort()
	{
		System.out.println("Sorting contents...");

		boolean sortComplete = false;
		int register = 0;
		while(!sortComplete)
		{
			boolean elementSwitched = false;
			for(int i = 0; i < contents.length - 2; i++)
			{
				if(contents[i] > contents[i+1])
				{
					register = contents[i];
					contents[i] = contents[i+1];
					contents[i+1] = register;
					elementSwitched = true;
				}
			}
			if(!elementSwitched)
			{
				sortComplete = true;
			}
		}

		System.out.println("Sort complete.");
	}
}