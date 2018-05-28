package com.kh.mybatis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.model.service.MybatisService;
import com.kh.mybatis.model.service.MybatisServiceImpl;

/**
 * Servlet implementation class StudentDeleteOneServlet
 */
@WebServlet("/student/deleteStudent.do")
public class StudentDeleteOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MybatisService mybatisService = new MybatisServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDeleteOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int studentNo = 0;
		try {
			studentNo = Integer.parseInt(request.getParameter("no"));			
		} catch(NumberFormatException e) {
			
		}
		
		int result = mybatisService .deleteStudentOne(studentNo);
		
		response.setContentType("text/html; charset=utf-8");
		request.setAttribute("deleteResult", result);
		request.getRequestDispatcher("/WEB-INF/views/mybatis/selectOne.jsp").forward(request, response);;
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
