package com.dao;

import java.util.List;

import com.entity.Movie;

public interface MovieDao {

	public abstract void save(Movie transientInstance);

	public abstract void delete(Movie persistentInstance);

	public abstract Movie findById(java.lang.Integer id);

	public abstract List findByMname(Object mname);

	public abstract List findAll();

	boolean importMovie(List<Movie> movies);
	
	public abstract Movie merge(Movie detachedInstance);

}