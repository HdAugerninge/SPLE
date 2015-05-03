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
	// Serialnumber for variation
	private static final long serialVersionUID = 1L;
	// List for Chat-Partners
	private List<Person> chatPartner;
	// String for Tabname
	String names = "";
	String me_name = "";
	// Create TextPanes for Chat Tab
	private JTextPane textPaneChat, textPaneInput;
	
	// Creates a new ChatTab
	public ChatTab(List<Person> chatPartner,Person me) {
		this.chatPartner = chatPartner;
		me_name=me.getName();
		initialize();
	}
	
	/**
	 * initialize()
	 * Initializes the complete tab, including
	 * Both Panes for sending and receive,
	 * scrollPanes and strut.
	 */
	private void initialize(){
		// TODO Auto-generated constructor stub
		setLayout(null);
		setBounds(0, 0, 449, 300);		
		JScrollPane scrollPaneChat = new JScrollPane();
		scrollPaneChat.setBounds(10, 11, 430, 126);
		add(scrollPaneChat);		
		textPaneChat = new JTextPane();
		textPaneChat.setEditable(false);
		scrollPaneChat.setViewportView(textPaneChat);		
		textPaneChat.setText("Beginnen Sie eine Konversation");
		
		JScrollPane scrollPaneInput = new JScrollPane();
		scrollPaneInput.setBounds(10, 163, 430, 126);
		add(scrollPaneInput);
		
		textPaneInput = new JTextPane();
		scrollPaneInput.setViewportView(textPaneInput);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(10, 148, 430, 4);
		add(horizontalStrut);
		validate();
		setVisible(true);
	}
	
	// Returns the Content of the textPaneChat Object
	public String getChat(){
		return textPaneChat.getText().toString();
	}
	
	// Returns the Content of the textPaneInput Object
	public String getInput(){
		return textPaneInput.getText().toString();
	}
	
	// Sets the Input of the textPaneChat Object
	public void setChat (String text){
		// Creating Timestamp
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		// Setting actual Textoutput
		textPaneChat.setText(getChat () + "\n[" + sdf.format(cal.getTime()) + " " + text);
		clearInput();
	}
	
	// Sets the Input of the TextPaneInput Object
	public void setInput (String text){
		textPaneInput.setText(text);
	}
	
	// Clears the content of the TextPaneInput Object
	private void clearInput(){
		textPaneInput.setText("");
	}
	
	// Returns the Name of the Conversation
	// Listed all Persons in Group/Chat
	public String getName(){
		names = me_name + "-->";
		chatPartner.forEach((person) -> {names += person.getName() + ", ";});
		return names.substring(0, names.length() - 2);
	}
	
	public List<Person> getChatPartners() {
		return chatPartner;
	}
}
