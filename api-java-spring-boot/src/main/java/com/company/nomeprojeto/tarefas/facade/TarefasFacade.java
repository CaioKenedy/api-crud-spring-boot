package com.company.nomeprojeto.tarefas.facade;

import com.company.nomeprojeto.tarefas.dto.TarefaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Service
public class TarefasFacade {
    private static final Map<Long, TarefaDTO> tarefas = new HashMap<>();

    public TarefaDTO criar(TarefaDTO tarefaDTO) {
        Long proximoID = tarefas.keySet().size() + 1L;
        tarefaDTO.setId(proximoID);
        tarefas.put(proximoID, tarefaDTO);
        return tarefaDTO;
    }
    public TarefaDTO atualizar (TarefaDTO tarefaDTO, Long tarefaId) {
        tarefas.put(tarefaId, tarefaDTO);
        return tarefaDTO;
    }

    public TarefaDTO getById (Long tarefaId) {
        return tarefas.get(tarefaId);
    }

    public List<TarefaDTO> getAll () {
        return new ArrayList<>(tarefas.values());
    }

    public String delete (Long tarefaId) {
        tarefas.remove(tarefaId);
        return "DELETED";
    }
}
