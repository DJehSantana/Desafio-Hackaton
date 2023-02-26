package com.stefanini.repository;

import java.util.Objects;

import javax.enterprise.context.ApplicationScoped;

import com.stefanini.dao.GenericDAO;
import com.stefanini.entity.Jogador;

@ApplicationScoped
public class JogadorRepository extends GenericDAO<Jogador, Long> {

    private Jogador jogador;
    public boolean ehAutenticado;

    public boolean autenticarLogin(String nickname, String password) {
        String hql = "SELECT j FROM Jogador j WHERE j.nickname = :nickname";
        this.jogador = this.createQuery(hql).setParameter("nickname", nickname).getSingleResult();
        if (Objects.nonNull(this.jogador)) {
            if (this.jogador.getPassword().equals(password)) {
                this.ehAutenticado = true;
            }
        }
        return this.ehAutenticado;
    }
}
