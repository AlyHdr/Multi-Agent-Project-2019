package multi_agent_project_2019;
import java.util.ArrayList;
public class Twitter {
	



	
		private String owner;
		private ArrayList<String> tweets;
		public Twitter(String owner){
			this.owner = owner;
			tweets = new ArrayList<>();
		}
		public String getOwner() {
			return owner;
		}
		private void addTweet(String tweet) {
			tweets.add(tweet);
		}
		public ArrayList<String> getTwitter() {
			return tweets;
		}
	


}
