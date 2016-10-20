package com.mewe.model;

public class Student {
	
	private String fName;
	private String lName;
	private int age;
	private int id;
	public Student(String fName, String lName, int age, int id) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.age = age;
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Student [fName=" + fName + ", lName=" + lName + ", age=" + age + ", id=" + id + "]";
	}
	
	

}
