package com.uip.vo;

public class Uhf {
	int id;
	String uadd;
	String uip;
	String uname;
	String ucont;
	String utime;
	int uzan;
	int uofid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUadd() {
		return uadd;
	}
	public void setUadd(String uadd) {
		this.uadd = uadd;
	}
	public String getUip() {
		return uip;
	}
	public void setUip(String uip) {
		this.uip = uip;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUcont() {
		return ucont;
	}
	public void setUcont(String ucont) {
		this.ucont = ucont;
	}
	public String getUtime() {
		return utime;
	}
	public void setUtime(String utime) {
		this.utime = utime;
	}
	public int getUzan() {
		return uzan;
	}
	public void setUzan(int uzan) {
		this.uzan = uzan;
	}
	public int getUofid() {
		return uofid;
	}
	public void setUofid(int uofid) {
		this.uofid = uofid;
	}
	public Uhf(int id, String uadd, String uip, String uname, String ucont, String utime, int uzan, int uofid) {
		super();
		this.id = id;
		this.uadd = uadd;
		this.uip = uip;
		this.uname = uname;
		this.ucont = ucont;
		this.utime = utime;
		this.uzan = uzan;
		this.uofid = uofid;
	}
	
}
