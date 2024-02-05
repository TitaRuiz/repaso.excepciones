package com.corenetworks.repaso.excepciones.servicio.impl;

import com.corenetworks.repaso.excepciones.repositorio.IGenericoRepositorio;
import com.corenetworks.repaso.excepciones.servicio.ICRUD;

import java.util.List;

public  abstract class CRUDImpl<T,ID> implements ICRUD<T,ID> {

    protected abstract IGenericoRepositorio<T,ID> getRepo();
    @Override
    public List<T> listarTodos() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T listarUno(ID id) throws Exception {
        return getRepo().findById(id).orElse(null);
    }

    @Override
    public T insertar(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T modificar(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public void eliminar(ID id) throws Exception {
          getRepo().deleteById(id);
    }
}
