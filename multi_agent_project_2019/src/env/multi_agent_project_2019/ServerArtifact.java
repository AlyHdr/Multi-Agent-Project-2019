// CArtAgO artifact code for project multi_agent_project_2019

package multi_agent_project_2019;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cartago.*;
import cartago.tools.GUIArtifact;

public class ServerArtifact extends GUIArtifact {
	private Frame frame;
	private ArrayList<Community> communities;
	private ArrayList<Mailbox> mailboxes;
	private ArrayList<Twitter> twitters;
	private boolean locked; 
	private ArrayList<Posts> posts;
	public void init(String title) {
		frame = new Frame();
		frame.setTitle(title);
		frame.setVisible(true);
		communities = new ArrayList<>();

		mailboxes = new ArrayList<>();
		twitters = new ArrayList<>();

		locked = false;
		posts = new ArrayList<>();
		this.init();
	}

	@OPERATION
	void addCommunity(String ownerName, String communityName, String communityType) {
		communities.add(new Community(ownerName, communityName, communityType));

		frame.text_area.append("New community created..\n");

		if (communityType.equals("Community_1")) {
			mailboxes.add(new Mailbox(ownerName));
		}

		if (communityType.equals("Community_2")) {
			twitters.add(new Twitter(ownerName));
		}
		if (communityType.equals("Community_3")) {
			posts.add(new Posts(ownerName));
		}
	}

	@OPERATION
	void joinCommunityOnServer(String communityName, String memberName) {
		for (Community community : communities) {
			if (community.getCommunityName().equals(communityName)) {
				community.addMemember(memberName);
				break;
			}
		}
		frame.text_area.append("Joined community..\n");
	}

	@OPERATION
	void deleteCommunityOnServer(String communityName) {
		int count = 0;
		for (Community community : communities) {
			count++;
			if (community.getCommunityName().equals(communityName)) {
				break;
			}
		}
		communities.remove(count - 1);

		frame.text_area.append("deleted community..\n");
	}

	@OPERATION
	void leaveCommunityOnServer(String communityName) {
		int count = 0;
		for (Community community : communities) {
			count++;
			if (community.getCommunityName().equals(communityName)) {
				break;
			}
		}
		communities.get(count).getMembers().remove(communityName);

		frame.text_area.append("left community..\n");
	}

	@OPERATION
	void getCommunities(OpFeedbackParam<String> res) {

		String result = "";
		for (Community community : communities) {
			result += community.toString() + ",";
		}
		res.set(result);
		frame.text_area.append("Getting communitities...");

	}

	@OPERATION
	void getMembers(OpFeedbackParam<String> res, String communityName) {

		String result = "";
		for (Community community : communities) {

			if (community.getCommunityName().equals(communityName.trim())) {

				for (String member : community.getMembers()) {
					result += member + ",";
				}
			}
		}
		res.set(result);
		frame.text_area.append("Getting memebers for community: "+communityName);

	}

	@OPERATION
	void getMessages(OpFeedbackParam<String> res, String agentName) {

		String result = "";
		for (int i = 0; i < mailboxes.size(); i++) {
			if (mailboxes.get(i).getOwner().equals(agentName)) {
				for (int j = 0; j < mailboxes.get(i).getMessages().size(); j++) {
					result += mailboxes.get(i).getMessages().get(j) + ",";
				}
			}
		}
		System.out.println("the result:" + result);
		res.set(result);
		frame.text_area.append("Getting messages for agent: "+agentName);
	}

	@OPERATION
	void getTweets(OpFeedbackParam<String> res, String agentName) {

		String result = "";
		for (int i = 0; i < twitters.size(); i++) {
			if (twitters.get(i).getOwner().equals(agentName)) {
				for (int j = 0; j < twitters.get(i).getTwitter().size(); j++) {
					result += twitters.get(i).getTwitter().get(j) + ",";
				}
			}
		}
		System.out.println("the result:" + result);
		res.set(result);
		// System.out.println("Getting communitities...");

	}

	@OPERATION
	void getPosts(OpFeedbackParam<String> res, String agentName) {

		String result = "";
		for (int i = 0; i < posts.size(); i++) {
			if (posts.get(i).getOwner().equals(agentName)) {
				for (int j = 0; j < posts.get(i).getPosts().size(); j++) {
					result += posts.get(i).getPosts().get(j) + ",";
				}
			}
		}
		System.out.println("the result:" + result);
		res.set(result);

	}

	@OPERATION
	void upMailBox(String messageContent, String sender, String reciever) {

		for (Mailbox mailbox : mailboxes) {
			if (mailbox.getOwner().equals(reciever)) {

				String mess = "Sender: " + sender + "\n" + "Content: " + messageContent;
				mailbox.getMessages().add(mess);
			}
		}
	}

	@OPERATION
	void upTwitter(String tweetContent, String sender, String reciever) {

		for (Twitter twitter : twitters) {
			if (twitter.getOwner().equals(reciever)) {

				String twt = "Tweet from @" + sender + "\n" + "---->" + tweetContent + "\n";
				twitter.getTwitter().add(twt);
			}
		}
	}

	@OPERATION
	void upPosts(String topic, String content, String sender) {

		for (Posts post : posts) {
//			if (p.getOwner().equals(reciever)) {
				String ps = "Post from " + sender + "\n" + content + "\n";
				post.getPosts().add(ps);
//			}
		}
	}


	@OPERATION
	void lock() {
		await("notLocked");
		locked = true;
	}

	// a guard used by the operation lock
	@GUARD
	boolean notLocked() {
		return !locked;
	}

	// unlock the environment
	@OPERATION
	void unlock() {
		locked = false;
	}

	private class Frame extends JFrame {
		JTextArea text_area;

		public Frame() {
			initComponents();
		}

		private void initComponents() {
			this.setLayout(new GridLayout(1, 1));
			setSize(500, 500);
			text_area = new JTextArea(5, 10);
			add(text_area);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
		}

	}
}
