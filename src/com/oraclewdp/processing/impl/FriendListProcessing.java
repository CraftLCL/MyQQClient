package com.oraclewdp.processing.impl;

import com.oraclewdp.bean.Response;
import com.oraclewdp.bean.User;
import com.oraclewdp.client.window.FriendWindow;
import com.oraclewdp.processing.ClientProcessing;

import javax.swing.*;
import java.net.Socket;
import java.util.Collections;

/**
 * Created by lcl on 2017/3/26.
 */
public class FriendListProcessing implements ClientProcessing {
    @Override
    public void processing(Response response, Socket socket, JFrame frame) {
        int size=0;
        if (response.getFriendList()!=null){
            Collections.sort(response.getFriendList());
            Collections.reverse(response.getFriendList());
            size=response.getFriendList().size();
        }
        User [] users=new User[size];
        for (int i = 0; i <users.length ; i++) {
            users[i]=response.getFriendList().get(i);
        }
        FriendWindow.friendList.setListData(users);
        FriendWindow.friendList.repaint();

    }
}
