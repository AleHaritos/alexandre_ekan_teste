package com.example.alexandre_teste_ekan.services;

import com.example.alexandre_teste_ekan.domain.dto.BeneficiarioDTO;
import com.example.alexandre_teste_ekan.domain.entity.Beneficiario;

import java.util.List;

public interface BeneficiarioService {

     Beneficiario salvarBeneficiario(BeneficiarioDTO beneficiario);

     List<Beneficiario> resgatarBeneficiarios();

     Beneficiario getBeneficiarioById(Integer id);

     void deletarBeneficiario(Integer id);

     Beneficiario modificarBeneficiario(Beneficiario beneficiario);

}
