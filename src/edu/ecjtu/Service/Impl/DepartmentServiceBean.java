package edu.ecjtu.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ecjtu.Beans.Department;
import edu.ecjtu.Dao.Dao;
import edu.ecjtu.Service.MyService;

@Service("deptService")
public class DepartmentServiceBean implements MyService<Department> {

	@Autowired
	private Dao<Department> dao;

	public List<Department> getAll() {
		return dao.queryAll();
	}

	public Department getById(Integer id) {
		return null;
	}

	public void save(Department t) {

	}

	public void delete(Integer id) {

	}

	public void doUpdate(Department t) {

	}

	public Department getByEmail(String email) {
		return null;
	}

}
