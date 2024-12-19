package com.gajula.faqs.features;

import java.util.Arrays;

public class ParallelSort {

	public static void main(String[] args) {
		int[] arr = { 5, 8, 1, 0, 6, 9 };
		for (int i : arr) {
			System.out.print(i + " ");
		}
		
		Arrays.parallelSort(arr, 0, 3);
		System.out.println("\nArray elements after sorting using index");
		for (int i : arr) {
			System.out.print(i + " ");
		}

		Arrays.parallelSort(arr);
		System.out.println("\nArray elements after sorting");
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
