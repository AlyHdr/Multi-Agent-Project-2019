// CArtAgO artifact code for project multi_agent_project_2019

package multi_agent_project_2019;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cartago.*;
import cartago.tools.GUIArtifact;


public class Community_3 extends GUIArtifact {
	private Frame myFrame;
	void init(String title) {
		myFrame = new Frame();
		myFrame.setTitle(title);
		linkActionEventToOp(myFrame.getBtn_send(),"postForum");
		
		myFrame.setVisible(true);
		this.init();
	}
	
    @INTERNAL_OPERATION void postForum(ActionEvent ev){
    	String forumTopic = myFrame.getTopic().getText().trim();
    	String forumContent = myFrame.getContent().getText().trim();
    	System.out.println("Sending message...asd "+forumContent);
//    	String agent_name = "test_agent";
    	this.signal("cmdPostForum",forumTopic, forumContent);
    }
    
	private class Frame extends JFrame{
		JTextField textFiled_topic;
		JTextArea textArea_content;
		JButton btn_submit;
		public Frame() {
			initComponents();
		}

		private void initComponents() {
			this.setLayout(new FlowLayout());
			setSize(300,400);
			add(new JLabel("Type topic:"));
			textFiled_topic = new JTextField(20);
			add(textFiled_topic);
			add(new JLabel("Type content:"));
			textArea_content = new JTextArea();
			textArea_content.setColumns(10);
			textArea_content.setRows(5);
			add(textArea_content);
			
			btn_submit = new JButton("Post");
			add(btn_submit);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
		}
		
		public JButton getBtn_send() {
			return btn_submit;
		}
		public JTextField getTopic() {
			return textFiled_topic;
		}
		public JTextArea getContent() {
			return textArea_content;
		}
	}
}

