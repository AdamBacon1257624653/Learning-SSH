package edu.ecjtu.Actions;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import edu.ecjtu.Beans.Department;
import edu.ecjtu.Beans.Employee;
import edu.ecjtu.Service.MyService;

public class EmployeeAction extends ActionSupport implements RequestAware,
		ModelDriven<Employee>, Preparable {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> requestMap;
	private Integer id;
	private String cellname;
	private String cellValue;
	private InputStream inputStream;
	private Integer deptId;
	private Employee model = null;
	@Autowired
	private MyService<Employee> empService;
	@Autowired
	private MyService<Department> deptService;

	public String list() {
		List<Employee> employees = empService.getAll();
		requestMap.put("employees", employees);
		return "list";
	}

	public void prepareUpdateDept() {
		model.setDepartment(new Department(this.deptId, null));
	}

	/**
	 * 验证邮箱email:value,
	 * 
	 * @throws Exception
	 */
	public String ValidateEmail() throws Exception {
		String email = model.getEmail();
		if (!email
				.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")) {
			inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
		} else {
			Employee employee = empService.getByEmail(email);
			if (employee != null) {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} else {
				inputStream = new ByteArrayInputStream("2".getBytes("UTF-8"));
			}
		}
		return "stream";
	}

	/**
	 * 更新员工部门信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String UpdateDept() throws Exception {
		empService.doUpdate(model);
		try {
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (Exception e) {
			inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
		}
		return "stream";
	}

	public String delete() {
		empService.delete(id);
		try {
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (Exception e) {
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (Exception e1) {
				throw new RuntimeException(e);
			}
			throw new RuntimeException(e);
		}
		return "stream";
	}

	public String update() {
		PropertyDescriptor[] propertyDescriptors;
		try {
			Employee employee = new Employee();
			propertyDescriptors = Introspector.getBeanInfo(Employee.class)
					.getPropertyDescriptors();
			for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
				if (cellname.equalsIgnoreCase(propertyDescriptor.getName())) {
					if (cellname.equals("birthDay")) {
						propertyDescriptor.getWriteMethod().invoke(
								employee,
								new SimpleDateFormat("yyyy-MM-dd")
										.parse(cellValue));
					} else {
						propertyDescriptor.getWriteMethod().invoke(employee,
								cellValue);
					}
					break;
				}
			}
			employee.setId(id);
			empService.doUpdate(employee);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			return "stream";
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String input() {
		requestMap.put("departments", deptService.getAll());
		return "input";
	}

	public void prepareSave() {
		model.setCreateDate(new Date());
	}

	public String save() {
		empService.save(model);
		System.out.println(model);
		return "save";
	}

	/**
	 * getter方法
	 * 
	 * @return
	 */
	public InputStream getInputStream() {
		return inputStream;
	}

	/**
	 * setter方法
	 * 
	 * @param cellValue
	 */

	public void setCellValue(String cellValue) {
		this.cellValue = cellValue;
	}

	public void setCellname(String cellname) {
		this.cellname = cellname;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setRequest(Map<String, Object> requestMap) {
		this.requestMap = requestMap;
	}

	public void prepare() throws Exception {
	}

	public Employee getModel() {
		if (model == null) {
			model = new Employee();
		}
		return model;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

}
