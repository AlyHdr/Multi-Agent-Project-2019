// CArtAgO artifact code for project multi_agent_project_2019

package multi_agent_project_2019;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import cartago.*;
import cartago.tools.GUIArtifact;

public class UserArtifact extends GUIArtifact {
	private FrameUser frameUser;
	public void init(String title) {
		frameUser = new FrameUser();
		frameUser.setTitle(title);
		linkActionEventToOp(frameUser.getBtn_create_community(),"createCommunity");
		linkActionEventToOp(frameUser.getBtn_join_community(),"joinCommunity");
		linkActionEventToOp(frameUser.getBtn_leave_communtiy(),"leaveCommunity");
		linkActionEventToOp(frameUser.getBtn_delete_community(),"deleteCommunity");

		frameUser.setVisible(true);
		this.init();
	}
    @INTERNAL_OPERATION void createCommunity(ActionEvent ev){
    	System.out.println("Create Community Command...");
    	String community_name = frameUser.getTextField_create_community_name().getText().trim();
    	if(!community_name.equals("")) {
    		String communityType = (String)frameUser.getCombo_create_community_type().getSelectedItem();
    		// create community and add it to the table of my communities
    		switch(communityType) {
    			case "Community_1":{
    				System.out.println("User created a community of type "+communityType+" and it's name is\" "+community_name+"\"");
    				// do the work to create the new artificat
    				break;
    			}
    			case "Community_2":{
    				System.out.println("User created a community of type "+communityType);
    				// do the work to create the new artificat
    				break;
    			}case "Community_3":{
    				System.out.println("User created a community of type "+communityType);
    				// do the work to create the new artificat
    				break;
    			}
    		}
    	}
    }
    @INTERNAL_OPERATION void joinCommunity(ActionEvent ev){
    	System.out.println("Join Community Command...");
    }
    @INTERNAL_OPERATION void leaveCommunity(ActionEvent ev){
    	System.out.println("Leave Community Command...");
    }
    @INTERNAL_OPERATION void deleteCommunity(ActionEvent ev){
    	System.out.println("Delete Community Command...");
    }
    
}

