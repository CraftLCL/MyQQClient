package com.oraclewdp.client.monitor;

import com.oraclewdp.bean.Request;
import com.oraclewdp.bean.Response;
import com.oraclewdp.bean.User;
import com.oraclewdp.client.config.ClientRunStatus;
import com.oraclewdp.client.window.MessageDialog;
import com.oraclewdp.client.window.RegisterWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

/**
 * Created by lcl on 2017/3/25.
 */
public class RegisterButtonMonitor implements ActionListener{
    private RegisterWindow registerWindow;
    public RegisterButtonMonitor(RegisterWindow registerWindow){
        this.registerWindow=registerWindow;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int command=Integer.parseInt(e.getActionCommand());
        switch (command){
            case 1:
                if(registerWindow.getPassword().getText().equals(registerWindow.getConfirmPassword().getText())){

                    String name=registerWindow.getUsername().getText();
                    String age=registerWindow.getAge().getText();
                    String pwd=registerWindow.getPassword().getText();
                    String phone=registerWindow.getPhone().getText();
                    String address=registerWindow.getAddress().getText();

                    if(name==null||"".equals(null)){
                        new MessageDialog(true,"提示信息",
                                "昵称为必填",registerWindow);
                        return;
                    }
                    else if (pwd==null||"".equals(pwd))
                    {
                        new MessageDialog(true,"提示信息",
                                "密码为必填",registerWindow);
                        return;

                    }
                    else if (age==null||"".equals(age))
                    {
                        new MessageDialog(true,"提示信息",
                                "年龄为必填",registerWindow);
                        return;

                    }
                    else {
                        User user = new User();

                        user.setName(name);
                        user.setAge(Integer.parseInt(age));
                        user.setPwd(pwd);
                        user.setPhone(phone);
                        user.setAddress(address);

                        Socket socket=null;


                        String ip= ClientRunStatus.SERVERADDRESS.getProperty("ip");
                        int port=Integer.parseInt(ClientRunStatus.SERVERADDRESS.getProperty("port"));
                        try {
                            socket=new Socket(ip,port);
                            Request request=new Request();
                            request.setRequestServiceName("Register");
                            request.setUser(user);
                            OutputStream outputStream=socket.getOutputStream();
                            ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
                            objectOutputStream.writeObject(request);


                            InputStream inputStream=socket.getInputStream();
                            ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
                            Response response=(Response)objectInputStream.readObject();
                            if(response.getResponseCode()==Response.REGISTER_SUCCESS){
                                new MessageDialog(true,"注册成功","你的账号为【"+response.getFromUser().getId()+"】，请牢记！！！",registerWindow);
                            }

                        } catch (IOException e1) {
                            e1.printStackTrace();
                        } catch (ClassNotFoundException e1) {
                            e1.printStackTrace();
                        }
                        finally {
                            if (socket!=null){
                                try {
                                    socket.close();
                                } catch (IOException e1) {
                                    e1.printStackTrace();
                                }
                            }
                        }

                    }

                } else {
                    new MessageDialog(true,"提示信息","两次密码输入不一致",registerWindow);
                    return;
                }
                break;
            case 2:
                registerWindow.dispose();;
                registerWindow.getLoginWindow().setVisible(true);
                break;

        }
    }
}
