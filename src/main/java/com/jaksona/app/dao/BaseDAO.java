package com.jaksona.app.dao;

import java.util.List;

/**
 * 数据访问对象基类
 * @author jaksona
 */
public interface BaseDAO<T> {
	/**
	 * 根据主键ID查询
	 * @param id
	 * @return
	 */
	T selectByPrimaryKey(Long id);

	/**
	 * 根据主键ID插入
	 * @param entity
	 */
	int insertSelective(T entity);

	/**
	 * 根据主键ID物理删除
	 * @param id
	 */
	int physicDeleteByPrimaryKey(Long id);

	/**
	 * 根据主键ID逻辑删除
	 * @param id
	 */
	int logicDeleteByPrimaryKey(Long id);

	/**
	 * 根据实体查询
	 * @return
	 */
	List<T> selectByEntity(T entity);

	/**
	 * 根据ID更新实体
	 * @param entity
	 * @return
	 */
	int updateByIdSelective(T entity);

	/**
	 * 查询所有
	 * @return
	 */
	List<T> selectAll();
}
