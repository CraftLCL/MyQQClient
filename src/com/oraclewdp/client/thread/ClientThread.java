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

				//��������������

				//���������˷��͹�����Response�����ȡ����

				//��ȡ������

				//�ӿͻ�������״̬���л�ȡProperties���󣬲�ȡ����Ӧ�ļ�����Ӧ��ֵ
				//�����ʱ��serviceName��ֵ��Login����ô��ȡ��com.oraclewdp.processing.impl.LoginProcessing
				//��ͨ��Class.forName������ȡ����Ӧ��һ����
				
				//ͨ��processingClass��newInstance�����������������޲εĹ��췽�������õ�һ��ʵ��
				
				//�����ʵ��ת��ΪClientProcessing����
				
				//�ɴ˿��Եó�com.oraclewdp.processing.impl.LoginProcessing��Ȼ��ʵ����ClientProcessing�ӿڵ�һ���࣬���Բſ���ǿת

			}
	
	}
	public void shutDown(){
		this.runnable = true;
	}

}
