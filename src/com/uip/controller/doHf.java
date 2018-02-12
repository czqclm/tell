package com.uip.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uip.dao.DaoUhf;
import com.uip.vo.Uhf;

/**
 * Servlet implementation class doHf
 */
@WebServlet("/doHf")
public class doHf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doHf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Uhf uhf = null;
		request.setCharacterEncoding("utf-8");
		String uadd = request.getParameter("countryPlus");
		String uip = request.getParameter("ip");
		String uname = request.getParameter("userNameHf");
		String ucont = request.getParameter("textHf");
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String utime = sdf.format(d);
		int uofid = Integer.valueOf(request.getParameter("hfId"));
		uhf = new Uhf(0, uadd, uip, uname, ucont, utime, 0, uofid);
		DaoUhf duf = new DaoUhf();
		duf.addUhf(uhf);
		request.getRequestDispatcher("listServlet").forward(request, response);
	}

}
