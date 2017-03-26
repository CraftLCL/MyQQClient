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
		//添加代码，从当前运行的ClientRunStatus类的实例中获取Scoket对象，向服务器发送请求对象。
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
		//添加代码，设置请求业务为“FriendList”，调用sendRequest()发送请求
		Request request=new Request();
		request.setUser(ClientRunStatus.getInstance().getLoginUser());
		request.setRequestServiceName("FriendList");
		sendRequest(request);
	}
}
