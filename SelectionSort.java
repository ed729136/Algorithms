public class SelectionSort
{
	public static void main( String[] args )
	{
		int[] array = new int[ 20 ];
		PopulateArray( array );
		System.out.println( "Before sorting:" );
		PrintArray( array );
		SelectionSort( array );
		System.out.println( "After sorting:" );
		PrintArray( array );
	}
	
	/*
	 * This function sorts all the items in the array, keeps track of index with smallest value
	 * It will swap the values in the indexes that is currently pointing to with the lowest value that 
	 * it found in that pass. Will not do anything if it does not find a smallest value in that pass.
	 */
	static void SelectionSort( int[] array )
	{
		int length = array.length;
		/*
		 * First for loop goes through the array slowly, looking at one position
		 * at a time
		 */
		for( int i = 0; i < length - 1; ++i )
		{	
			int smallestEntry = i;
			
			/*
			 * Second for loop visits every position in the array while the first one 
			 * stays at the same, the second for loop is looking for values smaller than
			 * the value that the first for loop is at.
			 * 
			 * If it finds a value that is smaller it will update the variable that is holding
			 * the index of smallest value
			 */
			for( int j = i + 1; j < length; ++j )
			{
				if( array[ smallestEntry ] > array[ j ] )
				{
					smallestEntry = j;
				}
			}
			
			int swap = array[ smallestEntry ];
			array[ smallestEntry ] = array[ i ];
			array[ i ] = swap;
		}
	}
	
	/*
	 * This function prints all the values of the array with a space in between them
	 * It prints a new line after it's done printing all the values in the array
	 */
	static void PrintArray( int[] array )
	{
		for( int i = 0; i < array.length; ++i )
		{
			System.out.print( array[ i ] + " " );
		}
		System.out.println( "\n" );
	}

	// This function populates the array with integers between 1-200
	static int[] PopulateArray( int[] array )
	{
		int length = array.length;
		
		for( int i = 0; i < length; ++i )
		{
			array[ i ] = ( int ) ( Math.random() * 200 + 1 );
		}
		return array;
	}
}