package com.oraclewdp.processing.impl;

import com.oraclewdp.bean.Response;
import com.oraclewdp.processing.ClientProcessing;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.net.Socket;

/**
 * Created by lcl on 2017/3/25.
 */
public class AddFriendProcessing implements ClientProcessing {
    @Override
    public void processing(Response response, Socket socket, JFrame frame) {
        if (response.getResponseCode()==Response.ADDFRIEND_SUCCESS);

    }
}
