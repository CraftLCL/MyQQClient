package com.oraclewdp.client.monitor;

import com.oraclewdp.bean.Request;
import com.oraclewdp.bean.User;
import com.oraclewdp.client.config.ClientRunStatus;
import com.oraclewdp.client.thread.ClientThread;
import com.oraclewdp.client.window.LoginWindow;
import com.oraclewdp.client.window.RegisterWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by lcl on 2017/3/25.
 */
public class LoginButtonMonitor implements ActionListener{
    private LoginWindow loginWindow;
    public LoginButtonMonitor(LoginWindow loginWindow){
        this.loginWindow=loginWindow;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int command=Integer.parseInt(e.getActionCommand());
        switch (command){
            case 1:
                String ip= ClientRunStatus.SERVERADDRESS.getProperty("ip");
                int port=Integer.parseInt(ClientRunStatus.SERVERADDRESS.getProperty("port"));
                try {
                    Socket socket=new Socket(ip,port);
                    Request request=new Request();
                    request.setRequestServiceName("Login");

                    User user=new User();
                    user.setId(Integer.parseInt(this.loginWindow.getUserid().getText()));
                    user.setPwd(this.loginWindow.getPassword().getText());
                    request.setUser(user);

                    OutputStream outputStream=socket.getOutputStream();
                    ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
                    objectOutputStream.writeObject(request);

                    ClientThread clientThread=new ClientThread(socket,this.loginWindow);
                    Thread thread=new Thread(clientThread);
                    thread.start();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                break;
            case 2:
                this.loginWindow.setVisible(false);
                RegisterWindow registerWindow=new RegisterWindow();
                registerWindow.launchRegisterWindow(this.loginWindow);
                break;

        }
    }
}
