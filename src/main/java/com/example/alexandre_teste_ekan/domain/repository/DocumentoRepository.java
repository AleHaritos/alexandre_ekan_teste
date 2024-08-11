package com.example.alexandre_teste_ekan.domain.repository;

import com.example.alexandre_teste_ekan.domain.entity.Beneficiario;
import com.example.alexandre_teste_ekan.domain.entity.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Integer> {

    List<Documento> findAllByBeneficiario(Beneficiario beneficiario);

    void deleteAllByBeneficiario(Beneficiario beneficiario);

}
