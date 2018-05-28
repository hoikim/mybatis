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
 * Servlet implementation class MybatisTestServlet2
 */
@WebServlet("/test2.do")
public class MybatisTestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MybatisService mybatisService = new MybatisServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MybatisTestServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8"); 
		
		//파라미터 핸들링
		String name = request.getParameter("name");
		
		//업무로직
		int result = mybatisService.insertStudent(name);
		String msg = result>0?"test2성공!":"test2실패!";
		
		response.getWriter().append("Served at: ")
							.append(request.getContextPath())
							.append("<br />"+msg).append("<br />"+name);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
