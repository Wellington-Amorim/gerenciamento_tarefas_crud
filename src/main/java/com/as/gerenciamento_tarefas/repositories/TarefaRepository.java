package com.as.gerenciamento_tarefas.repositories;

import com.as.gerenciamento_tarefas.models.TarefaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<TarefaModel, Long> {
}
