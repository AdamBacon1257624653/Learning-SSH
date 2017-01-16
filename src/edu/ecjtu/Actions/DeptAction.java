package edu.ecjtu.Actions;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import edu.ecjtu.Beans.Department;
import edu.ecjtu.Service.MyService;

public class DeptAction extends ActionSupport {

	private static final long serialVersionUID = 2L;
	private List<Department> departments;
	@Autowired
	private MyService<Department> deptService;

	public DeptAction() {
		System.out.println("构造函数创建对象........................");
	}

	public String list() throws Exception {
		departments = deptService.getAll();
		return "list";
	}

	public List<Department> getDepartments() {
		return departments;
	}

	/**
	 * getter方法
	 * 
	 * @return
	 */

	/**
	 * setter方法
	 */

}
