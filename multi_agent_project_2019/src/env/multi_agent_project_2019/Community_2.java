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
//import multi_agent_project_2019.Community_1.Frame2;

public class Community_2 extends GUIArtifact {
	private Frame2 myFrame2;
	void init(String title) {
		myFrame2 = new Frame2();
		myFrame2.setTitle(title);
		linkActionEventToOp(myFrame2.getBtn_tweet(),"sendTweet");
		
		myFrame2.setVisible(true);
		this.init();
	}
    /**
     * @wbp.parser.entryPoint
     */
    @INTERNAL_OPERATION void sendTweet(ActionEvent ev){
    	String tweetContent = myFrame2.getTextField_message().getText().trim();
    	System.out.println("Sending tweet... "+tweetContent);
    	String agent_name = "test_agent";
    	this.signal("cmdSendTweet",tweetContent,agent_name);
    }
	private class Frame2 extends JFrame{
		JTextArea textField_tweet;
		JButton btn_tweet;
		public Frame2() {
			initComponents();
		}

		private void initComponents() {
			getContentPane().setLayout(new FlowLayout());
			setSize(450,500);
			add(new JLabel("Type your tweet:"));
			textField_tweet = new JTextArea();
			textField_tweet.setColumns(10);
			textField_tweet.setRows(5);
			btn_tweet = new JButton("Send tweet");
			//btn_tweet.setBounds(60, 200, 220, 30);
			add(textField_tweet);
			add(btn_tweet);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
		}
		public JButton getBtn_tweet() {
			return btn_tweet;
		}
		public JTextArea getTextField_message() {
			return textField_tweet;
		}
	}
}