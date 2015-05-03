package Model;
import java.io.Serializable;
import java.util.List;


public class TextMessage extends Message implements Serializable {

	private static final long serialVersionUID = 8525619406594117531L;

	public TextMessage(Person sender, List<Person> list, String payload) {
		super(sender, list);
		this.payload = payload;
	}

	@Override
	public String getMessagePaylaod() {
		return (String) payload;
	}
}
