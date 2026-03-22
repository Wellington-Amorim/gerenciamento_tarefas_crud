package com.as.gerenciamento_tarefas.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "TBL_TAREFA")
public class TarefaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "descricao_tarefa")
    private String descricao;
    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;
    private Boolean concluida;

    public TarefaModel() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Boolean getConcluida() {
        return concluida;
    }

    public void setConcluida(Boolean concluida) {
        this.concluida = concluida;
    }
}
