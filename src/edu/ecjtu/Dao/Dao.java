package edu.ecjtu.Dao;

import java.util.List;

import edu.ecjtu.Beans.Employee;

public interface Dao<T> {
	/**
	 * 根据用户ID查询Employee记录
	 * 
	 * @return 返回所有的Employee记录
	 */
	public List<T> queryAll();

	/**
	 * 根据用户ID查询Employee记录
	 * 
	 * @param id
	 *            需要查询的Employee的ID
	 * @return 返回Employee记录
	 */
	public T queryById(Integer id);

	/**
	 * 增加Employee记录
	 * 
	 * @param employee
	 *            即将插入的Employee对象
	 */
	public void add(T t);

	/**
	 * 删除Employee记录
	 * 
	 * @param employee
	 *            即将删除的Employee对象
	 */
	public void remove(Integer id);

	/**
	 * 修改Employee记录
	 * 
	 * @param employee
	 *            需要修改的对象
	 */
	public void update(T t);

	public T queryByEmail(String email);
}
