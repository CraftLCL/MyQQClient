package com.oraclewdp.util;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import com.oraclewdp.bean.Request;
import com.oraclewdp.bean.Response;
import com.oraclewdp.client.config.ClientRunStatus;

public class ClientUtil {
	public static Response loadResponse(){
		return null;
	}
	public static void sendRequest(Request request){
		//��Ӵ��룬�ӵ�ǰ���е�ClientRunStatus���ʵ���л�ȡScoket����������������������
		OutputStream outputStream=null;
		ObjectOutputStream objectOutputStream=null;
		try {
			outputStream=ClientRunStatus.getInstance().getSocket().getOutputStream();
			objectOutputStream=new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(request);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void refreshFriend(){
		//��Ӵ��룬��������ҵ��Ϊ��FriendList��������sendRequest()��������
				
	}
}
