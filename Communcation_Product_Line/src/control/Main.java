package control;

import config.Config;
import Model.Variance;
import gui.Gui;
//package Gui;
//import Gui;


public class Main {


	public static void main(String[] args) {
		
		String variant = "ultimate";
		if(args.length >0 && args[0] != null){
			variant = args[0];
		}
		
		Config.variant = variant;
	//	System.out.println(new Variance().hasCamera());
	//	System.out.println(Config.getInstance().getAllBindings());
		
		// TODO Auto-generated method stub#
				try {
					Gui window = new Gui();
					window.init();
				
				} catch (Exception e) {
					e.printStackTrace();
				}
		
	}

}
