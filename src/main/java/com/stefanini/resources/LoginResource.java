package com.stefanini.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.dto.LoginDTO;
import com.stefanini.exceptions.RegraDeNegocioException;
import com.stefanini.helpers.CriptografarSenha;
import com.stefanini.service.LoginService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/login")
public class LoginResource {

    @Inject
    LoginService loginService;
    @Inject
    CriptografarSenha criptografarSenha;

    private boolean logado = false;

    @POST
    public Response autenticarLogin(LoginDTO loginDTO) {
        String password = loginDTO.getPassword();
        String nickname = loginDTO.getNickname();
        try {
            password = criptografarSenha.criptografarSenhaHash(password);
        } catch (Exception e) {
            throw new RegraDeNegocioException("Ocorreu um erro no servidor, por favor tente novamente mais tarde!");
        }
        this.logado = loginService.validarLogin(nickname, password);
        return Response.status(Response.Status.OK).build();
    }

}
