package model;
import java.io.Serializable;


public class TextMessage extends Message implements Serializable {

	private static final long serialVersionUID = 8525619406594117531L;

	public TextMessage(Object sender, Object receiver, String payload) {
		super(sender, receiver);
		this.payload = payload;
	}

	@Override
	public String getMessagePaylaod() {
		return (String) payload;
	}
}
