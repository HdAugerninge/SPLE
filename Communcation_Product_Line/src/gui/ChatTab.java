package gui;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private JTextPane textPaneChat, textPaneInput;
	
	public ChatTab(String name) {
		System.out.println(name + " created");
		this.name = name;
		initialize();
	}
	
	private void initialize(){
		// TODO Auto-generated constructor stub
		setLayout(null);
		setBounds(0, 0, 449, 300);
		
		JScrollPane scrollPaneChat = new JScrollPane();
		scrollPaneChat.setBounds(10, 11, 430, 126);
		add(scrollPaneChat);
		
		JTextPane textPaneChat = new JTextPane();
		scrollPaneChat.setViewportView(textPaneChat);
		
		JScrollPane scrollPaneInput = new JScrollPane();
		scrollPaneInput.setBounds(10, 163, 430, 126);
		add(scrollPaneInput);
		
		JTextPane textPaneInput = new JTextPane();
		scrollPaneInput.setViewportView(textPaneInput);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(10, 148, 430, 4);
		add(horizontalStrut);
		validate();
		setVisible(true);
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
