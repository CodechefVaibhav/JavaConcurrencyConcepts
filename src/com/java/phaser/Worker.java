package com.java.phaser;

import java.util.concurrent.Phaser;

//The work could be a Cook, Helper, or Attendant. Though the three work independently, the
//should all synchronize their work together to do their part and complete preparing a food item
public class Worker extends Thread {
	Phaser deliveryOrder;

	Worker(Phaser order, String name) {
		deliveryOrder = order;
		this.setName(name);
		deliveryOrder.register();
		start();
	}

	public void run() {
		for (int i = 1; i <= 2; i++) {
			System.out.println("\t" + getName() + " doing his work for order no. " + i);
			if (i == 1) {
				// work completed for this delivery order, so deregister
				deliveryOrder.arriveAndDeregister();
			} else {
				deliveryOrder.arriveAndAwaitAdvance();
			}
			try {
				Thread.sleep(3000); // simulate time for preparing the food item
			} catch (InterruptedException ie) {
				/* ignore exception */
				ie.printStackTrace();
			}
		}
	}
}
