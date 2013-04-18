package com.iteye.baowp.springrest.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.transform.ResultTransformer;
import org.springframework.jdbc.core.RowMapper;

import com.iteye.baowp.springrest.support.PaginationSupport;

public interface Service<E> {

	public Serializable save(E entity);

	public void delete(E entity);

	public void deleteAll(Collection<E> entites);

	public E get(Serializable id);

	public void load(E entity, Serializable id);

	public void refresh(E entity);

	public List<E> findByExample(E example);

	public List<E> loadAll();

	public void saveOrUpdate(E entity);

	public void update(E entity);

	public void saveOrUpdateAll(Collection<E> entities);

	public List<E> find(String hql, Object... values);

	public int bulkUpdate(String hql, Object... values);

	public List<E> query(String sql, RowMapper<E> rowMapper);

	public int[] batchUpdate(String[] sql);

	public PaginationSupport<E> findPageByCriteria(
			DetachedCriteria detachedCriteria);

	public PaginationSupport<E> findPageByCriteria(
			DetachedCriteria detachedCriteria, int startIndex);

	public PaginationSupport<E> findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int startIndex);

	public PaginationSupport<E> findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int startIndex,
			ResultTransformer resultTransformer);

	public List<E> findAllByCriteria(DetachedCriteria detachedCriteria);

	public int getCountByCriteria(DetachedCriteria detachedCriteria);

}
