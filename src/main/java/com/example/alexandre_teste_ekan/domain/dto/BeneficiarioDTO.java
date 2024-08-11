package com.example.alexandre_teste_ekan.domain.dto;

import com.example.alexandre_teste_ekan.domain.entity.Documento;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BeneficiarioDTO {

    private Integer id;

    @NotNull
    private String nome;

    @NotNull
    private String telefone;

    @NotNull
    private Date dataNascimento;

    @NotNull
    private Date dataAtualizacao;

    private List<DocumentoDTO> documentos;
}
