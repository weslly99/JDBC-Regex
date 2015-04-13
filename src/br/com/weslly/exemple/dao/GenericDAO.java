package br.com.weslly.exemple.dao;

import java.util.List;

public interface GenericDAO<T> {

	public void add(T t);
	public void update(T t);
	public void remove(long id);
	public T list(long id);
	public List<T> listAll();
}
