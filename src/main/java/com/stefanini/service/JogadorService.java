package com.stefanini.service;

import com.stefanini.entity.Jogador;
import com.stefanini.exceptions.RegraDeNegocioException;
import com.stefanini.helpers.CriptografarSenha;
import com.stefanini.repository.JogadorRepository;

import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy.Definition.Undefined;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class JogadorService {
    @Inject
    JogadorRepository jogadorRepository;
    @Inject
    CriptografarSenha criptografarSenha;

    public void salvar(Jogador jogador) {
        var senha = jogador.getPassword();

        try {
            senha = criptografarSenha.criptografarSenhaHash(senha);
            jogador.setPassword(senha);
        } catch (Exception e) {
            throw new RegraDeNegocioException("Ocorreu um erro no servidor, por favor tente novamente mais tarde!");
        }

        var saldo = new BigDecimal(1.00);
        if (Objects.isNull(jogador.getSaldo())) {
            jogador.setSaldo(saldo);
        }
        jogadorRepository.save(jogador);
    }

    public Jogador pegarPorId(Long id) {
        var jogador = jogadorRepository.findById(id);
        if (Objects.isNull(jogador)) {
            throw new RegraDeNegocioException("Ocorreu um erro ao buscar o Jogador de id " + id,
                    Response.Status.NOT_FOUND);
        }
        return jogador;
    }

    public void alterar(Jogador jogador) {
        jogadorRepository.update(jogador);
    }

    public void deletar(Long id) {
        jogadorRepository.delete(id);
    }

    public List<Jogador> listarTodos() {
        return jogadorRepository.listAll();
    }
}
