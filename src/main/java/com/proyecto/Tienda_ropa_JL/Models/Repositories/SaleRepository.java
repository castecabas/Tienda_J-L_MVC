package com.proyecto.Tienda_ropa_JL.Models.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.Tienda_ropa_JL.Models.Entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

}
