package com.ferreteria.Ferreteria.repository.dto;

import com.ferreteria.Ferreteria.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository  extends JpaRepository<Producto,Long> {
}
