package com.oraclewdp.processing.impl;

import com.oraclewdp.bean.Response;
import com.oraclewdp.processing.ClientProcessing;
import com.oraclewdp.util.ClientUtil;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.net.Socket;

/**
 * Created by lcl on 2017/3/25.
 * �ͻ�����Ӧ����˷��͹����Ĺ�����Ӻ��ѵ���Ӧ
 */
public class AddFriendProcessing implements ClientProcessing {
    @Override
    public void processing(Response response, Socket socket, JFrame frame) {
        if (response.getResponseCode()==Response.ADDFRIEND_SUCCESS){
            JOptionPane.showMessageDialog(null,"��Ӻ��ѳɹ�");
            ClientUtil.refreshFriend();
        }else if (response.getResponseCode()==Response.ADDFRIEND_FAIL_ISFRIEND){
            JOptionPane.showMessageDialog(null,"�����Ѿ���������");

        }else if (response.getResponseCode()==Response.ADDFRIEND_FAIL){
            JOptionPane.showMessageDialog(null,"���˺Ų������޷����");

        }

    }
}
