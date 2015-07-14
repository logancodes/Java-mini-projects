/*
 * HeapPriorityQueue.java
 *
 * CSC 115: Assignment 6 sample code.
 *
 * Comments from the sample solution:
 *
 * An implementation of a PriorityQueue using a heap.
 * based on the implementation in "Data Structures and Algorithms
 * in Java", by Goodrich and Tamassia
 * 
 * However, this implementation maintains the 
 * complete binary tree as a protected array, not a distinct class.
 *
 * I have also removed the Comparator from the code.  It is a
 * good practice to make a Priority Queue generic, but I think it
 * makes the code too complicated for our purposes.
 *
 * Instead, we will rely on the Comparable interface that is implemented
 * by Objects and their subclasses (although if you define your own class
 * you will need to implement the compareTo method to return something
 * meaningfull) 
 *
 * I have also removed the Entry interface.  This priority queue only deals
 * with keys.
 */
 
public class HeapPriorityQueue implements PriorityQueue
{
	protected final static int DEFAULT_SIZE = 10000;
	
	/* This array is where you will store the elements in the heap */
	protected Comparable storage[];

	/* Keep track of the current number of elements in the heap */
	protected int currentSize;
			
	/* You do not need to change this constructor */
	public HeapPriorityQueue () 
	{
		this(DEFAULT_SIZE);
	}

	/* You do not need to change this constructor */
	public HeapPriorityQueue(int size)
	{
		storage = new Comparable[size + 1];
		currentSize = 0;
	}
	
	/*
	 * You need to change the implementation of every public method
 	 * below this comment.
	 *
	 */
	public int size ()
	{
		return currentSize;
	}
	
	public boolean isEmpty ( )
	{
		return size() == 0;
	}
	
	public Comparable removeMin () throws HeapEmptyException
	{
		
		if(currentSize==1){
			Comparable element=storage[1];
			storage[1]=null;
			currentSize--;
			return element;
		}
		else{
			Comparable element=storage[1];
			storage[1]=storage[currentSize];
			storage[currentSize]=null;
			if(storage[leftChild(1)]==null){
				currentSize--;
				return element;
			}			
			currentSize--;
			bubbleDown();
			return element;	
		}
	}
	
	public void insert ( Comparable k  ) throws HeapFullException
	{
		if(currentSize==0){
			storage[1]=k;
			currentSize++;
		}
		else{
		storage[currentSize+1]=k;
		currentSize++;
		bubbleUp();
		}
	}

	/* Your instructor's solution used the following helper methods
	 * 
	 * You do not need to use the same methods, but you may want to.
	 */
		
	/* 
	 * A new value has just been added to the bottom of the heap
	 * "bubble up" until it is in the correct position
	 */
	private void bubbleUp ( ) 
	{
		
		int i=currentSize;
		do{
			if(storage[parent(i)].compareTo(storage[i])>0){
					swapElement(parent(i),i);
					i=parent(i);
					
			}
			else{
				return;
			}
		}while(storage[parent(i)]!=null);
	}

	/*
	 * Because of a removeMin operation, a value from the bottom
	 * of the heap has been moved to the root.
	 * 
	 * "bubble down" until it is in the right position
	 */
	private void bubbleDown() 
	{
		int i=1;
		while(hasLeft(i)||hasRight(i)){
			if(hasLeft(i)&&hasRight(i)){
				if(storage[leftChild(i)].compareTo(storage[rightChild(i)])<=0){
					if(storage[i].compareTo(storage[leftChild(i)])>=0){
					swapElement(i,leftChild(i));
					i=leftChild(i);
					}
					else return;
				}
				else if(storage[leftChild(i)].compareTo(storage[rightChild(i)])>=0){
					if(storage[i].compareTo(storage[rightChild(i)])>=0){
						swapElement(i,rightChild(i));
						i=rightChild(i);
					}
					else return;
				}
			}
			else if(hasLeft(i)==true && hasRight(i)==false){
				if(storage[i].compareTo(storage[leftChild(i)])>0){
					swapElement(i,leftChild(i));
					return;
				}
				else{
					return;
				}
			
			}
			else{
				return;
			}
		}
		
	}	

	/*
	 * Swap the element at position p1 in the array with the element at 
	 * position p2
	 */
	private void swapElement ( int p1, int p2 )
	{
		Comparable [] temp=new Comparable[1];
		temp[0]=storage[p1];
		storage[p1]=storage[p2];
		storage[p2]=temp[0];
		
	}
	
	/*
	 * Return the index of the parent of the node at pos
	 */
	private int parent ( int pos )
	{
		int parent_node=pos/2;
		return parent_node;
	}
	
	/* 
	 * Return the index of the left child of the node at pos
	 */
	private int leftChild ( int pos )
	{
		return pos*2; 
	}
	
	/* 
	 * Return the index of the right child of the node at pos
	 */
	private int rightChild ( int pos )
	{
		int right_child=pos*2+1;
		return right_child; 
	}
	
	/*
	 * Given the current number of elements in the heap, does the
	 * node at pos have a left child?
	 *
	 * Note that all internal nodes have at least a left child.
	 *
	 */
	private boolean hasLeft ( int pos )
	{
		if(pos*2<=currentSize)return true;
		else return false;
	}

	/*
	 * Given the current number of elements in the heap, does the
	 * node at pos have a right child?
	 */	
	private boolean hasRight ( int pos )
	{
		if(pos*2+1<=currentSize)return true;
		else return false;
	}
}
