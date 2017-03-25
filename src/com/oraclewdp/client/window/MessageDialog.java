package com.oraclewdp.client.window;

import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MessageDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private JLabel messageLabel;
	public MessageDialog(boolean isModel,String title,String message,JFrame frame){
		this.setLayout(new GridLayout(1,1));
		this.setTitle(title);
		this.setModal(isModel);
		this.messageLabel = new JLabel(message);
		this.add(messageLabel);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(frame);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}
}
