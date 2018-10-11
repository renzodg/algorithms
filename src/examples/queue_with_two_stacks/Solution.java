package examples.queue_with_two_stacks;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		MyQueue<Integer> myQueue = new MyQueue<>();
		myQueue.enqueue(1);
		myQueue.enqueue(2);
		System.out.println("result: " + myQueue.peek());
	}

	public static class MyQueue<T> {
		private Stack<T> stackNewestOnTop = new Stack<T>();
		private Stack<T> stackOldestOnTop = new Stack<T>();

		public void enqueue(T value) {
			stackNewestOnTop.push(value);
		}

		private void shiftStacks() {
			if (stackOldestOnTop.isEmpty()) {
				while (!stackNewestOnTop.isEmpty()) {
					System.out.println(stackNewestOnTop.peek());
					stackOldestOnTop.push(stackNewestOnTop.pop());
				}
			}
		}

		public T peek() {
			shiftStacks();
			return stackOldestOnTop.peek();
		}
		
		public T dequeue() {
			shiftStacks();
			return stackOldestOnTop.pop();
		}
	}
}
