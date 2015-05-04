package control;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.UIManager;

import Model.Person;
import config.Config;
import gui.Gui;



public class Main {


	public static void main(String[] args) {
		
		String variant = "lite";
		if(args.length >0 && args[0] != null){
			variant = args[0];
		}
		
		Config.variant = variant;
	//	System.out.println(new Variance().hasCamera());
	//	System.out.println(Config.getInstance().getAllBindings());
		String avatarname = "Beate"; //TODO �bergeben
		Person me = new Person(avatarname);
		System.out.println(me);
		// TODO Auto-generated method stub#
		Gui window = null;
				try {
					UIManager.setLookAndFeel(
				            UIManager.getSystemLookAndFeelClassName());
					
				
					
				
					window = new Gui(me);
					window.init();
					window.frame.addWindowListener(new WindowListener() {
						
						@Override
						public void windowOpened(WindowEvent e) {				
						}
						
						@Override
						public void windowIconified(WindowEvent e) {				
						}
						
						@Override
						public void windowDeiconified(WindowEvent e) {				
						}
						
						@Override
						public void windowDeactivated(WindowEvent e) {				
						}
						
						@Override
						public void windowClosing(WindowEvent e) {		
							try {
								//Variationspunkt einbringen
								Files.deleteIfExists(Paths.get(System.getProperty("java.io.tmpdir") + File.separator + "messagepipe.bin"));
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
						
						@Override
						public void windowClosed(WindowEvent e) {

						}
						
						@Override
						public void windowActivated(WindowEvent e) {				
						}
					});
				
				} catch (Exception e) {
					e.printStackTrace();
				}
		
				Manager manager = new Manager(window,me);
				System.out.println("check");
				window.addSendOnClick(manager);//initialize send button
	}

}
