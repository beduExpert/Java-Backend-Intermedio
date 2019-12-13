package org.bedu.ejemplo03.protos.repository;

import java.util.Map;

import org.bedu.ejemplo03.protos.models.LoginProto.Student;

public class VirtualStudentRepository {
	private Map<Integer, Student> students;

	public VirtualStudentRepository(Map<Integer, Student> students) {
		this.students = students;
	}

	public Student getStudent(int id) {
		return students.get(id);
	}
}
