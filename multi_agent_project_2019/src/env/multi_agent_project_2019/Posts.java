package multi_agent_project_2019;
import java.util.ArrayList;
public class Posts {
	



	
		private String owner;
		private ArrayList<String> posts;
		public Posts(String owner){
			this.owner = owner;
			posts = new ArrayList<>();
		}
		public String getOwner() {
			return owner;
		}
		private void addPost(String post) {
			posts.add(post);
		}
		public ArrayList<String> getPosts() {
			return posts;
		}
	


}
