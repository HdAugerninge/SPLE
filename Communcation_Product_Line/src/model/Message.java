package model;
import java.io.Serializable;


public abstract class Message implements Serializable {

	private static final long serialVersionUID = 7979236396181547676L;
	Object sender;
	Object receiver;
	Object payload;
	
	public Message(Object sender, Object receiver) {
		this.sender = sender;
		this.receiver = receiver;
	}

	public abstract Object getMessagePaylaod();
}
