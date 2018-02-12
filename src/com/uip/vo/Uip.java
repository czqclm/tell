package com.uip.vo;

public class Uip {
	String add;
	String isp;
	String ip;
	String time;
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getIsp() {
		return isp;
	}
	public void setIsp(String isp) {
		this.isp = isp;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Uip(String add, String isp, String ip, String time) {
		super();
		this.add = add;
		this.isp = isp;
		this.ip = ip;
		this.time = time;
	}
	public Uip() {
		super();
	}
	@Override
	public String toString() {
		return "Uip [add=" + add + ", isp=" + isp + ", ip=" + ip + ", time=" + time + "]";
	}

	
}
