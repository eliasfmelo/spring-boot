package com.project.Api_spring.Service;

import com.project.Api_spring.Model.Atendente;
import com.project.Api_spring.Repository.AtendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtendenteService {

    @Autowired
    private AtendenteRepository atendenteRepository;

    public List<Atendente> listarTodos() {
        return atendenteRepository.findAll();
    }

    public Atendente buscarPorId(Long id) {
        return atendenteRepository.findById(id)
                 .orElseThrow(RecursoNaoEncontradoException::new);
    }

    public Atendente salvar(Atendente atendente) {
        return atendenteRepository.save(atendente);
    }

    public Atendente atualizar(Long id, Atendente atendenteAtualizado) {
        Atendente atendente = buscarPorId(id);
        atendente.setNome(atendenteAtualizado.getNome());
        atendente.setEmail(atendenteAtualizado.getEmail());
        atendente.setPassword(atendenteAtualizado.getPassword());
        return atendenteRepository.save(atendente);
    }

    public void deletar(Long id) {
        atendenteRepository.deleteById(id);
    }
}
