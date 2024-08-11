package com.example.alexandre_teste_ekan.services;

import com.example.alexandre_teste_ekan.domain.dto.DocumentoDTO;
import com.example.alexandre_teste_ekan.domain.entity.Beneficiario;

import java.util.List;

public interface DocumentoService {

     void salvarDocumento(List<DocumentoDTO> listDoc, Beneficiario b);

     List<DocumentoDTO> getDocumentoByBeneficiario(Beneficiario beneficiario);

     void deletarDocumentos(Beneficiario beneficiario);

}
