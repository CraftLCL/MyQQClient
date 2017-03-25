package com.oraclewdp.client.config;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.oraclewdp.bean.User;
import com.oraclewdp.client.window.MessageWindow;

public class ClientRunStatus {
	public static final Properties SERVERADDRESS = new Properties();
	public static final Properties PROCESSINGNAMES = new Properties();
	public static final Map<String,MessageWindow> MESSAGEWINDOWS = new HashMap<String,MessageWindow>();
	private Socket socket;
	private User loginUser;
	private static ClientRunStatus crs = null;
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public User getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
	}
	private ClientRunStatus(){
		
	}
	public static synchronized ClientRunStatus getInstance(){
		if(ClientRunStatus.crs==null){
			ClientRunStatus.crs = new ClientRunStatus();
		}
		return ClientRunStatus.crs;
	}
	static {
		//��Ӵ��룬����Processing.properties�ļ���PROCESSINGNAMES�����С�
		//��Ӵ��룬����ServerAddress.properties�ļ���SERVERADDRESS�����С�
	}
}
