package daa_java;

import java.util.*;

public class QuickSort 
{
	static int max = 10000 ;
	public static void main (String args [])
	{
		Scanner sc = new Scanner(System.in) ;
		Random rand = new Random() ;
		int a[] = new int[max] ;
		System.out.println("Enter the number of elements : ") ;
		int n = sc.nextInt() ;
		sc.close();
		for (int i = 0; i < n; i++)
		{		
			a[i] = rand.nextInt(max) ;
		}
		System.out.println("The "+n+" elements are : ") ;
		for (int i = 0; i < n; i++)
		{
			System.out.println(a[i]) ;
		}
		long startTime = System.nanoTime() ;
		quickSort(a, 0, n-1) ;
		long endTime = System.nanoTime() ;
		//long totalTime = endTime - startTime ;
		//double elapsedTimeInSeconds = (double)totalTime / 1_000_000_000 ;
		System.out.println("Sorted in Ascending Order :"+Arrays.toString(a)) ;
		/*for (int i = 0; i < n; i++)
		{
			System.out.print(a[i]+" ") ;
		}
		System.out.println();*/
		//System.out.println("Time taken to sort "+a.length+" numbers is "+elapsedTimeInSeconds+" seconds") ;
		System.out.println("The time taken to sort is : "+a.length+" numbers is :"+(endTime - startTime)+" ns") ;
	}
	public static void quickSort(int a[], int low, int high)
	{
		int i, j, key, temp ;
		key = a[low] ;
		i = low + 1;
		j = high ;
		if (low < high)
		{
			while(true) 
			{
				while ( i < high && key >= a[i])
				{
					i++;
				}
				while (key < a[j])
				{
					j--;
				}
				if (i < j)
				{
					temp = a[i] ;
					a[i] = a[j] ;
					a[j] = temp ;
				}
				else
				{
					temp = a[low] ;
					a[low] = a[j] ;
					a[j] = temp ;
					break ;
				}
			}
			quickSort(a, low, j-1) ;
			quickSort(a, j+1, high) ;
		}
	}
}
