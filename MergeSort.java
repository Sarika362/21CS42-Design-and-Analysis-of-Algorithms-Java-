package daa_java;

import java.util.Random;
import java.util.Scanner;

public class MergeSort 
{
	static int max = 20000 ;
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
		merge_Sort(a, 0, n) ;
		long endTime = System.nanoTime() ;
		long totalTime = endTime - startTime ;
		double elapsedTimeInSeconds = (double)totalTime / 1_000_000_000 ;
		System.out.println("Sorted in Ascending Order :") ;
		for (int i = 0; i < n; i++)
		{
			System.out.print(a[i]+",") ;
		}
		System.out.println();
		System.out.println("Time taken to sort "+a.length+" numbers is "+elapsedTimeInSeconds+" seconds") ;
		//System.out.println("The time taken to sort is : "+(endTime - startTime)+" ns") ;
	}
	public static void merge_Sort(int a[], int low, int high)
	{
		int mid ;
		if (low < high)
		{
			mid = (low + high)/2 ;
			merge_Sort(a, low, mid) ;
			merge_Sort(a, mid+1, high) ;
			merge(a, low, high-1, mid) ;
		}
	}
	public static void merge(int a[], int low, int high, int mid)
	{
		int i, j, k, l;
		int c[] = new int[max] ;
		i = k = low ;
		j = mid + 1 ;
		while ( i <= mid && j <= high)
		{
			if (a[i] <= a[j])
			{
				c[k++] = a[i++] ;
			}
			else 
			{
				c[k++] = a[j--] ;
			}
		}
		if (i > mid) 
		{
			for ( l = j; l <= high; l++ )
			{
				c[k++] = a[l];
			}
		}
		else
		{
			for ( l = i; l <= mid; l++ )
			{
				c[k++] = a[l] ;
			}	
		}
		for (i =low; i <= high; i++)
		{
			a[i] = c[i] ;
		}
	}
}
