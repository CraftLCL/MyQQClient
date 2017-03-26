package com.oraclewdp.client.monitor;

import com.oraclewdp.bean.Request;
import com.oraclewdp.bean.User;
import com.oraclewdp.client.config.ClientRunStatus;
import com.oraclewdp.client.window.MessageWindow;
import com.oraclewdp.util.ClientUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lcl on 2017/3/25.
 */
public class MessageButtonMonitor implements ActionListener {
    MessageWindow window;
    User toUser;
    public MessageButtonMonitor(MessageWindow messageWindow, User  toUser) {
        this.window=messageWindow;
        this.toUser=toUser;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("1")){
            this.window.getMessageText().append("Œ“Àµ£∫\n");
            this.window.getMessageText().append(""+this.window.getInputText().getText()+"\n");
            Request request=new Request();
            request.setUser(ClientRunStatus.getInstance().getLoginUser());
            request.setToUser(this.toUser);
            request.setMessage(this.window.getInputText().getText());
            this.window.getInputText().setText("");
            request.setRequestServiceName("Message");
            ClientUtil.sendRequest(request);
        }else if (e.getActionCommand().equals("2")){
            window.dispose();;
        }
    }
}
