package com.stefanini.resources;

import com.stefanini.entity.Jogador;
import com.stefanini.service.JogadorService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/jogador")
public class JogadorResource {

    @Inject
    private JogadorService jogadorService;

    @GET
    @Path("/{id}")
    public Response pegarPorId(@PathParam("id") Long id) {
        return Response.status(Response.Status.OK).entity(jogadorService.pegarPorId(id)).build();
    }

    @GET
    @Path("/todos")
    public Response listarTodos() {
        return Response.status(Response.Status.OK).entity(jogadorService.listarTodos()).build();
    }

    @POST
    public Response salvar(@Valid Jogador jogador) {
        jogadorService.salvar(jogador);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    public Response alterar(@Valid Jogador jogador) {
        jogadorService.alterar(jogador);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        jogadorService.deletar(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
