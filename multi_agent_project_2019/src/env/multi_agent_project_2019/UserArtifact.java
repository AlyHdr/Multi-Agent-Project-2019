// CArtAgO artifact code for project multi_agent_project_2019

package multi_agent_project_2019;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import cartago.*;
import cartago.tools.GUIArtifact;

public class UserArtifact extends GUIArtifact {
	private FrameUser frameUser;
	private ArrayList<Community> my_communities;
	public void init(String title) {
		frameUser = new FrameUser();
		frameUser.setTitle(title);
		linkActionEventToOp(frameUser.getBtn_create_community(),"createCommunity");
		linkActionEventToOp(frameUser.getBtn_join_community(),"joinCommunity");
		linkActionEventToOp(frameUser.getBtn_leave_communtiy(),"leaveCommunity");
		linkActionEventToOp(frameUser.getBtn_delete_community(),"deleteCommunity");

		my_communities = new ArrayList<>();
		
		frameUser.setVisible(true);
		this.init();
	}
    @INTERNAL_OPERATION void createCommunity(ActionEvent ev){
    	System.out.println("Create Community Command...");
    	String community_name = frameUser.getTextField_create_community_name().getText().trim();
    	if(!community_name.equals("") && !community_name.contains("-") && !community_name.contains(",")) {
    		String communityType = (String)frameUser.getCombo_create_community_type().getSelectedItem();
    		// create community and add it to the list of my communities
    		this.signal("cmd", "createCommunity",community_name,communityType);
    		frameUser.getCombo_delete_available_communities().addItem(community_name);

    	}else {
    		JOptionPane.showMessageDialog(null, "Error in paramters", "Error", JOptionPane.ERROR_MESSAGE);
    	}
    }
    @INTERNAL_OPERATION void joinCommunity(ActionEvent ev){
    	int selected = frameUser.getCombo_join_availble_communities().getSelectedIndex();
    	Community comm = my_communities.get(selected);
    	if(comm.getCommunityType().equals("Community_1")) {
    		this.signal("cmd", "joinCommunity1",comm.getCommunityName(),comm.getCommunityType());
    	}else if(comm.getCommunityType().equals("Community_2")) {
    		this.signal("cmd", "joinCommunity2",comm.getCommunityName(),comm.getCommunityType());
    	}else if(comm.getCommunityType().equals("Community_3")) {
    		this.signal("cmd", "joinCommunity3",comm.getCommunityName(),comm.getCommunityType());	
    	}
    	frameUser.getCombo_leave_availble_communties().addItem(comm.getCommunityName());
    }
    @INTERNAL_OPERATION void leaveCommunity(ActionEvent ev){
    
    	int res = JOptionPane.showConfirmDialog(null, "Are you sure you want to leave ?", "Alert", JOptionPane.YES_NO_OPTION);
    	if(res == JOptionPane.YES_OPTION) {
    		String community_name = ((String)frameUser.getCombo_join_availble_communities().getSelectedItem()).trim();
        	this.signal("cmd", "joinCommunity",community_name);
        	frameUser.getCombo_leave_availble_communties().removeItem((String)community_name);
    	}else {
    		
    	}
    	
    }
    @INTERNAL_OPERATION void deleteCommunity(ActionEvent ev){
    	int res = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete ?", "Alert", JOptionPane.YES_NO_OPTION);
    	if(res == JOptionPane.YES_OPTION) {
    		String community_name = ((String)frameUser.getCombo_delete_available_communities().getSelectedItem()).trim();
    		System.out.println("nameeeeeeeeeeee"+community_name);
        	this.signal("cmd", "deleteCommunity",community_name);
        	frameUser.getCombo_delete_available_communities().removeItem((String)community_name);
    	}else {
    		
    	}
    }

	@OPERATION
	void updateCommunities(String message) {
		String communities[] = message.split(",");
		frameUser.getCombo_join_availble_communities().removeAllItems();
		for (int i = 0; i < communities.length; i++) {
			String attrbs[] = communities[i].split("-");
			if (attrbs.length >2) {
				String comm_name = attrbs[0];
				String comm_type = attrbs[1];
				String comm_owner = attrbs[2];

				frameUser.getCombo_join_availble_communities().addItem(comm_name);

				ArrayList<String> members = new ArrayList<>();

				for (int j = 3; j < attrbs.length; j++) {
					members.add(attrbs[j]);
				}
				Community comm = new Community(comm_owner, comm_name, comm_type, members);
				if (!my_communities.contains(comm)) {
					my_communities.add(comm);
				}
			}
			// System.out.println(comm_name+" "+comm_type+" "+comm_owner);
		}
	}
    
}

