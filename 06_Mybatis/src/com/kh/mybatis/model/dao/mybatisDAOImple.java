package com.kh.mybatis.model.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.model.vo.Student;

public class mybatisDAOImple implements MybatisDAO {

	@Override
	public int insertStudent(SqlSession session) {
		int result = session.insert("mybatis.test1"); //namespace.id값 이름 
		System.out.println("result@DAO="+result);
		return result;
	}

	@Override
	public int insertStudent(SqlSession session, String name) {
		
		return session.insert("mybatis.test2",name); // 여기에서 name의 자리 하나만 채울 수 있음.
	}

	@Override
	public int insertStudent(SqlSession session, Student s) {
		return session.insert("mybatis.studentEnrollEnd",s);
	}

	@Override
	public int insertStudent(SqlSession session, Map<String, String> map) {
		return session.insert("mybatis.studentMapEnrollEnd",map);
	}

	@Override
	public int insertStudent(SqlSession session, HashMap<String, Student> map) {
		return session.insert("mybatis.studentMap2EnrollEnd",map);
	}

	@Override
	public int selectStudentCount(SqlSession session) {
		return session.selectOne("mybatis.selectStudentCount");
	}

	@Override
	public String selectStudentName(SqlSession session, int studentNo) {
		return session.selectOne("mybatis.selectStudentName",studentNo);
	}

	@Override
	public int deleteStudentOne(SqlSession session, int studentNo) {
		return session.delete("mybatis.deleteStudentOne", studentNo);
	}

}
