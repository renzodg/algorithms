package examples.graphsearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindTheRunningMedian {
	
	public static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		if (lowers.isEmpty() || number < lowers.peek()) {
			lowers.add(number);
		} else {
			highers.add(number);
		}
	}
	
	public static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
		PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
		
		if (biggerHeap.size() - smallerHeap.size() >= 2) {
			smallerHeap.add(biggerHeap.poll());
		}
	}
	
	public static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
		PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
		
		if (biggerHeap.size() == smallerHeap.size()) {
			return ((double) biggerHeap.peek() + smallerHeap.peek())/ 2;
		} else {
			return biggerHeap.peek();
		}
	}
	
	public static double[] getMedians(int[] array) {
		PriorityQueue<Integer> lowers = new PriorityQueue<>( new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return -1 * a.compareTo(b);
			}
		});
		PriorityQueue<Integer> highers = new PriorityQueue<>();
		double[] medians = new double[array.length];
		for (int i = 0; i < array.length; i++) {
			int number = array[i];
			addNumber(number, lowers, highers);
			rebalance(lowers, highers);
			medians[i] = getMedian(lowers, highers);
		}
		
		return medians;
	}

	public static void main(String[] args) {
		double[] result = getMedians(new int[] {1,2,3,4,5});
		System.out.println(Arrays.toString(result));
	}
	
}
