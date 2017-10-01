package com.java.concurrentcollections;

import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueExample {
	public static void main(String[] args) {
		final PriorityBlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<>();
		new Thread() {
			public void run() {
				try {
					// use take() instead of remove()
					// note that take() blocks, whereas remove() doesn't block
					System.out.println("The removed element is: " + priorityBlockingQueue.take());
				} catch (InterruptedException ie) {
					// its safe to ignore this exception
					ie.printStackTrace();
				}
			}
		}.start();
		new Thread() {
			public void run() {
				// add an element with value 10 to the priority queue
				priorityBlockingQueue.add(10);
				System.out.println("Successfully added an element to the queue ");
			}
		}.start();
	}
}
