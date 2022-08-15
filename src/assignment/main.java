/*
 * @author Talha Guzel 041802046
 * @since 09.01.2021
 * Analyze the search performance of Array lists, linked lists, hash maps and binary search trees data structures
 * */
package assignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class main {

	public static void main(String[] args) throws IOException {

		// Creating 1000-valued arrays
		int quantityM = 1000;
		int[] numbers = new int[quantityM];

		for (int i = 0; i < quantityM; i++) {
			numbers[i] = i + 1;
		}

		// Creating a object for Random class
		Random r = new Random();

		// Change one by one, starting from the end.

		for (int i = numbers.length - 1; i > 0; i--) {

			// Choosing a random index from o to i
			int j = r.nextInt(i);

			// Replacing numbers [i] with a random index
			int temp = numbers[i];
			numbers[i] = numbers[j];
			numbers[j] = temp;
		}
		// Create an Arraylist
		ArrayList<Integer> numbersArrayList = new ArrayList<Integer>();
		// Throwing the numbers in the arraylist
		for (int i = 0; i < quantityM; i++) {
			numbersArrayList.add(numbers[i]);
		}
		// Create an Linkedlist
		LinkedList<Integer> numbersLinkedList = new LinkedList<Integer>();
		// Throwing the numbers in the linkedlist
		for (int i = 0; i < quantityM; i++) {
			numbersLinkedList.add(numbers[i]);
		}
		// Create an HashMap
		HashMap<Integer, Integer> numbersHashMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < quantityM; i++) {
			numbersHashMap.put(numbers[i], numbers[i]);
		}
		// Create an BinarySearchTree
		BST<Integer> numbersBST = new BST<Integer>();
		
		// Inserting the numbers in BST
		for (int i = 0; i < quantityM; i++) {
			numbersBST.insert(numbers[i]);
		}
		// Keeping the startup millisecond for ArrayListMS1
		long ArrayListMS1 = System.currentTimeMillis();
		
		// Search as many as all numbers in arraylist
		for (int i = 0; i < numbersArrayList.size(); i++) {
			numbersArrayList.contains(i);
		}
		
		// Keeping the startup millisecond for ArrayListMS2
		long ArrayListMS2 = System.currentTimeMillis();
		
		// Keeping the startup millisecond for LinkedListMS1
		long LinkedListMS1 = System.currentTimeMillis();
		
		// Search as many as all numbers in linkedlist
		for (int i = 0; i < numbersLinkedList.size(); i++) {
			numbersLinkedList.contains(i);
		}

		// Keeping the startup millisecond for LinkedListMS2
		long LinkedListMS2 = System.currentTimeMillis();

		// Keeping the startup millisecond for HashMapListMS1
		long HashMapListMS1 = System.currentTimeMillis();

		// Search as many as all numbers in hashmap
		for (int i = 0; i < numbersHashMap.size(); i++) {
			numbersHashMap.containsKey(i);
		}

		long HashMapListMS2 = System.currentTimeMillis();

		long BSTListMS1 = System.currentTimeMillis();

		for (int i = 0; i < numbersBST.getSize(); i++) {
			numbersBST.search(i);
		}

		long BSTListMS2 = System.currentTimeMillis();
		// Subtracting the first and last times to find the difference
		System.out.println(quantityM + " " + (ArrayListMS2 - ArrayListMS1) + " " + (LinkedListMS2 - LinkedListMS1) + " "
				+ (HashMapListMS2 - HashMapListMS1) + " " + (BSTListMS2 - BSTListMS1));

	}
}