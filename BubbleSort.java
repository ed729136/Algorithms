public class BubbleSort
{
	//Add elements to the array
	public static int[] PopulateArray( int[] array )
	{
		int length = array.length;
		
		for( int i = 0; i < length; ++i )
		{
			array[ i ] = ( int ) ( Math.random() * 200 );
		}
		return array;
	}
	
	/*Perform bubble sort, time complexity: O(n^2). As you go down the array compare the first element to the element to the right,
    if the element to the left is greater you swap them. Continue going down the array until the greatest number is in the highest index. 
	Repeat this process each time visiting one less element as you know that for each element you bubbled up the array that's one more element
	that's already in the right index. Use a butterfly swap so that you don't allocate extra space for a temporary variable*/
	public static void bubbleSort( int[] a )
	{
		int n = a.length;
			
		for( int i = 0; i < n - 1; ++i )
		{			
			for( int j = 0; j < n - i - 1; ++j )
			{	
				if( a[ j ] > a[ j + 1 ] )
				{
					a[ j ] ^= a[ j + 1 ];
					a[ j + 1 ] ^= a[ j ];
					a[ j ] ^= a[ j + 1 ];
				}
			}
		}
	}
	
	//Print the array and print a space between each new element	
	static void PrintArray( int[] array )
	{
		for( int i = 0; i < array.length; ++i )
		{
			System.out.print( array[ i ] + " " );
		}

		System.out.println();
	}
	
	public static void main( String[] args )
	{
		//Create a new array that will hold 20 elements and add integers into the array
		int[] data = new int[ 20 ];
		PopulateArray( data );
		
		//Print array elements before sorting
		System.out.println( "Before sorting: " );
		PrintArray( data );
		
		//Sort elements using bubble sort
		bubbleSort( data );
		
		//Print array elements after sorting
		System.out.println( "\nAfter sorting: " );
		PrintArray( data );	
	}
}