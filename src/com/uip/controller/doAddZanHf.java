package com.uip.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uip.dao.DaoUcont;
import com.uip.dao.DaoUhf;

/**
 * Servlet implementation class doAddZanHf
 */
@WebServlet("/doAddZanHf")
public class doAddZanHf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doAddZanHf() {
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
		request.setCharacterEncoding("utf-8");
		int id = Integer.valueOf(request.getParameter("idZanHf")).intValue();
		int zan = Integer.valueOf(request.getParameter("ZanNumHf")).intValue();
		DaoUhf duf = new DaoUhf();
		duf.UpdataUserHf(id, zan);
		request.getRequestDispatcher("listServlet").forward(request, response);
	}

}
