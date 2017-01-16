package edu.ecjtu.Service;

import java.util.List;

public interface MyService<T> {
	/**
	 * 根据用户ID查询Employee记录
	 * 
	 * @return 返回所有的Employee记录
	 */
	public List<T> getAll();

	/**
	 * 根据用户ID查询Employee记录
	 * 
	 * @param id
	 *            需要查询的Employee的ID
	 * @return 返回Employee记录
	 */
	public T getById(Integer id);

	/**
	 * 增加Employee记录
	 * 
	 * @param employee
	 *            即将插入的Employee对象
	 */
	public void save(T t);

	/**
	 * 删除Employee记录
	 * 
	 * @param employee
	 *            即将删除的Employee对象ID
	 */
	public void delete(Integer id);

	/**
	 * 修改Employee记录
	 * 
	 * @param employee
	 *            需要修改的对象
	 */
	public void doUpdate(T t);
	
	/**
	 * 根据邮箱查询对像
	 * @param email
	 * @return
	 */
	public T getByEmail(String email);
}
