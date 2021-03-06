/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multi_agent_project_2019;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

/**
 *
 * 
 */
public class ForumFrame extends javax.swing.JFrame {

    /**
     * Creates new form for Forum
     */
    public ForumFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        text_area_post_content = new javax.swing.JTextArea();
        btnPost = new javax.swing.JButton();
        btnPost.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        text_area_forum_posts = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        btnClear = new javax.swing.JButton();
        btnClear.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        
        btnClear.setVisible(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Post a Forum");

        text_area_post_content.setColumns(20);
        text_area_post_content.setRows(5);
        jScrollPane1.setViewportView(text_area_post_content);

        btnPost.setText("Post");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Forum Posts");

        text_area_forum_posts.setColumns(20);
        text_area_forum_posts.setRows(5);
        jScrollPane2.setViewportView(text_area_forum_posts);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnClear.setText("Clear Messages");
        
        JLabel lblTopic = new JLabel("Topic");
        
        text_field_topic_content = new JTextField();
        text_field_topic_content.setColumns(10);
        
        JLabel lblPost = new JLabel("Post");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(37)
        					.addComponent(btnPost, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(lblPost))
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel1)))
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(lblTopic)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(text_field_topic_content, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(35)
        					.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(7)
        					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(27)
        							.addComponent(jLabel3))
        						.addGroup(layout.createSequentialGroup()
        							.addGap(42)
        							.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)))))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel1)
        						.addComponent(jLabel3))
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
        							.addGap(26)
        							.addComponent(btnClear)
        							.addContainerGap(56, Short.MAX_VALUE))
        						.addGroup(layout.createSequentialGroup()
        							.addGap(21)
        							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        								.addComponent(lblTopic, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
        								.addComponent(text_field_topic_content, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        							.addGap(18)
        							.addComponent(lblPost)
        							.addGap(18)
        							.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
        							.addComponent(btnPost)
        							.addGap(30))))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
        					.addContainerGap())))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public javax.swing.JButton getBtn_clear_messages() {
		return btnClear;
	}
    public javax.swing.JButton btnPost() {
		return btnPost;
	}
    public javax.swing.JTextField getTopicContent() {
		return text_field_topic_content;
	}
    public javax.swing.JTextArea getPostContent() {
		return text_area_post_content;
	}
    public javax.swing.JTextArea getText_area_post() {
		return text_area_forum_posts;
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnPost;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea text_area_post_content;
    private javax.swing.JTextArea text_area_forum_posts;
    private JTextField text_field_topic_content;
}
