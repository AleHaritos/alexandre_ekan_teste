package com.example.alexandre_teste_ekan.rest.controller;

import com.example.alexandre_teste_ekan.domain.dto.BeneficiarioDTO;
import com.example.alexandre_teste_ekan.domain.dto.DocumentoDTO;
import com.example.alexandre_teste_ekan.domain.entity.Beneficiario;
import com.example.alexandre_teste_ekan.domain.entity.Documento;
import com.example.alexandre_teste_ekan.domain.repository.DocumentoRepository;
import com.example.alexandre_teste_ekan.services.BeneficiarioService;
import com.example.alexandre_teste_ekan.services.DocumentoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beneficiario")
public class BeneficiarioController {

    @Autowired
    public BeneficiarioService beneficiarioService;

    @Autowired
    public DocumentoService documentoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "Cadastrar Beneficiarios junto com os documentos", summary = "Cadastro de Beneficiarios")
    public Beneficiario inserirBeneficiario(@RequestBody @Valid BeneficiarioDTO beneficiario) {
        return beneficiarioService.salvarBeneficiario(beneficiario);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Listar todos beneficiario cadastrados", summary = "Listar todos beneficiarios")
    public List<Beneficiario> listarBeneficiarios() {
        return beneficiarioService.resgatarBeneficiarios();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Listar documentos pelo Id do beneficiario", summary = "Listar documento pelo Id do beneficiario")
    public List<DocumentoDTO> listarDocumentosPorIdBeneficiario(@PathVariable("id") Integer beneficiarioId) {
        Beneficiario beneficiario = beneficiarioService.getBeneficiarioById(beneficiarioId);
        return documentoService.getDocumentoByBeneficiario(beneficiario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(description = "Deletar Beneficiario por Id e todos documentos referentes a ele", summary = "Deletar beneficiario por Id")
    public void deletarBeneficiario(@PathVariable("id") Integer beneficiarioId) {
        beneficiarioService.deletarBeneficiario(beneficiarioId);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Modificar Beneficiario seguindo o padrão do payload", summary = "Modificar Beneficiario")
    public Beneficiario modificarBeneficiario(@RequestBody @Valid Beneficiario beneficiario) {
        return beneficiarioService.modificarBeneficiario(beneficiario);
    }


}
