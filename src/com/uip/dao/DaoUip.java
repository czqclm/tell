package com.uip.dao;

import java.sql.*;

import com.uip.service.IUserFunction;
import com.uip.utils.DBUtil;
import com.uip.vo.Uip;

public class DaoUip implements IUserFunction {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	@Override
	public int addUserip(Uip uip) {
		int i = 0;
			try {
				conn = DBUtil.getConn();
				String sql = "INSERT INTO userip VALUES (null,?,?,?,?)";
				ps =  conn.prepareStatement(sql);
				ps.setString(1, uip.getAdd());
				ps.setString(2, uip.getIsp());
				ps.setString(3, uip.getIp());
				ps.setString(4, uip.getTime());
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
