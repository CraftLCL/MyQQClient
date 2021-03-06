package com.oraclewdp.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable, Comparable<User> {
	private static final long serialVersionUID = 1L;
	private int id;
	private String pwd;
	private String name;
	private int age;
	private String phone;
	private String address;
	private String ip;
	private int port;
	private boolean online;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * 重写toString方法，显示用户在线状态的显示
	 */
	public String toString() {
		String value = this.online ? "在线" : "离线";
		return this.name + "【" + value + "】";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User) {
			User user = (User) obj;
			String ip = this.getIp();
			if (this.getId() == user.getId()) {
				return true;
			}
			if (ip != null && !"".equals(ip)) {
				if (this.getIp().equals(user.getIp())
						&& this.getPort() == user.getPort()) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return super.equals(obj);
	}

	@Override
	public int compareTo(User o) {
		if (this.isOnline() && !o.isOnline()) {
			return 1;
		} else if (this.isOnline() == o.isOnline()) {
			return this.getName().compareTo(o.getName());
		} else {
			return -1;
		}
	}
}
