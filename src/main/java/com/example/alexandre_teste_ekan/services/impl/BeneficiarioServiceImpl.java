package com.example.alexandre_teste_ekan.services.impl;

import com.example.alexandre_teste_ekan.domain.dto.BeneficiarioDTO;
import com.example.alexandre_teste_ekan.domain.dto.DocumentoDTO;
import com.example.alexandre_teste_ekan.domain.entity.Beneficiario;
import com.example.alexandre_teste_ekan.domain.entity.Documento;
import com.example.alexandre_teste_ekan.domain.repository.BeneficiarioRepository;
import com.example.alexandre_teste_ekan.services.BeneficiarioService;
import com.example.alexandre_teste_ekan.services.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
public class BeneficiarioServiceImpl implements BeneficiarioService {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @Autowired
    private DocumentoService documentoService;

    @Override
    @Transactional
    public Beneficiario salvarBeneficiario(BeneficiarioDTO beneficiario) {
        Beneficiario be = Beneficiario
                .builder()
                .dataAtualizacao(beneficiario.getDataAtualizacao())
                .dataInclusao(new Date())
                .dataNascimento(beneficiario.getDataNascimento())
                .nome(beneficiario.getNome())
                .telefone(beneficiario.getTelefone())
                .build();
        be = beneficiarioRepository.save(be);
        documentoService.salvarDocumento(beneficiario.getDocumentos(), be);
        return be;
    }

    @Override
    public List<Beneficiario> resgatarBeneficiarios() {
        return beneficiarioRepository.findAll();
    }

    @Override
    public Beneficiario getBeneficiarioById(Integer id) {
        return beneficiarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Beneficiario não encontrado"));
    }

    @Override
    @Transactional
    public void deletarBeneficiario(Integer id) {
        documentoService.deletarDocumentos(getBeneficiarioById(id));
        beneficiarioRepository.deleteById(id);
    }

    @Override
    public Beneficiario modificarBeneficiario(Beneficiario beneficiarioEditado) {
       return beneficiarioRepository.save(beneficiarioEditado);
    }
}
