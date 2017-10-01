package com.java.cyclicbarrier;

//The run() method in this thread should be called only when four players are ready to start the game
public class MixedDoubleTennisGame implements Runnable{
	public void run() {
		System.out.println("All four players ready, game starts \n Love all...");
	}
}
