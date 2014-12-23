/*
 * Implementation of merge sort, needs to be improved as there are areas that could use some work
 * Made this program by following this tutorial https://www.youtube.com/watch?v=9Qk1t66g7IU
 */

package mergeSort;

import java.util.Arrays;

public class MergeSort
{
	//This method gives each position of the array a number between 0 and 99
	//Math.random returns a number equal to or greater than 0 and less than 1
	//Have to cast that to an int because if not we would get back double values
	public static int[] populateArray( int[] array )
	{
		int length = array.length;
		
		for( int i = 0; i < length; ++i )
		{
			array[ i ] = ( int ) ( Math.random() * 100 );
		}
		return array;
	}
	
	//This is a method that prints all of the array elements
	public static void PrintArray( int[] array )
	{
		int length = array.length;
		
		for( int i = 0; i < length; ++i )
		{
			System.out.print( array[ i ] + " " );
		}
	}
	
	public static int[] mergeSort( int[] array )
	{
		int length = array.length;
		if( length <= 1 )
		{
			return array;
		}
		
		//find the midpoint length of the array
		int midpoint = length / 2;
		
		//Set up a left array and a right array
		//Depending if the number of elements in the array is even or not that's how we
		//figure out where to start the index for the right array
		int[] left = new int[ midpoint ];
		int[] right;
		
		if( length % 2 == 0 ) { right = new int[ midpoint ]; }
		
		else { right = new int[ midpoint + 1 ]; }
		
		//This array is where we are going to store our results of comparing
		//the left and right arrays for smallest value
		int[] result = new int[ length ];
		
		for( int i = 0; i < midpoint; ++i )
		{
			left[ i ] = array[ i ];
		}
		
		int zero = 0;
		for( int j = midpoint; j < length; ++j )
		{
			if( zero < right.length )
			{
				right[ zero ] = array[ j ];
				zero++;
			}
		}
		
		left = mergeSort( left );
		right = mergeSort( right );
		
		result = merge( left, right );
		return result;
	}
	
	public static int[] merge( int[] left, int[] right )
	{
		//the length of the result array is the combination of the left array and right array
		//indexL is the pointer to the element in the left array
		//indexR is the pointer to the element in the right array
		int lengthResult = left.length + right.length;
		int[] result = new int[ lengthResult ];
		int indexL = 0;
		int indexR = 0;
		int indexRes = 0;
		
		//The left and right pointers have not fallen of and are still pointing to something valid
		while( indexL < left.length || indexR < right.length )
		{
			//If neither the right pointer or left pointer have fallen off, then compare the contents in left
			//and right and add the smallest value to the result arrays
			if( indexL < left.length && indexR < right.length )
			{
				if( left[ indexL ] <= right[ indexR ] )
				{
					result[ indexRes++ ] = left[ indexL++ ];
				}
				
				else
				{
					result[ indexRes++ ] = right[ indexR++ ];
				}
			}
			
			//If there are only elements left in the left array
			else if( indexL < left.length )
			{
				result[ indexRes++ ] = left[ indexL++ ];
			}
			
			//If there are only elements left in the right array
			else if( indexR < right.length )
			{
				result[ indexRes++ ] = right[ indexR++ ];
			}
		}
		return result;
	}
	
	public static void main( String[] args )
	{
		//Store some random integers in our array, these integers will be between 0 and 99
		//Print the array before sorting
		//Call mergeSort and print the array after sorting
		int array[] = new int[10];
		populateArray( array );
		System.out.println( "Before sorting:" );
		PrintArray( array );
		
		array = mergeSort( array );
		System.out.println( "\nAfter sorting:" );
		PrintArray( array );
		
	}
}