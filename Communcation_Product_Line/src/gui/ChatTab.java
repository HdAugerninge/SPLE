package gui;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.util.Calendar;
import java.util.List;


import Model.Person;
import java.text.SimpleDateFormat;


public class ChatTab extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Person> chatPartner;
	String names = "";
	private JTextPane textPaneChat, textPaneInput;
	
	public ChatTab(List<Person> chatPartner) {
		this.chatPartner = chatPartner;
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
		textPaneChat.setEditable(false);
		scrollPaneChat.setViewportView(textPaneChat);		
		textPaneChat.setText("Beginnen Sie eine Konversation");
		
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
	
	// Returns the Content of the textPaneChat Object
	public String getChat (){
		return textPaneChat.getText();
	}
	
	// Returns the Content of the textPaneInput Object
	public String getInput (){
		return textPaneInput.getText();
	}
	
	// Sets the Input of the textPaneChat Object
	public void setChat (String text){
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println(sdf.format(cal.getTime()));
		textPaneChat.setText(getChat () + "\n[" + sdf.format(cal.getTime()) +"]" + text);
	}
	
	// Sets the Input of the TextPane Input Object
	public void setInput (String text){
		textPaneInput.setText(text);
	}
	
	// Returns the Name of the Conversation
	// Listed all Persons in Group/Chat
	public String getName(){
		names = "";
		chatPartner.forEach((person) -> {names += person.getName() + ", ";});
		return names.substring(0, names.length() - 2);
	}
}
