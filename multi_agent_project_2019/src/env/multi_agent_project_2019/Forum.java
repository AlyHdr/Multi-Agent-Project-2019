package multi_agent_project_2019;

import java.util.ArrayList;

public class Forum {
	private String owner;
	private String topic;
	private ArrayList<String> posts;
	public Forum(String owner){
		this.owner = owner;
		this.topic = "";
		posts = new ArrayList<>();
	}
	public String getOwner() {
		return owner;
	}
	private void createForum(String topic, String post) {
		this.topic = topic;
		posts.add(post);
	}
	private void addPost(String post) {
		posts.add(post);
	}
	
	private String getTopic() {
		return topic;
	}
	public ArrayList<String> getPosts() {
		return posts;
	}
}
