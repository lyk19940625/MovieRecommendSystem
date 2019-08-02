package com.dao;

import java.util.List;

import com.entity.Step2;

public interface Step2Dao {

	public abstract void save(Step2 transientInstance);

	public abstract void delete(Step2 persistentInstance);

	public abstract Step2 findById(java.lang.String id);

	public abstract List findAll();

	public abstract Step2 merge(Step2 detachedInstance);

}