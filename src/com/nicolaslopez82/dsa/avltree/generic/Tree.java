package com.nicolaslopez82.dsa.avltree.generic;

public interface Tree<T> {
	public void insert(T data);
	public void traverse();
	public void delete(T data);
}
