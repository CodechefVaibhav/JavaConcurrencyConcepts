package com.java.exchanger;

import java.util.concurrent.Exchanger;

public class CoffeeShopThread extends Thread {

	private Exchanger<String> sillyTalk;

	public CoffeeShopThread(Exchanger<String> args) {
		sillyTalk = args;
		//this.start();
	}

	public void run() {
		String reply = null;
		try {
			// exchange the first messages
			reply = sillyTalk.exchange("Who's there?");
			// print what Duke said
			System.out.println("Duke: " + reply);
			callSleep();
			// exchange second message
			reply = sillyTalk.exchange("Duke who?");
			// print what Duke said
			System.out.println("Duke: " + reply);
			callSleep();
			// there is no message to send, but to get a message from Duke
			// thread,
			// both ends should send a message; so send a "dummy" string
			reply = sillyTalk.exchange("");
			System.out.println("Duke: " + reply);
		} catch (InterruptedException ie) {
			System.err.println("Got interrupted during my silly talk");
		}
	}

	public void callSleep() {
		try {
			this.sleep(1000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}
