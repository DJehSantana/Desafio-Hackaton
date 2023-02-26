package com.stefanini.repository;

import javax.enterprise.context.ApplicationScoped;

import com.stefanini.dao.GenericDAO;
import com.stefanini.entity.Jogador;

@ApplicationScoped
public class JogadorRepository extends GenericDAO<Jogador, Long> {

}
