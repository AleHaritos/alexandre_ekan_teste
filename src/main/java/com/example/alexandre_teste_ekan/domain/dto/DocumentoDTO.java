package com.example.alexandre_teste_ekan.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentoDTO {

    private Integer id;

    @NotNull
    private String tipoDocumento;

    @NotNull
    private String descricao;

    @NotNull
    private Date dataAtualizacao;

    private Date dataInclusao;


}
