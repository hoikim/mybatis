package com.kh.mybatis.model.service;

import java.util.HashMap;
import java.util.Map;

import com.kh.mybatis.model.vo.Student;

public interface MybatisService {

	int insertStudent();

	int insertStudent(String name);

	int insertStudent(Student s);

	int insertStudent(Map<String, String> map);

	int insertStudent(HashMap<String, Student> map);

	int selectStudentCount();

	String selectStudentName(int studentNo);

	int deleteStudentOne(int studentNo);
	
}
