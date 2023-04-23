package com.caio.padroesprojetosgofspring.repository;

import com.caio.padroesprojetosgofspring.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
