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

public class ServerArtifact extends GUIArtifact{
	private Frame frame;
	private ArrayList<Community> communities; 
	public void init(String title) {
		frame = new Frame();
		frame.setTitle(title);
		frame.setVisible(true);
		communities = new ArrayList<>();
		communities.add(new Community("Ali", "my community", "Community_1"));
		this.init();
	}

	@OPERATION
	void addCommunity(String ownerName,String communityName,String communityType) {
		communities.add(new Community(ownerName,communityName, communityType));
		
		frame.text_area.append("New community created..\n");
		frame.text_area.append(communities.toString());
	}
	@OPERATION
	void joinCommunityOnServer(String communityName,String memberName) {
		for(Community community:communities) {
			if(community.getCommunityName().equals(communityName)) {
				community.addMemember(memberName);
				break;
			}
		}
		frame.text_area.append("Joined community..\n");
	}
	@OPERATION
	void deleteCommunityOnServer(String communityName) {
		int count = 0;
		for(Community community:communities) {
			count++;
			if(community.getCommunityName().equals(communityName)) {
				break;
			}
		}
		communities.remove(count-1);
		/*if(communities.get(count-1).getOwnerName().equals(ownerName)) {
			communities.remove(count);
		}else {
			// can't happen since user can delete only his communities
			System.out.println("Not owner can't delete");
		}*/
		
		frame.text_area.append("Joined community..\n");
	}
	@OPERATION
	void leaveCommunityOnServer(String communityName) {
		int count = 0;
		for(Community community:communities) {
			count++;
			if(community.getCommunityName().equals(communityName)) {
				break;
			}
		}
		communities.get(count).getMembers().remove(communityName);
		
		frame.text_area.append("left community..\n");
	}
	@OPERATION
	void getCommunities(OpFeedbackParam<String> res){
		
		String result="";
		for(Community community:communities) {
			result+=community.toString()+",";
		}
		res.set(result);
		//System.out.println("Getting communitities...");

	}
	private class Frame extends JFrame{
		JTextArea text_area;
		public Frame() {
			initComponents();
		}

		private void initComponents() {
			this.setLayout(new GridLayout(1,1));
			setSize(500,500);
			text_area = new JTextArea(5,10);
			add(text_area);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
		}
		
	}
}

