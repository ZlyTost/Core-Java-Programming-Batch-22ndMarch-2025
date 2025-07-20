package Day14;

import java.util.Arrays;

//Merging Two Arrays
public class p18 {
	    public static void main(String[] args) {
	        int[] array1 = {1, 2, 3};
	        int[] array2 = {4, 5, 6};

	        int[] mergedArray = new int[array1.length + array2.length];

	        System.arraycopy(array1, 0, mergedArray, 0, array1.length);
	        System.arraycopy(array2, 0, mergedArray, array1.length, array2.length);
	        /*
	         Parameters:
	         src the source array.
	         srcPos starting position in the source array.
	         dest the destination array.
	         destPos starting position in the destination data.
	         length the number of array elements to be copied. 
	         */

	        System.out.println("Merged Array: " + Arrays.toString(mergedArray));
	    }
	}