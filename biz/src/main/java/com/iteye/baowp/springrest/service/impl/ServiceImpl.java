package com.iteye.baowp.springrest.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.transform.ResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.iteye.baowp.springrest.repository.Dao;
import com.iteye.baowp.springrest.service.Service;
import com.iteye.baowp.springrest.support.PaginationSupport;

/**
 * @author baowp
 * @date 2010-08
 * @param <E>
 * @param <D>
 */
public class ServiceImpl<E, D extends Dao<E>> implements Service<E> {

	protected final org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(getClass());

	protected D dao;

	@Autowired
	protected void setDao(D dao) {
		this.dao = dao;
	}

	public Serializable save(E entity) {
		return dao.save(entity);
	}

	public void delete(E entity) {
		dao.delete(entity);
	}

	public void deleteAll(Collection<E> entities) {
		dao.deleteAll(entities);
	}

	public E get(Serializable id) {
		return (E) dao.get(id);
	}

	public void load(E entity, Serializable id) {
		dao.load(entity, id);
	}

	public void refresh(E entity) {
		dao.refresh(entity);
	}

	public List<E> findByExample(E example) {
		return dao.findByExample(example);
	}

	public List<E> loadAll() {
		return dao.loadAll();

	}

	public void saveOrUpdate(E entity) {
		dao.saveOrUpdate(entity);

	}

	public void update(E entity) {
		dao.update(entity);
	}

	public void saveOrUpdateAll(Collection<E> entities) {
		dao.saveOrUpdateAll(entities);
	}

	public List<E> find(String hql, Object... values) {
		return dao.find(hql, values);
	}

	public int bulkUpdate(String hql, Object... values) {
		return dao.bulkUpdate(hql, values);
	}

	public List<E> query(String sql, RowMapper<E> rowMapper) {
		return dao.query(sql, rowMapper);
	}

	public int[] batchUpdate(String[] sql) {
		return dao.batchUpdate(sql);
	}

	public PaginationSupport<E> findPageByCriteria(
			DetachedCriteria detachedCriteria) {
		return dao.findPageByCriteria(detachedCriteria);
	}

	public PaginationSupport<E> findPageByCriteria(
			DetachedCriteria detachedCriteria, int startIndex) {
		return dao.findPageByCriteria(detachedCriteria, startIndex);

	}

	public PaginationSupport<E> findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int startIndex) {
		return dao.findPageByCriteria(detachedCriteria, pageSize, startIndex);
	}

	public PaginationSupport<E> findPageByCriteria(
			DetachedCriteria detachedCriteria, int pageSize, int startIndex,
			ResultTransformer resultTransformer) {
		return dao.findPageByCriteria(detachedCriteria, pageSize, startIndex,
				resultTransformer);
	}

	public List<E> findAllByCriteria(DetachedCriteria detachedCriteria) {
		return dao.findAllByCriteria(detachedCriteria);

	}

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		return dao.getCountByCriteria(detachedCriteria);

	}
}
