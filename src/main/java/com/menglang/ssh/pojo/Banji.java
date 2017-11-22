package com.menglang.ssh.pojo;

import java.util.HashSet;
import java.util.Set;

public class Banji {

	private Integer id;
	private String name;
	private Set<Student> students = new HashSet<Student>();

	public Banji() {
		super();
	}

	public Banji(Integer id, String name, Set<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.students = students;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Banji [id=" + id + ", name=" + name + "]";
	}

}
