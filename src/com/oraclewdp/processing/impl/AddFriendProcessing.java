package com.oraclewdp.processing.impl;

import com.oraclewdp.bean.Response;
import com.oraclewdp.processing.ClientProcessing;
import com.oraclewdp.util.ClientUtil;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.net.Socket;

/**
 * Created by lcl on 2017/3/25.
 * 客户端响应服务端发送过来的关于添加好友的响应
 */
public class AddFriendProcessing implements ClientProcessing {
    @Override
    public void processing(Response response, Socket socket, JFrame frame) {
        if (response.getResponseCode()==Response.ADDFRIEND_SUCCESS){
            JOptionPane.showMessageDialog(null,"添加好友成功");
            ClientUtil.refreshFriend();
        }else if (response.getResponseCode()==Response.ADDFRIEND_FAIL_ISFRIEND){
            JOptionPane.showMessageDialog(null,"你们已经是朋友了");

        }else if (response.getResponseCode()==Response.ADDFRIEND_FAIL){
            JOptionPane.showMessageDialog(null,"该账号不存在无法添加");

        }

    }
}
