package com.example.alexandre_teste_ekan.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "beneficiario")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Beneficiario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Integer id;

    @Column(name = "nome", nullable = false)
    @NotNull
    private String nome;

    @Column(name = "telefone", nullable = false)
    @NotNull
    private String telefone;

    @Column(name = "dataNascimento", nullable = false)
    @NotNull
    private Date dataNascimento;

    @Column(name = "dataInclusao", nullable = false)
    @NotNull
    private Date dataInclusao;

    @Column(name = "dataAtualizacao", nullable = false)
    @NotNull
    private Date dataAtualizacao;

    @OneToMany(mappedBy = "beneficiario", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Documento> documentos = new ArrayList<>();
}
