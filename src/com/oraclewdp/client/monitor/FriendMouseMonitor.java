package com.oraclewdp.client.monitor;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;

import com.oraclewdp.bean.User;
import com.oraclewdp.client.window.MessageWindow;


public class FriendMouseMonitor implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2){
			User user = (User) ((JList<?>)e.getSource()).getSelectedValue();
			if(user.isOnline()){
				new MessageWindow(user);
			}
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
