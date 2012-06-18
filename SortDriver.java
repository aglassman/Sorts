import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class SortDriver{
	public static void main(String[] args)
	{
		int[] contents = SortDriver.getRandomArrayOfInts(Integer.parseInt(args[0]));
		
		List<Sorter> sorters = new ArrayList<Sorter>();
		sorters.add(new LinearSorter(contents));
		sorters.add(new LinearSorter(Arrays.copyOf(contents,contents.length)));
		sorters.add(new LinearSorter(Arrays.copyOf(contents,contents.length)));
		sorters.add(new LinearSorter(Arrays.copyOf(contents,contents.length)));
		sorters.add(new LinearSorter(Arrays.copyOf(contents,contents.length)));
		
		try{
			for(Sorter s : sorters)
			{
				s.sortAndCalcExeTime();
				System.out.println(
					String.format(
						"Algorithm %s sorted %s elements in %s milliseconds.\n",
						s.getSorterAlgorithmName(),
						s.getContentsLength(),
						s.getSortExecutionTime())
					);
			}
		}catch(Sorter.SortException e)
		{
			System.err.println(e);
		}
	}

	public static int[] getRandomArrayOfInts(int numberOfElements)
	{
		Random rand = new Random(System.currentTimeMillis());
		int[] randomArray = new int[numberOfElements];
		for(int i = 0; i < numberOfElements; i++)
		{
			randomArray[i] = rand.nextInt();
		}

		return randomArray;
	}
}