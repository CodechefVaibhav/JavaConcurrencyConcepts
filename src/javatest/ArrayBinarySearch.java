package javatest;

import java.util.Arrays;

public class ArrayBinarySearch {
	public static void  main(String... q){
		int[] prt = {7,3,5,2,9,1,0};
		Arrays.sort(prt);
		System.out.println(Arrays.binarySearch(prt, 9));
	}
}
