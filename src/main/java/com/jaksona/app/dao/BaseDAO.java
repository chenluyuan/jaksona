package com.jaksona.app.dao;

import org.springframework.dao.DataAccessException;

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
	T selectByPrimaryKey(Long id) throws DataAccessException;

	/**
	 * 根据主键ID插入
	 * @param entity
	 */
	int insertSelective(T entity) throws DataAccessException;

	/**
	 * 根据主键ID物理删除
	 * @param id
	 */
	int deleteByPrimaryKey(Long id) throws DataAccessException;

	/**
	 * 根据主键ID逻辑删除
	 * @param id
	 */
	int updateActiveByPrimaryKey(Long id) throws DataAccessException;

	/**
	 * 根据实体查询
	 * @return
	 */
	List<T> selectByEntity(T entity) throws DataAccessException;

	/**
	 * 根据ID更新实体
	 * @param entity
	 * @return
	 */
	int updateByPrimaryKeySelective(T entity) throws DataAccessException;
}
