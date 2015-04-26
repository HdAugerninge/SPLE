package Control;
//package Gui;

//import Gui;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub#
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}