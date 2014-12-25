package sorts;

public class InsertionSort 
{   
    public static void Insertionsort( int[] array )
    {
    	/*
    	 * Insertion sort starts at one because the algorithm assumes that
    	 * one starts with a one element array, index 0 and that's already sorted
    	 */
    	for( int index = 1; index < array.length; ++index )
    	{
    		int j = index;

    		/*
    		 * While still in bounds and the value in lower index is greater than the higher index
    		 * do a butterfly swap which doesn't add to the space complexity
    		 */
    		while( j > 0 && array[ j - 1 ] > array[ j ] )
    		{
    			array[ j - 1 ] ^= array[ j ];
    			array[ j ] ^= array[ j - 1 ];
    			array[ j - 1 ] ^= array[ j ];
    			
    			j -= 1;
    		}
    	}
    }
    
    /*
     * Go from the first index of the array to the last printing all elements
     */
    public static void Print( int[] array )
    {
    	for( int i = 0; i < array.length; ++i )
    	{
    		System.out.print( array[ i ] + " " );
    	}
    	
    	System.out.println();
    }
    
    // This methods populates the array with numbers between 
    public static int[] PopulateArray( int[] array )
    {
    	int length = array.length;
    	
    	for( int i = 0; i < length; ++i )
    	{
    		array[ i ] = ( int ) ( Math.random() * 201 ) + 1;
    	}
    	return array;
    }
    
    /*
     * 
     * Print array before being sorted
     * Call Insertion Sort 
     * Print array after elements are sorted
     */
    public static void main( String[] args )
    {
    	int array[] = new int[ 20 ];
    	PopulateArray( array );
    	
    	System.out.println( "Before sorting: " );
    	Print( array );
    	
    	Insertionsort( array );
    	System.out.println( "\nAfter sorting: " );
    	Print( array );
    }

}