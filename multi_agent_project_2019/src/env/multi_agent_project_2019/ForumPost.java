package multi_agent_project_2019;

public class ForumPost {

	private String author;
	private String comment;

	public ForumPost(String author, String comment) {
		this.author = author;
		this.comment = comment;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
