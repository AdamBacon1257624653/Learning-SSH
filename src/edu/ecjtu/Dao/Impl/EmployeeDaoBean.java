package edu.ecjtu.Dao.Impl;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.ecjtu.Beans.Employee;
import edu.ecjtu.Dao.Dao;

@Repository
// ("empdao")
public class EmployeeDaoBean extends BaseDaoBean implements Dao<Employee> {

	public List<Employee> queryAll() {
		String hql = "FROM Employee e LEFT OUTER JOIN FETCH e.department";
		return getSession().createQuery(hql).list();
	}

	public Employee queryById(Integer id) {
		return null;
	}

	public void add(Employee employee) {
		getSession().saveOrUpdate(employee);
	}

	public void remove(Integer id) {
		String hql = "DELETE FROM Employee e WHERE id=?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}

	public void update(Employee employee) {
		String cellname = "";
		Object propertyvalue = "";
		try {
			PropertyDescriptor[] propertyDescriptors = Introspector
					.getBeanInfo(employee.getClass()).getPropertyDescriptors();
			for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
				Method getMethod = propertyDescriptor.getReadMethod();
				if (!getMethod.getName().equals("getClass")
						&& !getMethod.getName().equals("getId")) {
					propertyvalue = getMethod.invoke(employee, new Object[] {});
					if (propertyvalue != null
							&& !propertyvalue.toString().trim().equals("")) {
						cellname = propertyDescriptor.getName();
						break;
					}
				}

			}

			if (!cellname.equals("department")) {
				String hql = "UPDATE Employee e SET e." + cellname
						+ " =? WHERE e.id=?";
				if (cellname.equals("birthDay")) {
					getSession().createQuery(hql)
							.setDate(0, (Date) propertyvalue)
							.setInteger(1, employee.getId()).executeUpdate();
				} else {
					getSession().createQuery(hql)
							.setString(0, propertyvalue.toString())
							.setInteger(1, employee.getId()).executeUpdate();
				}
			} else {
				String hql = "UPDATE Employee e SET e." + cellname + ".id"
						+ " =? WHERE e.id=?";
				getSession().createQuery(hql)
						.setInteger(0, employee.getDepartment().getId())
						.setInteger(1, employee.getId()).executeUpdate();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public Employee queryByEmail(String email) {
		String hql = "FROM Employee e WHERE e.email=?";
		return (Employee) getSession().createQuery(hql).setString(0, email)
				.uniqueResult();
	}
}
