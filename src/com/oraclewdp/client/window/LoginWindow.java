package com.oraclewdp.client.window;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.oraclewdp.client.monitor.LoginButtonMonitor;

public class LoginWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField userid;
	private JPasswordField password;
	
	public JTextField getUserid() {
		return userid;
	}
	public JPasswordField getPassword() {
		return password;
	}
	public void launchLoginWindow(){
		this.setLayout(new FlowLayout());
		this.setTitle("��¼");
		this.setSize(240,120);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		JLabel userLabel = new JLabel("�ʡ��ţ�");
		JLabel pwdLabel = new JLabel("�ܡ��룺");
		this.add(userLabel);
		Dimension dim = new Dimension(160, 20);
		this.userid = new JTextField();
		this.userid.setPreferredSize(dim);
		this.add(this.userid);
		this.add(pwdLabel);
		this.password = new JPasswordField();
		this.password.setPreferredSize(dim);
		this.add(this.password);
		LoginButtonMonitor lbm = new LoginButtonMonitor(this);
		JButton loginButton = new JButton("��¼");
		loginButton.setActionCommand("1");
		loginButton.addActionListener(lbm);
		JButton registerButton = new JButton("ע��");
		registerButton.setActionCommand("2");
		registerButton.addActionListener(lbm);
		this.add(loginButton);
		this.add(registerButton);
		this.setIconImage(new ImageIcon(LoginWindow.class.getResource("talk.png")).getImage());
		this.setVisible(true);
	}
	public static void main(String[] args) {
		LoginWindow lw = new LoginWindow();
		lw.launchLoginWindow();
	}
	
}
