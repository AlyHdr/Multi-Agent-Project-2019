// CArtAgO artifact code for project multi_agent_project_2019

package multi_agent_project_2019;


import java.awt.event.ActionEvent;
import java.util.ArrayList;


import cartago.*;
import cartago.tools.GUIArtifact;

public class Community_1 extends GUIArtifact {
	private MailboxFrame myFrame;
	private ArrayList<String> myMembers;
	void init(String title) {
		myFrame = new MailboxFrame();
		myFrame.setTitle(title);
		linkActionEventToOp(myFrame.getBtn_send_message(),"sendMessage");
		
		myFrame.setVisible(true);
		myMembers = new ArrayList<>();
		this.init();
	}
    @INTERNAL_OPERATION void sendMessage(ActionEvent ev){
    	String messageContent = myFrame.getText_area_message_content().getText().trim();
    	String reciever = (String)myFrame.getCombo_recievers_names().getSelectedItem();
    	this.signal("cmdSendMessage",messageContent,reciever);
    }
    @OPERATION
    void updateMembers(String message) {

    	String members[] = message.split(",");
    	myMembers = new ArrayList<>();
    	myFrame.getCombo_recievers_names().removeAllItems();
    	for (int i = 0; i < members.length; i++) {
			myMembers.add(members[i]);
			myFrame.getCombo_recievers_names().addItem(members[i]);
		}
    	
    }
    @OPERATION
    void updateMessages(String message) {

    	String messages[] = message.split(",");
    	myFrame.getText_area_messages().setText("");
    	for (int i = 0; i < messages.length; i++) {
    		myFrame.getText_area_messages().append(messages[i]);
    	}
    	
    }
}

