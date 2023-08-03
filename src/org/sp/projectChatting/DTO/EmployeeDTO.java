package org.sp.projectChatting.DTO;

public class EmployeeDTO {
	private int empno;
	private String name;
	private String job;
	private String email;
	private String number;
	private String pass;
	private String company_name;
	DeptDTO deptDTO;  //deptDTO 소유해야함
	StatusDTO statusDTO; //statusDTO 소유해야함
	
	
	
	//게터 세터
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	

	
	
}
