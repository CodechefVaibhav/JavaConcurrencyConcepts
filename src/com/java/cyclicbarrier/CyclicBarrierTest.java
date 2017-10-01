package com.java.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * There are many situations in concurrent programming where threads may need to
 * wait at a predefined execution point until all other threads reach that
 * point. CyclicBarrier helps provide such a synchronization point;
 */
// Creates a CyclicBarrier object by passing the number of threads and the
// thread to run
// when all the threads reach the barrier
public class CyclicBarrierTest {
	public static void main(String[] args) {
		// a mixed-double tennis game requires four players; so wait for four
		// players
		// (i.e., four threads) to join to start the game
		System.out.println("Reserving tennis court \n As soon as four players arrive,game will start");
		CyclicBarrier barrier = new CyclicBarrier(4, new MixedDoubleTennisGame());
		new Player(barrier, "G I Joe");
		new Player(barrier, "Dora");
		new Player(barrier, "Tintin");
		new Player(barrier, "Barbie");
	}
}
