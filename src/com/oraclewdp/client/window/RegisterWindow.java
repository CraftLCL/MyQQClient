package com.oraclewdp.client.window;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.oraclewdp.client.monitor.RegisterButtonMonitor;

public class RegisterWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private LoginWindow loginWindow;
	
	public LoginWindow getLoginWindow() {
		return loginWindow;
	}

	private JTextField username;
	private JPasswordField password;
	private JPasswordField confirmPassword;
	private JTextField age;
	private JTextField phone;
	private JTextField address;
	
	public JTextField getUsername() {
		return username;
	}

	public void setUsername(JTextField username) {
		this.username = username;
	}

	public JTextField getPassword() {
		return password;
	}

	public void setPassword(JPasswordField password) {
		this.password = password;
	}

	public JTextField getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(JPasswordField confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public JTextField getAge() {
		return age;
	}

	public void setAge(JTextField age) {
		this.age = age;
	}

	public JTextField getPhone() {
		return phone;
	}

	public void setPhone(JTextField phone) {
		this.phone = phone;
	}

	public JTextField getAddress() {
		return address;
	}

	public void setAddress(JTextField address) {
		this.address = address;
	}

	public void launchRegisterWindow(LoginWindow loginWindow){
		this.loginWindow = loginWindow;
		this.setTitle("×¢²á");
		this.setLayout(new FlowLayout());
		this.setSize(240,220);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		JLabel userLabel = new JLabel("êÇ¡¡¡¡³Æ£º");
		JLabel pwdLabel = new JLabel("ÃÜ¡¡¡¡Âë£º");
		JLabel confirmLabel = new JLabel("È·ÈÏÃÜÂë£º");
		JLabel ageLabel = new JLabel("Äê¡¡¡¡Áä£º");
		JLabel phoneLabel = new JLabel("µç¡¡¡¡»°£º");
		JLabel addressLabel = new JLabel("µØ¡¡¡¡Ö·£º");
		Dimension dim = new Dimension(150, 20);
		this.username = new JTextField();
		this.password = new JPasswordField();
		this.confirmPassword = new JPasswordField();
		this.age = new JTextField();;
		this.phone = new JTextField();
		this.address = new JTextField();
		this.username.setPreferredSize(dim);
		this.password.setPreferredSize(dim);
		this.confirmPassword.setPreferredSize(dim);
		this.age.setPreferredSize(dim);
		this.phone.setPreferredSize(dim);
		this.address.setPreferredSize(dim);
		this.add(userLabel);
		this.add(this.username);
		this.add(pwdLabel);
		this.add(this.password);
		this.add(confirmLabel);
		this.add(this.confirmPassword);
		this.add(ageLabel);
		this.add(this.age);
		this.add(phoneLabel);
		this.add(this.phone);
		this.add(addressLabel);
		this.add(this.address);
		RegisterButtonMonitor rbm = new RegisterButtonMonitor(this);
		//RegisterButtonMonitor rbm = new RegisterButtonMonitor();
		JButton registerButton = new JButton("×¢²á");
		registerButton.setActionCommand("1");
		registerButton.addActionListener(rbm);
		this.add(registerButton);
		JButton returnButton = new JButton("·µ»Ø");
		returnButton.setActionCommand("2");
		returnButton.addActionListener(rbm);
		this.add(returnButton);
		this.setIconImage(new ImageIcon(LoginWindow.class.getResource("talk.png")).getImage());
		this.setVisible(true);
	}
}
