// CArtAgO artifact code for project multi_agent_project_2019

package multi_agent_project_2019;


import java.awt.event.ActionEvent;
import java.util.ArrayList;


import cartago.*;
import cartago.tools.GUIArtifact;

public class Community_2 extends GUIArtifact {
	private TwitterFrame myFrame;
	private ArrayList<String> myMembers;
	void init(String title) {
		myFrame = new TwitterFrame();
		myFrame.setTitle(title);
		linkActionEventToOp(myFrame.getBtn_send_tweets(),"sendTweet");
		
		myFrame.setVisible(true);
		myMembers = new ArrayList<>();
		this.init();
	}
    @INTERNAL_OPERATION void sendMessage(ActionEvent ev){
    	String tweetContent = myFrame.getText_area_tweet_content().getText().trim();
    	String reciever = (String)myFrame.getCombo_recievers_names().getSelectedItem();
    	this.signal("cmdSendTweet",tweetContent,reciever);
    }
    @OPERATION
    void updateMembers(String tweet) {

    	String members[] = tweet.split(",");
    	myMembers = new ArrayList<>();
    	myFrame.getCombo_recievers_names().removeAllItems();
    	for (int i = 0; i < members.length; i++) {
			myMembers.add(members[i]);
			myFrame.getCombo_recievers_names().addItem(members[i]);
		}
    	
    }
    @OPERATION
    void updateTweets(String tweet) {

    	String tweets[] = tweet.split(",");
    	myFrame.getText_area_tweets().setText("");
    	for (int i = 0; i < tweets.length; i++) {
    		myFrame.getText_area_tweets().append(tweets[i]);
    	}
    	
    }
}

