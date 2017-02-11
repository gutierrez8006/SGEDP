package com.acme.pe.persistencia.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author gutie026
 * @param <T>
 * @param <ID>
 */
public interface GenericDAO<T,ID extends Serializable>{
    T create() throws BussinessException;
    void saveOrUpdate(T entity) throws BussinessException;
    T get(ID id) throws BussinessException;
    void delete(ID id) throws BussinessException;
    List<T> findAll() throws BussinessException;
}
