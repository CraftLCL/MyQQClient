package com.oraclewdp.processing.impl;

import com.oraclewdp.bean.Response;
import com.oraclewdp.bean.User;
import com.oraclewdp.client.config.ClientRunStatus;
import com.oraclewdp.client.window.MessageWindow;
import com.oraclewdp.processing.ClientProcessing;
import com.oraclewdp.util.ClientUtil;

import javax.swing.*;
import java.net.Socket;

/**
 * Created by lcl on 2017/3/26.
 */
public class MessageProcessing implements ClientProcessing {
    @Override
    public void processing(Response response, Socket socket, JFrame frame) {
        User fromUser =response.getFromUser();
        String ipport=fromUser.getIp()+":"+fromUser.getPort();
        MessageWindow messageWindow= ClientRunStatus.MESSAGEWINDOWS.get(ipport);
        if (messageWindow==null){
            messageWindow=new MessageWindow(fromUser);
        }
        messageWindow.getMessageText().append(fromUser.getName()+"˵\n");
        messageWindow.getMessageText().append("    "+response.getMessage());
    }
}
