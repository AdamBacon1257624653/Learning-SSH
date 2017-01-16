package edu.ecjtu.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ecjtu.Beans.Employee;
import edu.ecjtu.Dao.Dao;
import edu.ecjtu.Service.MyService;

@Service("empService")
public class EmployeeServiceBean implements MyService<Employee> {

	@Autowired
	private Dao<Employee> dao;

	public List<Employee> getAll() {
		return dao.queryAll();
	}

	public Employee getById(Integer id) {
		return null;
	}

	public void save(Employee employee) {
		dao.add(employee);
	}

	public void delete(Integer id) {
		dao.remove(id);
	}

	public void doUpdate(Employee employee) {
		dao.update(employee);
	}

	public Employee getByEmail(String email){
		return dao.queryByEmail(email);
	}
}
