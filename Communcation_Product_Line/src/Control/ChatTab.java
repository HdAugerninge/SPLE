package Control;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JSeparator;

public class ChatTab extends JPanel{

	private String name;
	private JPanel panel;
	private JTextPane textPaneChat, textPaneInput;
	
	public ChatTab(String name) {
		super(true);
		System.out.println(name + " created");
		this.name = name;
		// TODO Auto-generated constructor stub
		panel = new JPanel();
		panel.setLayout(null);
		
		JScrollPane scrollPaneChat = new JScrollPane();
		scrollPaneChat.setBounds(10, 11, 430, 126);
		panel.add(scrollPaneChat);
		
		JTextPane textPaneChat = new JTextPane();
		scrollPaneChat.setViewportView(textPaneChat);
		
		JScrollPane scrollPaneInput = new JScrollPane();
		scrollPaneInput.setBounds(10, 163, 430, 126);
		panel.add(scrollPaneInput);
		
		JTextPane textPaneInput = new JTextPane();
		scrollPaneInput.setViewportView(textPaneInput);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(10, 148, 430, 4);
		panel.add(horizontalStrut);
		panel.setVisible(true);
		panel.update(getGraphics());
	}
	
	public String getChat (){
		return textPaneChat.getText();
	}
	
	public String getInput (){
		return textPaneInput.getText();
	}
	
	public void setChat (String text){
		textPaneChat.setText(text);
	}
	
	public void setInput (String text){
		textPaneInput.setText(text);
	}
	
	public String getName(){
		return name;
	}
}
