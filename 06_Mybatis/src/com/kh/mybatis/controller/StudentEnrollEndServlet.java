package com.kh.mybatis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.model.service.MybatisService;
import com.kh.mybatis.model.service.MybatisServiceImpl;
import com.kh.mybatis.model.vo.Student;

/**
 * Servlet implementation class StudentEnrollEndServlet
 */
@WebServlet("/student/studentEnrollEnd.do")
public class StudentEnrollEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MybatisService mybatisService = new MybatisServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentEnrollEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String name = request.getParameter("studentName");
		String tel = request.getParameter("studentTel");
		String email = request.getParameter("studentEmail");
		String addr = request.getParameter("studentAddr");
		
		Student s = new Student(name, tel, email, addr);
		
		int result = mybatisService.insertStudent(s);
		String msg = result>0?"학생등록 성공!":"학생등록 실패!";
		
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
