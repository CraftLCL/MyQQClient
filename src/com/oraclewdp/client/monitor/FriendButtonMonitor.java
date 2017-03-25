package com.oraclewdp.client.monitor;

import com.oraclewdp.bean.Request;
import com.oraclewdp.bean.User;
import com.oraclewdp.client.config.ClientRunStatus;
import com.oraclewdp.util.ClientUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lcl on 2017/3/25.
 */
public class FriendButtonMonitor implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String friendId= JOptionPane.showInputDialog("请输入你想要添加的好友账号");
        if (friendId!=null&&friendId.equals(ClientRunStatus.getInstance().getLoginUser().getId()+"")){
            JOptionPane.showMessageDialog(null,"你不能添加你自己");
            return;
        }else if (friendId!=null&&friendId.equals("")){
            Request request=new Request();
            request.setRequestServiceName("AddFriend");
            User user=new User();
            user.setId(Integer.parseInt(friendId));
            request.setUser(ClientRunStatus.getInstance().getLoginUser());
            request.setToUser(user);
            ClientUtil.sendRequest(request);
        }
    }
}
