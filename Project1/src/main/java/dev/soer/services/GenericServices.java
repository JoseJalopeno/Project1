package dev.soer.services;

import java.util.List;

public interface GenericServices<T> {

	T add(T t);
	T getById(Integer id);
	T get(String pass, String user);
	List<T> getAll();
	T update(T t);
	boolean delete(T t);
}
