package com.kh.mybatis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.mybatis.model.service.MybatisService;
import com.kh.mybatis.model.service.MybatisServiceImpl;

/**
 * Servlet implementation class StudentSelectAjax
 */
@WebServlet("/student/studentSelectAjax.do")
public class StudentSelectAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MybatisService mybatisService = new MybatisServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSelectAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentNo = 0;
		try	{
			studentNo = Integer.parseInt(request.getParameter("studentNo"));			
		} catch(NumberFormatException e){
			
		}
		String studentName = "";
		if(studentNo!=0) {
			studentName = mybatisService.selectStudentName(studentNo);
		}
		
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(studentName, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
