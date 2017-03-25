package com.oraclewdp.client.window;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.oraclewdp.bean.User;
import com.oraclewdp.client.config.ClientRunStatus;
import com.oraclewdp.client.monitor.MessageButtonMonitor;

public class MessageWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextArea messageText;
	private JTextArea inputText;
	private JButton closeButton;
	private JButton sendButton;
	
	public JTextArea getMessageText() {
		return messageText;
	}
	public void setMessageText(JTextArea messageText) {
		this.messageText = messageText;
	}
	public JTextArea getInputText() {
		return inputText;
	}
	public void setInputText(JTextArea inputText) {
		this.inputText = inputText;
	}
	public MessageWindow(User user){
		ClientRunStatus.MESSAGEWINDOWS.put(user.getIp()+":"+user.getPort(), this);
		this.setTitle("正在与【"+user.getId()+"】的用户聊天,IP为【"+user.getIp()+":"+user.getPort()+"】");
		this.setSize(500, 400);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel top = new JPanel();
		JPanel middle = new JPanel();
		JPanel bottom = new JPanel();
		top.setPreferredSize(new Dimension(480, 190));
		middle.setPreferredSize(new Dimension(480, 90));
		bottom.setPreferredSize(new Dimension(480, 120));
		this.messageText = new JTextArea();
		this.messageText.setPreferredSize(new Dimension(480, 190));
		this.messageText.setEditable(false);
		top.add(this.messageText);
		
		this.inputText = new JTextArea();
		this.inputText.setPreferredSize(new Dimension(480, 90));
		middle.add(this.inputText);
		
		this.closeButton = new JButton("关闭");
		this.closeButton.setActionCommand("2");
		this.sendButton = new JButton("发送");
		this.sendButton.setActionCommand("1");
		MessageButtonMonitor mbm = new MessageButtonMonitor(this,user);
		this.closeButton.addActionListener(mbm);
		this.sendButton.addActionListener(mbm);
		bottom.add(this.closeButton);
		bottom.add(this.sendButton);
//		top.setBackground(Color.RED);
//		middle.setBackground(Color.GREEN);
//		bottom.setBackground(Color.blue);
		this.add(top);
		this.add(middle);
		this.add(bottom);
		this.setVisible(true);
	}
	public static void main(String[] args) {
//		new MessageWindow();
	}
}
