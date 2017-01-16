package edu.ecjtu.Beans;

import java.util.Set;

public class Department {
	private Integer id;
	private String name;
	private Set<Employee> employees;
	
	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
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

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

	public Department() {
		super();
	}

	public Department(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}
