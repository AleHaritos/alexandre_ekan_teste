package com.example.alexandre_teste_ekan.services.impl;

import com.example.alexandre_teste_ekan.domain.dto.DocumentoDTO;
import com.example.alexandre_teste_ekan.domain.entity.Beneficiario;
import com.example.alexandre_teste_ekan.domain.entity.Documento;
import com.example.alexandre_teste_ekan.domain.repository.DocumentoRepository;
import com.example.alexandre_teste_ekan.services.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentoServiceImpl implements DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    @Override
    public void salvarDocumento(List<DocumentoDTO> documentos, Beneficiario b) {
        documentos.forEach(doc -> {
            documentoRepository.save(Documento
                    .builder()
                    .tipoDocumento(doc.getTipoDocumento())
                    .dataAtualizacao(doc.getDataAtualizacao())
                    .dataInclusao(new Date())
                    .beneficiario(b)
                    .descricao(doc.getDescricao())
                    .build());

        });
    }

    @Override
    public List<DocumentoDTO> getDocumentoByBeneficiario(Beneficiario beneficiario) {
        List<Documento> documentos = documentoRepository.findAllByBeneficiario(beneficiario);
        return converterDocumento(documentos);
    }

    @Override
    public void deletarDocumentos(Beneficiario beneficiario) {
        documentoRepository.deleteAllByBeneficiario(beneficiario);
    }

    private List<DocumentoDTO> converterDocumento(List<Documento> documentos) {
       return documentos.stream().map(doc -> {
           return DocumentoDTO
                  .builder()
                  .tipoDocumento(doc.getTipoDocumento())
                  .dataAtualizacao(doc.getDataAtualizacao())
                  .dataInclusao(doc.getDataInclusao())
                  .id(doc.getId())
                  .descricao(doc.getDescricao())
                  .build();
        }).collect(Collectors.toList());
    }

}
