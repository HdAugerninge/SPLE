package control;

import javax.swing.UIManager;

import config.Config;
import gui.Login;
//package Gui;
//import Gui;


public class Main {


	public static void main(String[] args) {
		
		String variant = "lite";
		if(args.length >0 && args[0] != null){
			variant = args[0];
		}
		
		Config.variant = variant;
	//	System.out.println(new Variance().hasCamera());
	//	System.out.println(Config.getInstance().getAllBindings());
		
		// TODO Auto-generated method stub#
				try {
					UIManager.setLookAndFeel(
				            UIManager.getSystemLookAndFeelClassName());
					Login login = new Login();
					login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		
	}

}
