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
 * Servlet implementation class MybatisTestServlet1
 */
@WebServlet("/test1.do")
public class MybatisTestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MybatisService mybatisService = new MybatisServiceImpl();
    //MybatisService라는 인터페이스의 다양한 자식 객체를 사용할 수 있기에 인터페이스를 이용한다. 예) List 인터페이스의 ArrayList와 같은 List 구현 클래스들
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MybatisTestServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html, charset=utf-8");
		//비지니스 로직 처리
		int result = mybatisService.insertStudent();
		String msg = result>0?"test1성공":"test1실패";
		response.getWriter().append("Served at: ")
							.append(request.getContextPath())
							.append("<br>"+msg);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
