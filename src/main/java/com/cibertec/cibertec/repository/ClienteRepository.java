package com.cibertec.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.cibertec.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    // Query methods
    public abstract List<Cliente> findByDni(String dni);
    public abstract List<Cliente> findByNombresLike(String nombres);

    // JPQL
    @Query("SELECT c FROM Cliente c WHERE c.dni = ?1 AND c.nombres = ?2")
    public abstract List<Cliente> findByDniAndNombres(String dni, String nombres);
}
