package com.kh.mybatis.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.model.service.MybatisService;
import com.kh.mybatis.model.service.MybatisServiceImpl;

/**
 * Servlet implementation class StudentMapEnrollEndServlet
 */
@WebServlet("/student/studentMapEnrollEnd.do")
public class StudentMapEnrollEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MybatisService mybatisService = new MybatisServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentMapEnrollEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		//2. 파라미터 핸들링
		String studentName = request.getParameter("studentName");
		String studentTel = request.getParameter("studentTel");
		String studentEmail = request.getParameter("studentEmail");
		String studentAddr = request.getParameter("studentAddr");
		
		//3. 업무로직처리
		Map <String, String> map = new HashMap<>();
		map.put("studentName", studentName);
		map.put("studentTel", studentTel);
		map.put("studentEmail", studentEmail);
		map.put("studentAddr", studentAddr);
		
		int result = mybatisService .insertStudent(map);
		
		String msg = result>0?"<h2>학생등록성공</h2>":"<h2>학생등록실패</h2>";
		
		response.getWriter().append("Served at: ").append(request.getContextPath()).append(msg);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
