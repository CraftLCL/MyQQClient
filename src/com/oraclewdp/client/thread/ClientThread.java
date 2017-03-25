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
				//�������л�ȡ�����������ڻ�ȡ�����ڷ������˷��͹����Ķ���
				try {
					InputStream inputStream = socket.getInputStream();
					ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
					Response response=(Response)objectInputStream.readObject();
					String serviceName=response.getResponseServiceName();
					//��������������

					//���������˷��͹�����Response�����ȡ����

					//��ȡ������

					//�ӿͻ�������״̬���л�ȡProperties���󣬲�ȡ����Ӧ�ļ�����Ӧ��ֵ
					//�����ʱ��serviceName��ֵ��Login����ô��ȡ��com.oraclewdp.processing.impl.LoginProcessing
					//��ͨ��Class.forName������ȡ����Ӧ��һ����
					String processingName=ClientRunStatus.PROCESSINGNAMES.getProperty(serviceName);
					Class<?> processingClass=Class.forName(processingName);
					//ͨ��processingClass��newInstance�����������������޲εĹ��췽�������õ�һ��ʵ��
					ClientProcessing clientProcessing =(ClientProcessing) processingClass.newInstance();
					//�����ʵ��ת��ΪClientProcessing����


					//�ɴ˿��Եó�com.oraclewdp.processing.impl.LoginProcessing��Ȼ��ʵ����ClientProcessing�ӿڵ�һ���࣬���Բſ���ǿת
					clientProcessing.processing(response,socket,this.window);


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
