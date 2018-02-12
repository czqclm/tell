package com.uip.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uip.dao.DaoUcont;
import com.uip.vo.Ucont;

/**
 * Servlet implementation class doAddUcont
 */
@WebServlet("/doAddUcont")
public class doAddUcont extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doAddUcont() {
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
		Ucont ut = null;
		request.setCharacterEncoding("utf-8");
		String uadd = request.getParameter("countryPlus");
		String uip = request.getParameter("ip");
		String uname = request.getParameter("userName");
		String ucont = request.getParameter("userText");
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String utime = sdf.format(d);
		ut = new Ucont(0, uadd, uip, uname, ucont, utime,0);
		DaoUcont du = new DaoUcont();
		du.addUcont(ut);
		request.getRequestDispatcher("listServlet").forward(request, response);
	}

}
