package edu.ecjtu.Beans;

import java.util.Date;

public class Employee {
	private Integer id;
	private String lastName;
	private String email;
	private Date birthDay;
	private Date createDate;
	private Department department;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email="
				+ email + ", birthDay=" + birthDay + ", createDate="
				+ createDate + ", department=" + department + "]";
	}

	public Employee() {
		super();
	}

	public Employee(Integer id, String lastName, String email, Date birthDay,
			Date createDate, Department department) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.birthDay = birthDay;
		this.createDate = createDate;
		this.department = department;
	}

}
