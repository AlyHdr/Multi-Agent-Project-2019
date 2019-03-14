// CArtAgO artifact code for project multi_agent_project_2019

package multi_agent_project_2019;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import cartago.*;
import cartago.tools.GUIArtifact;

public class Community_1 extends GUIArtifact {
	private Frame myFrame;
	void init(String title) {
		myFrame = new Frame();
		myFrame.setTitle(title);
		linkActionEventToOp(myFrame.getBtn_send(),"sendMessage");
		
		myFrame.setVisible(true);
		this.init();
	}
    @INTERNAL_OPERATION void sendMessage(ActionEvent ev){
    	String messageContent = myFrame.getTextField_message().getText().trim();
    	System.out.println("Sending message...asd "+messageContent);
    	String agent_name = "test_agent";
    	this.signal("cmdSendMessage",messageContent,agent_name);
    }
	private class Frame extends JFrame{
		JTextField textField_message;
		JButton btn_send;
		public Frame() {
			initComponents();
		}

		private void initComponents() {
			this.setLayout(new FlowLayout());
			setSize(300,300);
			add(new JLabel("Type message:"));
			textField_message = new JTextField(20);
			btn_send = new JButton("Send Message");
			add(textField_message);
			add(btn_send);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
		}
		public JButton getBtn_send() {
			return btn_send;
		}
		public JTextField getTextField_message() {
			return textField_message;
		}
	}
}

