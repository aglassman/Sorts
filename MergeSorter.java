import java.util.Arrays;

public class MergeSorter extends Sorter
{
	public MergeSorter(int[] contents)
	{
		super("MergeSort",contents);
	}

	public void sort()
	{
		contents = splitAndMerge(contents);
	}

	private int[] splitAndMerge(int[] arrayToSplit)
	{
		int[] a;
		int[] b;
		if(arrayToSplit.length > 1)
		{
			int splitIndex = arrayToSplit.length/2;
			a = splitAndMerge(Arrays.copyOfRange(arrayToSplit,0,splitIndex));
			b = splitAndMerge(Arrays.copyOfRange(arrayToSplit,splitIndex,arrayToSplit.length));
		}
		else
		{
			a = arrayToSplit;
			b = new int[0];
		}
		return merge(a,b);
	}


	public int[] merge(int[] a, int[] b)
	{
		//System.out.println("\na:"+Arrays.toString(a));
		//System.out.println("b:"+Arrays.toString(b)+"\n");
		int indexA = 0;
		int indexB = 0;
		int indexM = 0;
		int[] merged = new int[a.length+b.length];
		while(indexA < a.length  && indexB < b.length )
		{
			if(a[indexA] <= b[indexB])
			{
				merged[indexM] = a[indexA];
				indexA++;
				indexM++;
			}
			else
			{
				merged[indexM] = b[indexB];
				indexB++;
				indexM++;
			}
		}
		
		while(indexA < a.length)
		{
			merged[indexM] = a[indexA];
			indexA++;
			indexM++;
		}
		
		while(indexB < b.length)
		{
			merged[indexM] = b[indexB];
			indexB++;
			indexM++;
		}
		//System.out.println("Sorted: " + Arrays.toString(merged));
		return merged;
	}
}