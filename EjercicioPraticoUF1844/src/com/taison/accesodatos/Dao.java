package com.taison.accesodatos;

//interface Dao con sus metodos definidos que se van implementar en las classes que quieran
//usar este interface.
public interface Dao<T> {
	Iterable<T> obtnerTodos();
	void insertar(T objeto);
}
