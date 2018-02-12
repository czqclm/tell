package com.uip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.uip.utils.DBUtil;
import com.uip.vo.Ucont;
import com.uip.vo.Uhf;

public class DaoUhf {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public int addUhf(Uhf uhf) {
		int i = 0;
		try {
			conn = DBUtil.getConn();
			String sql = "INSERT INTO userreply VALUES (null,?,?,?,?,?,?,?)";
			ps =  conn.prepareStatement(sql);
			ps.setString(1, uhf.getUadd());
			ps.setString(2, uhf.getUip());
			ps.setString(3, uhf.getUname());
			ps.setString(4, uhf.getUcont());
			ps.setString(5, uhf.getUtime());
			ps.setInt(6, uhf.getUzan());
			ps.setInt(7, uhf.getUofid());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(conn, ps, rs);
		}
	return i;
	}
	
	
	public List<Uhf> FindAllUserHf() {
		List<Uhf> list = new ArrayList<Uhf>();
		try {
			conn = DBUtil.getConn();
			String sql = "select * from userreply";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String uadd = rs.getString(2);
				String uip = rs.getString(3);
				String uname = rs.getString(4);
				String ucont = rs.getString(5);
				String utime = rs.getString(6);
				int uzan = rs.getInt(7);
				int uofid = rs.getInt(8);
				
				Uhf uhf = new Uhf(id, uadd, uip, uname, ucont, utime, uzan,uofid);
				
				list.add(uhf);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(conn, ps, rs);
		}
		
		return list;
	}
	
	public int UpdataUserHf(int id,int zan) {
		int i = 0;
		try {
			conn = DBUtil.getConn();
			String sql = "UPDATE userreply SET "
					+ "uzan = ? "
					+ "WHERE id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, zan);
			ps.setInt(2, id);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(conn, ps, rs);
		}
		return i;
	}


	
}
