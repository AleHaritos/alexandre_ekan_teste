package com.example.alexandre_teste_ekan.domain.repository;

import com.example.alexandre_teste_ekan.domain.entity.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Integer> {



}
