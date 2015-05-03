package Model;
import java.io.Serializable;
import java.util.List;


public abstract class Message implements Serializable {

	private static final long serialVersionUID = 7979236396181547676L;
	Person sender;
	List<Person> receivers;
	Object payload;
	
	public Message(Person sender, List<Person> list) {
		this.sender = sender;
		this.receivers = list;
	}

	public abstract Object getMessagePaylaod();
}
