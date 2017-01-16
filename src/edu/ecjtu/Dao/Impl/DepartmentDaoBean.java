package edu.ecjtu.Dao.Impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.ecjtu.Beans.Department;
import edu.ecjtu.Dao.Dao;

@Repository//("deptdao")
public class DepartmentDaoBean extends BaseDaoBean implements Dao<Department> {

	public List<Department> queryAll() {
		String hql = "FROM Department";
		return getSession().createQuery(hql).list();
	}

	public Department queryById(Integer id) {
		return null;
	}

	public void add(Department employee) {

	}

	public void remove(Integer id) {

	}

	public void update(Department employee) {

	}

	public Department queryByEmail(String email) {
		return null;
	}

}
