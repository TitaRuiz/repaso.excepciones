package com.corenetworks.repaso.excepciones.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenericoRepositorio<T,ID> extends JpaRepository<T,ID> {
}
