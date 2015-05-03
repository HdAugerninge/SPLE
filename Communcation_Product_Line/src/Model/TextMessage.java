package Model;
import java.io.Serializable;
import java.util.List;


public class TextMessage extends Message implements Serializable {

	private static final long serialVersionUID = 8525619406594117531L;
	private String receiversString = "";
	
	public TextMessage(Person sender, List<Person> list, String payload) {
		super(sender, list);
		this.payload = payload;
	}

	@Override
	public String getMessagePaylaod() {
		return (String) payload;
	}
	
	@Override
	public String toString() {
		this.receivers.forEach((receiver) -> receiversString += receiver.getName() + " ");
		return "Sender: " + sender.getName() + ", Receiver: " + receiversString + " Message: " + getMessagePaylaod();
	}
}
