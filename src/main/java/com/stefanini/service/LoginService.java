package com.stefanini.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.stefanini.repository.JogadorRepository;

@ApplicationScoped
public class LoginService {

    private boolean loginEValido = false;

    @Inject
    JogadorRepository jogadorRepository;

    public boolean validarLogin(String nickname, String password) {
        this.loginEValido = this.jogadorRepository.autenticarLogin(nickname, password);
        return loginEValido;
    }

}
