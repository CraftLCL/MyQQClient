package com.oraclewdp.processing.impl;

import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.oraclewdp.bean.Response;
import com.oraclewdp.client.config.ClientRunStatus;
import com.oraclewdp.client.window.FriendWindow;
import com.oraclewdp.processing.ClientProcessing;

public class LoginProcessing implements ClientProcessing {

	public void processing(Response response, Socket socket, JFrame frame) {
		if(response.getResponseCode()==Response.LOGIN_SUCCESS){
			JOptionPane.showMessageDialog(null, "��¼�ɹ�");

			//����洢��socket
			ClientRunStatus.getInstance().setSocket(socket);




			ClientRunStatus.getInstance().setLoginUser(response.getFromUser());
			new FriendWindow(frame);
		}else if (response.getResponseCode()==Response.LOGIN_PASSWORD_ERROR){
			
			JOptionPane.showMessageDialog(null, "�������");
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if (response.getResponseCode()==Response.LOGIN_USERNAME_INVALID){
			JOptionPane.showMessageDialog(null, "�û�������");
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
