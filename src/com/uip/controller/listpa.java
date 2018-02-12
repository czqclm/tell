package com.uip.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uip.dao.DaoUcont;
import com.uip.dao.DaoUhf;
import com.uip.vo.Ucont;
import com.uip.vo.Uhf;

/**
 * Servlet implementation class listpa
 */
@WebServlet("/listpa")
public class listpa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listpa() {
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
		DaoUcont du = new DaoUcont();
		List<Ucont> list = du.FindAllUserDESC();
		request.setAttribute("userList", list);
		DaoUhf duf = new DaoUhf();
		List<Uhf> list1 = duf.FindAllUserHf();
		request.setAttribute("userListHf", list1);
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
