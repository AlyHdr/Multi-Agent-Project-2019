package multi_agent_project_2019;

import java.util.ArrayList;
import java.util.Collection;

public class Forum {
	private String owner;
	private String topic;
	private static ArrayList<ForumPost> posts;
	
	public Forum(String owner){
		this.owner = owner;
	}
	public Forum(String owner, String topic){
		this.owner = owner;
		this.topic = topic;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	public void createForum(String owner, String topic, ForumPost post) {
		this.topic = topic;
		this.owner = owner;
		Forum.posts.add(post);
	}
	
	public void addComment(ForumPost post) {
		Forum.posts.add(post);
	}
	

	public ArrayList<ForumPost> getPosts() {
		return posts;
	}
}
