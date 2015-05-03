package Model;
import java.io.Serializable;
import java.util.List;


public abstract class Message implements Serializable {

	private static final long serialVersionUID = 7979236396181547676L;
	protected Person sender;
	protected List<Person> receivers;
	protected Object payload;
	
	public Message(Person sender, List<Person> list) {
		this.sender = sender;
		this.receivers = list;
	}
	
	public Person getSender() {
		return sender;
	}

	public List<Person> getReceivers() {
		return receivers;
	}

	public abstract Object getMessagePaylaod();
}
