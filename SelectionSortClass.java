package daa_java;

import java.util.Arrays;
import java.util.Random;

public class SelectionSortClass 
{
	static int MAX = 10000 ;
	void selectionSort(long array[])
	{
		int size = array.length;
		for (int step = 0; step < size - 1; step++)
		{
			int min_idx = step;
			for (int i = step + 1; i < size ; i++)
			{
				// To sort in descending order, change > to < in this line
				// Select the minimum element in each loop
				if (array[i] < array[min_idx])
				{
					min_idx = i ;
				}
				// put min at correct position
				long temp = array[step] ;
				array[step] = array[min_idx] ;
				array[min_idx] = temp ;
			}
		}
	}
	public static void main (String args [])
	{
		long [] data = new long[MAX] ;
		for ( int i = 0; i < MAX; i++)
		{
			data[i] = new Random().nextInt(MAX) ;
			System.out.println(data[i]) ;
		}
		SelectionSortClass selectionSortObject = new SelectionSortClass() ;
		long startTime = System.nanoTime() ;
		selectionSortObject.selectionSort(data) ;
		long endTime = System.nanoTime() ;
		long totalTime = endTime - startTime ;
		double elapsedTimeInSeconds = (double)totalTime / 1_000_000_000 ;
		System.out.println("Sorted in Ascending Order :") ;
		System.out.println(Arrays.toString(data)) ;
		System.out.println("Time taken to sort "+data.length+" numbers is "+elapsedTimeInSeconds+" seconds") ;
	}
}
