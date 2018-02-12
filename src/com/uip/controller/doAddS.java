package com.uip.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uip.dao.DaoUip;
import com.uip.service.IUserFunction;
import com.uip.vo.Uip;

/**
 * Servlet implementation class doAddS
 */
@WebServlet("/doAddS")
public class doAddS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doAddS() {
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
		Uip uip = null;
		request.setCharacterEncoding("utf-8");
		String add = request.getParameter("countryPlus");
		String isp = request.getParameter("isp");
		String ip = request.getParameter("ip");
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String utime = sdf.format(d);
		uip = new Uip(add, isp, ip,utime);
		IUserFunction iu = new DaoUip();
		iu.addUserip(uip);
		request.getRequestDispatcher("listServlet").forward(request, response);
	}

}
