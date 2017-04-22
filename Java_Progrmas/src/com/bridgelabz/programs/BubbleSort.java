package com.bridgelabz.programs;

public class BubbleSort {
	static Integer[] bubbleSort(Integer[] arr) {
		int n = arr.length;
		int swap = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (arr[j - 1] > arr[j]) {
					swap = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = swap;
				}

			}
		}
		return arr;
	}
}
