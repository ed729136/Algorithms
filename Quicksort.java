/*
 * The quicksort part of the program was developed with the help of Algolist.net
 * http://www.algolist.net/Algorithms/Sorting/Quicksort
 */
package sorts;

public class Quicksort
{
	//This gives the array random values between 0-200
	public static int[] populateArray( int[] array )
	{
		int length = array.length;
		
		for( int i = 0; i < length; ++i )
		{
			array[ i ] = ( int ) ( Math.random() * 201 );
		}
		return array;
	}
	
	//This method prints the array
	public static void printArray( int[] array )
	{
		int length = array.length;
		
		for( int i = 0; i < length; ++i )
		{
			System.out.print( array[ i ] + " " );
		}
	}
	
	/*
	 * Create a lower pointer that will start at the beginning of the array
	 * Create an upper pointer that will start at the end of the array
	 * Pivot will be approximately at the middle of the array 
	 */
	public static int partition( int[] array, int left, int right )
	{
		int lower = left, upper = right;
		int pivot = array[ ( left + right ) / 2 ];
		int temp;
		
		//The condition where the upper and lower bounds have not crossed, they are either at their respective side of the array or looking at the same element
		while ( lower <= upper )
		{
			//We are looking for elements in the left part of the array which their value is higher than the pivot so we can swap them to the right of the array
			//Therefore this condition is saying that while the element in the left array is lower than the pivot, keep looking
			while ( array[ lower ] < pivot )
			{
				lower++;
			}
			
			//We are looking for elements in the right part of the array which their value is less than the pivot so we can swap them to the left of the array
			//Therefore this condition is saying that while the element in the right array is higher than the pivot, keep looking
			while ( array[ upper ] > pivot ) 
			{ 
				upper--;
			}
			
			//This means that it found an element in the wrong side of the array and an element from one side of the array needs to be swapped with an element from the other side
			//Perform swap and advance pointers accordingly
			if( lower <= upper )
			{
				temp = array[ lower ];
				array[ lower ] = array[ upper ];
				array[ upper ] = temp;
				lower++;
				upper--;
			}
		}
		return lower;
	}
	
	public static void quickSort( int array[], int left, int right )
	{
		//This is the call that divides the array
		int index = partition( array, left, right );
		
		//Recursively call quick sort with the left part of the divided array
		if ( left < index - 1 )
		{ 
			quickSort( array, left, index - 1 ); 
		}
		
		//Recursively call quick sort with the right part of the divided array
		if ( index < right )
		{ 
			quickSort( array, index, right );
		}
	}
	
	public static void main( String[] args )
	{
		//Create an array, give it 20 random elements and print the array before sorting
		int[] array = new int[ 20 ];
		populateArray( array );
		System.out.println( "Before sorting:" );
		printArray( array );
		
		//Perform the sort and print the array after sorting
		quickSort( array, 0, array.length - 1 );
		System.out.println();
		System.out.println( "\nAfter sorting:" );
		printArray( array );
	}
}