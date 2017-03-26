package com.oraclewdp.client.monitor;

import com.oraclewdp.bean.Request;
import com.oraclewdp.client.config.ClientRunStatus;
import com.oraclewdp.util.ClientUtil;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by lcl on 2017/3/25.
 */
public class FriendWindowMonitor implements WindowListener {
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        Request request = new Request();
        request.setRequestServiceName("Exit");
        request.setUser(ClientRunStatus.getInstance().getLoginUser());
        ClientUtil.sendRequest(request);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
