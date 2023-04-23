package com.caio.padroesprojetosgofspring.repository;

import com.caio.padroesprojetosgofspring.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String> {
}
