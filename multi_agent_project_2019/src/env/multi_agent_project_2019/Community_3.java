// CArtAgO artifact code for project multi_agent_project_2019

package multi_agent_project_2019;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cartago.*;
import cartago.tools.GUIArtifact;


public class Community_3 extends GUIArtifact {
	private ForumFrame myFrame;
	private ArrayList<String> myMembers;
	void init(String title) {
		myFrame = new ForumFrame();
		myFrame.setTitle(title);
		linkActionEventToOp(myFrame.btnPost(),"startForum");
		
		myFrame.setVisible(true);
		myMembers = new ArrayList<>();
		this.init();
	}
	
    @INTERNAL_OPERATION void startForum(ActionEvent ev){
    	String forumTopic = myFrame.getTopicContent().getText().trim();
    	String forumContent = myFrame.getPostContent().getText().trim();
//    	System.out.println("Sending message...asd "+forumContent);

    	this.signal("cmdStartForum",forumTopic, forumContent);
    }

    @OPERATION
    void updateMembers(String message) {

    	String members[] = message.split(",");
    	myMembers = new ArrayList<>();
    	for (int i = 0; i < members.length; i++) {
			myMembers.add(members[i]);
		}
    	
    }
    @OPERATION
    void updateForum(String f) {

    	String forums[] = f.split(",");
    	myFrame.getPostContent().setText("");
    	for (int i = 0; i < forums.length; i++) {
    		myFrame.getText_area_post().append(forums[i]);
    	}
    	
    }
	
	
}

