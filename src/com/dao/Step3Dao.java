package com.dao;

import java.util.List;

import com.entity.Step3;

public interface Step3Dao {

	public abstract void save(Step3 transientInstance);

	public abstract void delete(Step3 persistentInstance);

	public abstract Step3 findById(java.lang.String id);

	public abstract List findAll();

	public abstract Step3 merge(Step3 detachedInstance);

}