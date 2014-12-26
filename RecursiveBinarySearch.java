package sorts;

import java.util.Arrays;

public class RecursiveBinarySearch
{
	//This search algorithm eliminates half the array every time it compares the key to an element in the array
	public static int BinarySearch( int[] array, int numToLookFor, int low, int high )
	{
		//This means that the pointers crossed and number was not in the array
		if( low > high )
		{ 
			System.out.println( "Number was not in the array" );
			return -1;
		}
		
		//Middle is the "middle" element of the array
		//Middle is what causes this algorithm to be O( ( log base 2 ) n )
		//This is a recursive function and a new middle is calculated every time through
		int middle = low + ( high - low ) / 2;
		
		//The number in the array and the number looked at are the same
		//therefore you can return and say that you found the number
		if( numToLookFor == array[ middle ] )
		{
			System.out.println( "Number was found in the array at position " + middle );
			return middle;
		}
		
		//The number that you're looking for is less than the middle element in the array
		//therefore you can now search in the left half of the array
		else if( numToLookFor < array[ middle ] )
		{
			return BinarySearch( array, numToLookFor, low, middle - 1 );
		}
		
		//The number that you're looking for is greater than the middle element in the array
		//therefore you can now search in the right half of the array
		else
		{
			return BinarySearch( array, numToLookFor, middle + 1, high );
		}
	}
	
	//This populates the array with numbers between 0-20
	public static int[] PopulateArray( int[] array )
	{
		int length = array.length;
		
		for( int i = 0; i < length; ++ i )
		{
			array[ i ] = ( int ) ( Math.random() * 20 + 1 );
		}
		return array;
	}
	
	//This function prints the array
	public static void PrintArray( int[] array )
	{
		int length = array.length;
		
		for( int i = 0; i < length; ++ i )
		{
			System.out.print( array[ i ] + " " );
		}
		System.out.println( "\n" );
	}
	
	public static void main( String[] args )
	{
		int[] array = new int[ 10 ];
		int length = array.length - 1;
		
		PopulateArray( array );
		Arrays.sort( array );
		PrintArray( array );
		
		BinarySearch( array, 20, 0, length );
	}
}