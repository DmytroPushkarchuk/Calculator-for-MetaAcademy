package calculator;

import java.awt.EventQueue;


public class Main {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Calculator();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
