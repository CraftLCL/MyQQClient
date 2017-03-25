package com.oraclewdp.processing;

import java.net.Socket;

import javax.swing.JFrame;

import com.oraclewdp.bean.Response;

public interface ClientProcessing {
	public void processing(Response response, Socket socket, JFrame frame);
}
