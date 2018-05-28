package com.kh.mybatis.model.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kh.mybatis.model.dao.MybatisDAO;
import com.kh.mybatis.model.dao.mybatisDAOImple;
import com.kh.mybatis.model.vo.Student;

public class MybatisServiceImpl implements MybatisService {
	
	private MybatisDAO mybatisDAO = new mybatisDAOImple();

	private SqlSession getSqlSession() {
		SqlSession session = null;
		String resource = "/mybatis-config.xml"; //classes에 위치함.
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			
			//mybatis-config.xml를 기반으로 공장을 만들어줘
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder(); 
			SqlSessionFactory factory = builder.build(is);
			session = factory.openSession(false); //factory로 부터 발급한 session을 담아준다.
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return session;
	}

	@Override
	public int insertStudent() {
		SqlSession session = getSqlSession();//Connection과 비슷한 역할을 함.
		int result = mybatisDAO.insertStudent(session);
		if(result>0) session.commit();
		else session.rollback();
		
		return result;
	}

	@Override
	public int insertStudent(String name) {
		SqlSession session = getSqlSession();
		int result = mybatisDAO.insertStudent(session,name);
		if(result>0) session.commit();
		else session.rollback();
		
		return result;
	}

	@Override
	public int insertStudent(Student s) {
		SqlSession session = getSqlSession();
		int result = mybatisDAO.insertStudent(session, s);
		if(result>0) session.commit();
		else session.rollback();
		
		return result;
	}

	@Override
	public int insertStudent(Map<String, String> map) {
		SqlSession session = getSqlSession();
		int result = mybatisDAO.insertStudent(session, map);
		if(result>0) session.commit();
		else session.rollback();
		
		return result;
	}

	@Override
	public int insertStudent(HashMap<String, Student> map) {
		SqlSession session = getSqlSession();
		int result = mybatisDAO.insertStudent(session, map);
		if(result>0) session.commit();
		else session.rollback();
		
		return result;
	}

	@Override
	public int selectStudentCount() {
		SqlSession session = getSqlSession();
		int count = mybatisDAO.selectStudentCount(session);//alt+shift+r : 변수명 동시 변경 단축키
		session.close();
		
		return count;
	}

	@Override
	public String selectStudentName(int studentNo) {
		SqlSession session = getSqlSession();
		String studentName = mybatisDAO.selectStudentName(session, studentNo);
		session.close();
		
		return studentName;
	}

	@Override
	public int deleteStudentOne(int studentNo) {
		SqlSession session = getSqlSession();
		int result = mybatisDAO.deleteStudentOne(session, studentNo);
		if(result>0) session.commit();
		else session.rollback();
		
		return result;
	}

	
}
