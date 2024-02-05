package com.corenetworks.repaso.excepciones.servicio.impl;

import com.corenetworks.repaso.excepciones.modelo.Producto;
import com.corenetworks.repaso.excepciones.repositorio.IGenericoRepositorio;
import com.corenetworks.repaso.excepciones.repositorio.IProductoRepositorio;
import com.corenetworks.repaso.excepciones.servicio.IProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServicioImpl extends CRUDImpl<Producto,Integer> implements IProductoServicio {
    @Autowired
    private IProductoRepositorio repo;

    @Override
    protected IGenericoRepositorio<Producto, Integer> getRepo() {
        return repo;
    }
}
