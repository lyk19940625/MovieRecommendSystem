package com.dao;

import java.util.List;

import com.entity.Step1;

public interface Step1Dao {

	public abstract void save(Step1 transientInstance);

	public abstract void delete(Step1 persistentInstance);

	public abstract Step1 findById(java.lang.String id);

	public abstract List findAll();

	public abstract Step1 merge(Step1 detachedInstance);

}