package heaps;
/*
 * 
 * Author : Aamin Lakhani
 * Date : 03/12/2016
 * 
 * Implementation of a max heap
 */
public class MaxHeap {

	private int heapSize;
	
	private int [] heap;
	
	int currIndex;
	
	public MaxHeap(int heapSize) {
		// TODO Auto-generated constructor stub
		heap = new int [heapSize];
		currIndex = 0;
	}
	
	private int getParent (int pos) {
		
		System.out.println("parent  " + pos + " is" + (int)(Math.ceil((double)pos/2.0) - 1.0));
		return (int)(Math.ceil((double)pos/2.0) - 1.0) ;
	}
	
	private void remove() {
		if (currIndex > 0) {
			heap[0] = heap[--currIndex];
			heapify(0);
		}
		
	}
	
	private int getLeftChild (int pos) {
		
		return (pos * 2) + 1;
	}
	
	private int getRightChild(int pos) {
		
		return (pos * 2) + 2;
	}
	
	private void insert (int element) {
		
		heap[currIndex] = element;
		int temp = currIndex;
		
		while (temp > 0 && heap[temp] > heap[getParent(temp)]) {
			swap(temp, getParent(temp));
			temp = getParent(temp);
		}
		currIndex ++;
		heapify(temp);
		
	}
	
	private boolean isLeaf(int pos) {
		
		if (pos < heapSize/2 && pos < heapSize) {
			return true;
		}
		return false;
	}
	
	private void swap (int pos1, int pos2) {
		int temp = heap[pos1];
		heap[pos1] = heap[pos2];
		heap[pos2] = temp;
	}
	
	private void heapify (int pos) {
		
		if (!isLeaf(pos)) {
			
			if (heap[pos] < heap[getLeftChild(pos)] || heap[pos] < heap[getRightChild(pos)] ) {
				if (heap[getLeftChild(pos)] > heap[getRightChild(pos)]) {
					swap (pos, getLeftChild(pos));
					heapify(getLeftChild(pos));
				}
				else {
					swap (pos, getRightChild(pos));
					heapify(getRightChild(pos));
				}
			}
			
		}
	}
	
	private void printHeap() {
		for (int i = 0; i< currIndex; i++) {
			System.out.println(heap[i]);
		}
	}
	
	public static void main (String args[]) {
	
		MaxHeap heap = new MaxHeap(20);
		heap.insert(5);
		heap.insert(3);
		heap.insert(17);
		heap.insert(10);
		heap.insert(84);
		heap.insert(19);
		heap.insert(6);
		heap.insert(22);
		heap.insert(9);
		heap.remove();
		heap.remove();
		heap.printHeap();
		
	}
}
