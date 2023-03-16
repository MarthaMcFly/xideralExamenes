package com.reference.constructor;

//inventamos el trifunction con un predicate: 
@FunctionalInterface
public interface TriFunction<T,U,V,R> {
	R apply(T t, U u, V v);
}
