package com.stefanini.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.stefanini.helpers.CriptografarSenha;
import com.stefanini.repository.JogadorRepository;

@ApplicationScoped
public class LoginService {

    @Inject
    JogadorRepository jogadorRepository;
    @Inject
    CriptografarSenha criptografarSenha;

}
