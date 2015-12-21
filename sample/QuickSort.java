package sample;
/*
 * Sample implementation of the quick sort algorithm
 * 
 * Author : Aamin Lakhani
 */
public class QuickSort {

	private int partition(int a[], int l, int h) {
		int x = a[h];
	    int i = (l - 1);
	 
	    for (int j = l; j <= h- 1; j++)
	    {
	        if (a[j] <= x)
	        {
	            i++;
	            swap (a, i, j);
	        }
	    }
	    swap (a, i + 1, h);
	    return (i + 1);
	}
	
	private void swap (int a [], int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	public void quickSort(int a[], int l, int h)
	{
	    if (l < h)
	    {        
	        int p = partition(a, l, h); 
	        quickSort(a, l, p - 1);  
	        quickSort(a, p + 1, h);
	    }
	}
	public static void main(String args[]) {
		int a[] = {45, 13, 12, 2, 65, 1};
		QuickSort qs = new QuickSort();
		qs.quickSort(a, 0, a.length -1);
		
		for (int i =0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
