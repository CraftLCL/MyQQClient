package com.oraclewdp.client.window;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import com.oraclewdp.bean.User;
import com.oraclewdp.client.config.ClientRunStatus;
import com.oraclewdp.client.monitor.FriendButtonMonitor;
import com.oraclewdp.client.monitor.FriendMouseMonitor;
import com.oraclewdp.client.monitor.FriendWindowMonitor;
import com.oraclewdp.util.ClientUtil;

public class FriendWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final JList<User> friendList = new JList<User>();
	
	public FriendWindow(JFrame frame) {
		frame.dispose();
		this.setTitle("»¶Ó­µÇÂ¼¡¾" + ClientRunStatus.getInstance().getLoginUser().getName() + "¡¿");
		this.setSize(200, 500);
		this.addWindowListener(new FriendWindowMonitor());
		FriendWindow.friendList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		FriendWindow.friendList.addMouseListener(new FriendMouseMonitor());
		this.add(friendList);
		JButton addFriendButton = new JButton("Ìí¼ÓºÃÓÑ");
		addFriendButton.addActionListener(new FriendButtonMonitor());
		this.add(addFriendButton, BorderLayout.SOUTH);
		this.setLocationRelativeTo(null);
		ClientUtil.refreshFriend();
		this.setVisible(true);
	}
}
