package com.sistemaerp.spring_erp.controller;

import com.sistemaerp.spring_erp.model.Venda;
import com.sistemaerp.spring_erp.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaRepository vendaRepository;

    // GET /vendas → lista todas as vendas
    @GetMapping
    public List<Venda> listarTodas() {
        return vendaRepository.findAll();
    }

    // GET /vendas/{id} → busca uma venda específica
    @GetMapping("/{id}")
    public ResponseEntity<Venda> buscarPorId(@PathVariable Long id) {
        Optional<Venda> venda = vendaRepository.findById(id);
        return venda.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /vendas → cria uma nova venda
    @PostMapping
    public ResponseEntity<Venda> criarVenda(@RequestBody Venda venda) {
        Venda novaVenda = vendaRepository.save(venda);
        return ResponseEntity.ok(novaVenda);
    }

    // PUT /vendas/{id} → atualiza uma venda
    @PutMapping("/{id}")
    public ResponseEntity<Venda> atualizarVenda(@PathVariable Long id, @RequestBody Venda dados) {
        return vendaRepository.findById(id)
                .map(venda -> {
                    venda.setCliente(dados.getCliente());
                    venda.setData(dados.getData());
                    venda.setItens(dados.getItens());
                    return ResponseEntity.ok(vendaRepository.save(venda));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /vendas/{id} → deleta uma venda
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVenda(@PathVariable Long id) {
        if (vendaRepository.existsById(id)) {
            vendaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
