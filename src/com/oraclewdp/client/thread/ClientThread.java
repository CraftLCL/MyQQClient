package com.oraclewdp.client.thread;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

import javax.swing.JFrame;

import com.oraclewdp.bean.Response;
import com.oraclewdp.client.config.ClientRunStatus;
import com.oraclewdp.processing.ClientProcessing;

public class ClientThread implements Runnable {
	
	private Socket socket;
	private boolean runnable;
	private JFrame window;
	public ClientThread(Socket socket,JFrame window){
		this.socket = socket;
		this.window = window;
	}
	@Override
	public void run() {
		
			while(!runnable){
				//从连接中获取输入流，用于获取来自于服务器端发送过来的对象
				try {
					InputStream inputStream = socket.getInputStream();
					ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
					Response response=(Response)objectInputStream.readObject();
					String serviceName=response.getResponseServiceName();
					//创建对象输入流

					//将服务器端发送过来的Response对象读取出来

					//获取服务名

					//从客户端运行状态类中获取Properties对象，并取出对应的键的相应的值
					//如果此时的serviceName的值是Login，那么将取出com.oraclewdp.processing.impl.LoginProcessing
					//并通过Class.forName方法获取到对应的一个类
					String processingName=ClientRunStatus.PROCESSINGNAMES.getProperty(serviceName);
					Class<?> processingClass=Class.forName(processingName);
					//通过processingClass的newInstance方法，调用这个类的无参的构造方法，并得到一个实例
					ClientProcessing clientProcessing =(ClientProcessing) processingClass.newInstance();
					//将这个实例转型为ClientProcessing类型


					//由此可以得出com.oraclewdp.processing.impl.LoginProcessing必然是实现了ClientProcessing接口的一个类，所以才可以强转
					clientProcessing.processing(response,socket,this.window);
					//this.shutDown();

				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				}

			}
	
	}
	public void shutDown(){
		this.runnable = true;
	}

}
