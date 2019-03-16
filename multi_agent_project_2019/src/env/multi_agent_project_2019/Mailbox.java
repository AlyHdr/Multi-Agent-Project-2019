package multi_agent_project_2019;

import java.util.ArrayList;

public class Mailbox {
	private String owner;
	private ArrayList<String> messages;
	public Mailbox(String owner){
		this.owner = owner;
		messages = new ArrayList<>();
	}
	public String getOwner() {
		return owner;
	}
	private void addMessage(String message) {
		messages.add(message);
	}
	public ArrayList<String> getMessages() {
		return messages;
	}
}
