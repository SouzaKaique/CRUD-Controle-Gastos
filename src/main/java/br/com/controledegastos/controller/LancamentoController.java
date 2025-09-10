package br.com.controledegastos.controller;

import br.com.controledegastos.model.Lancamento;
import br.com.controledegastos.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @GetMapping
    public List<Lancamento> listarLancamentos() {
        List<Lancamento> lancamentos = lancamentoRepository.findAll();
        lancamentos.sort(Comparator.comparing(Lancamento::getData).reversed());
        return lancamentos;
    }

    @PostMapping
    public Lancamento addLancamento(@RequestBody Lancamento novoLancamento) {
        return lancamentoRepository.save(novoLancamento);
    }

    @DeleteMapping("/{id}")
    public void deleteLancamento(@PathVariable Long id) {
        lancamentoRepository.deleteById(id);
    }
}
