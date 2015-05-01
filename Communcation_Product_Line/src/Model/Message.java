package model;
import java.io.Serializable;


public abstract class Message implements Serializable {

	private static final long serialVersionUID = 7979236396181547676L;
	Person sender;
	Person[] receivers;
	Object payload;
	
	public Message(Person sender, Person[] receivers) {
		this.sender = sender;
		this.receivers = receivers;
	}

	public abstract Object getMessagePaylaod();
}
