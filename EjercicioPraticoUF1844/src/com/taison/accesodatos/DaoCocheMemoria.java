package com.taison.accesodatos;

import java.util.TreeMap;

import com.taison.entidades.Coche;

//Implementacion de los metodos heredados en la interface DaoCoche
//aqui implementamos los metodos o sea o implementamos o si no tendiriamos definir la clase como abstracta
public class DaoCocheMemoria implements DaoCoche {
	private static final TreeMap<Long, Coche> coches = new TreeMap<>();
    
	//Prueba :  para testear el codigo  
	
	/*
	 * static { coches.put(1L, new Coche(1L, "BCD-123", "BMW", "X5", "Negro",
	 * 1234L,1.345)); coches.put(2L, new Coche(2L, "BCD-123", "Mercedes", "A5",
	 * "Negro",1234L, 1.345)); coches.put(3L, new Coche(3L, "BCD-123", "Mercedes",
	 * "L200", "Negro", 1234L, 1.345));
	 * 
	 * }
	 */
	 
	private DaoCocheMemoria() {

	}

	private static final DaoCocheMemoria INSTANCIA = new DaoCocheMemoria();

	public static DaoCocheMemoria getInstancia() {
		return INSTANCIA;
	}

	@Override
	public Iterable<Coche> obtnerTodos() {

		return coches.values();
	}

	@Override
	public void insertar(Coche coche) {
		Long id = coches.size() > 0 ? coches.lastKey() + 1L : 1L;
		coche.setId(id);
		coches.put(coche.getId(), coche);

	}

}
