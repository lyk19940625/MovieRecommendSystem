package com.dao;

import java.util.List;

import com.entity.Step4;

public interface Step4Dao {

	public abstract void save(Step4 transientInstance);

	public abstract void delete(Step4 persistentInstance);

	public abstract Step4 findById(java.lang.String id);

	public abstract List findAll();

	public abstract Step4 merge(Step4 detachedInstance);

}