package com.example.alexandre_teste_ekan.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Documento")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "tipoDocumento", nullable = false)
    private String tipoDocumento;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "dataInclusao", nullable = false)
    private Date dataInclusao;

    @Column(name = "dataAtualizacao", nullable = false)
    private Date dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "beneficiarioId")
    private Beneficiario beneficiario;
}
