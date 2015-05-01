package Model;
import java.io.Serializable;


public class TextMessage extends Message implements Serializable {

	private static final long serialVersionUID = 8525619406594117531L;

	public TextMessage(Person sender, Person[] receivers, String payload) {
		super(sender, receivers);
		this.payload = payload;
	}

	@Override
	public String getMessagePaylaod() {
		return (String) payload;
	}
}
