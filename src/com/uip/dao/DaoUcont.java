package com.uip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.uip.utils.DBUtil;
import com.uip.vo.Ucont;

public class DaoUcont {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public int addUcont(Ucont ut) {
		int i = 0;
		try {
			conn = DBUtil.getConn();
			String sql = "INSERT INTO usercont VALUES (null,?,?,?,?,?,?)";
			ps =  conn.prepareStatement(sql);
			ps.setString(1, ut.getUadd());
			ps.setString(2, ut.getUip());
			ps.setString(3, ut.getUname());
			ps.setString(4, ut.getUcont());
			ps.setString(5, ut.getUtime());
			ps.setInt(6, ut.getUzan());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(conn, ps, rs);
		}
	return i;
	}
	
	
	public List<Ucont> FindAllUser() {
		List<Ucont> list = new ArrayList<Ucont>();
		try {
			conn = DBUtil.getConn();
			String sql = "select * from usercont";
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
				
				Ucont ut = new Ucont(id, uadd, uip, uname, ucont, utime, uzan);
				
				list.add(ut);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(conn, ps, rs);
		}
		
		return list;
	}
	
	public List<Ucont> FindAllUserDESC() {
		List<Ucont> list = new ArrayList<Ucont>();
		try {
			conn = DBUtil.getConn();
			String sql = "select * from usercont ORDER BY uzan DESC";
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
				
				Ucont ut = new Ucont(id, uadd, uip, uname, ucont, utime, uzan);
				
				list.add(ut);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(conn, ps, rs);
		}
		
		return list;
	}
	
	public int UpdataUser(int id,int zan) {
		int i = 0;
		try {
			conn = DBUtil.getConn();
			String sql = "UPDATE usercont SET "
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
