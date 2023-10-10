package com.company.nomeprojeto.tarefas.api;

import com.company.nomeprojeto.tarefas.dto.TarefaDTO;
import com.company.nomeprojeto.tarefas.facade.TarefasFacede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
@Controller
@RequestMapping(value = "/tarefas", produces = MediaType.APPLICATION_JSON_VALUE)


public class TarefasApi {
    @Autowired
    private TarefasFacede tarefasFacede;

    @PostMapping
    @ResponseBody
    public TarefaDTO criar(@RequestBody TarefaDTO tarefaDTO) {
        return tarefasFacede.criar(tarefaDTO);
    }
    @PutMapping("/{tarefaId}")
    @ResponseBody
    public TarefaDTO atualizar(@PathVariable("tarefaId") Long tarefaId,
                               @RequestBody TarefaDTO tarefaDTO) {
        return tarefasFacede.atualizar(tarefaDTO, tarefaId);
    }
    @GetMapping
    @ResponseBody
    public List<TarefaDTO> getAll() {
        return tarefasFacede.getAll();
    }
    @DeleteMapping("/{tarefaId}")
    @ResponseBody
    public String deletar(@PathVariable("tarefaId") Long tarefaId) {
        return  tarefasFacede.delete(tarefaId);
    }

}
