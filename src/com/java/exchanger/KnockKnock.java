package com.java.exchanger;

import java.util.concurrent.Exchanger;

/**
 * What Exchanger does is something very simple: it waits until both the threads
 * have called the exchange() method. When both threads have called the
 * exchange() method, the Exchanger object actually exchanges the data shared by
 * the threads with each other. This class is useful when two threads need to
 * synchronize between them and continuously exchange data. This class is a tiny
 * class with only one method:exchange();
 */

// Coordinate the silly talk between Duke and CoffeeShop by instantitaing the
// Exchanger object
// and the CoffeeShop and Duke threads
public class KnockKnock {
	public static void main(String[] args) {
		Exchanger<String> sillyTalk = new Exchanger<String>();
		new CoffeeShopThread(sillyTalk).start();
		new DukeThread(sillyTalk).start();
	}
}
